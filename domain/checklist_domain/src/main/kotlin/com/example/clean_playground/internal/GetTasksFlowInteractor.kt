package com.example.clean_playground.internal

import com.example.clean_playground.api.IGetTasksFlowUseCase
import com.example.clean_playground.api.ITasksRepository
import com.q2ve.personal_multiapp.entities.DtoTask
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

internal class GetTasksFlowInteractor @Inject constructor(private val repository: ITasksRepository): IGetTasksFlowUseCase {
	override fun getTasksFlow(): Flow<List<DtoTask>> {
		return repository.getTasksFlow()
	}
}