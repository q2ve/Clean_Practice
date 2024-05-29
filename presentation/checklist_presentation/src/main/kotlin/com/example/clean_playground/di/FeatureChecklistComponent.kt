package com.example.clean_playground.di

import com.example.clean_playground.api.ChecklistDomainApi
import com.example.clean_playground.api.IAddTaskUseCase
import com.example.clean_playground.api.IGetTasksFlowUseCase
import com.example.clean_playground.api.ITasksRepository
import com.example.clean_playground.internal.ChecklistUseCases
import com.example.clean_playground.internal.ChecklistViewModel
import dagger.BindsInstance
import dagger.Component

@Component(modules = [FeatureChecklistModule::class])
internal interface FeatureChecklistComponent {
	@Component.Factory
	interface Factory {
		fun build(@BindsInstance useCase1: IAddTaskUseCase, @BindsInstance useCase2: IGetTasksFlowUseCase): FeatureChecklistComponent
	}

	fun inject(vm: ChecklistViewModel)
}