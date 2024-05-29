package com.example.clean_playground.internal

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.clean_playground.di.ChecklistDomainComponent
import com.example.clean_playground.di.DaggerChecklistDataComponent
import com.example.clean_playground.di.DaggerFeatureChecklistComponent
import com.q2ve.personal_multiapp.feature_checklist.internal.feed.items.AbstractChecklistItem
import com.example.clean_playground.internal.feed.items.ItemSummary
import com.example.clean_playground.internal.feed.items.ItemTask
import dagger.Reusable
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.buffer
import kotlinx.coroutines.launch
import javax.inject.Inject


internal class ChecklistViewModel: BaseViewModel<ChecklistViewModel.State>() {

	data class State (
		val feedItems: List<AbstractChecklistItem>
	): BaseState() {
		companion object {
			val EMPTY = State(emptyList())
		}
	}

	override val currentStatePrivate = MutableLiveData<State>().apply { value = State.EMPTY }

	@Inject
	@Reusable
	lateinit var useCases: ChecklistUseCases

	init {
		val t = ChecklistDomainComponent.initAndGet(DaggerChecklistDataComponent.create().getTasksRepository())!!
		DaggerFeatureChecklistComponent
			.factory()
			.build(t.getAddTaskUseCase(), t.getGetTasksFlowUseCase())
			.inject(this)

		val items = listOf(
			ItemSummary(123456789),
			ItemTask("Понюхать бебру", true),
			ItemSummary(987654321),
		)
		currentStatePrivate.apply {
			value = value?.copy(feedItems = items)
		}

		viewModelScope.launch(Dispatchers.Default) {
			useCases.getTasksFlow.getTasksFlow()
				.buffer()
				.collect { list ->
					currentStatePrivate.apply {
						postValue(value?.copy(feedItems = list.map { ItemTask.fromDto(it) }))
					}
				}
		}
	}

	fun addTaskButtonPressed(taskText: String) {
//		val description = taskText.trim()
//		if (description.isNotEmpty()) {
//			repository.insertAndReplace(DtoTask(description))
//		}
//		testDiffUtilsAndDb()
	}
}

abstract class BaseState

abstract class BaseViewModel<State: BaseState>: ViewModel() {
	protected abstract val currentStatePrivate: MutableLiveData<State>
	val currentState: LiveData<State> by lazy { currentStatePrivate }
}
