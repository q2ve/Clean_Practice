package com.example.clean_playground.di

import com.example.clean_playground.api.IAddTaskUseCase
import com.example.clean_playground.api.IGetTasksFlowUseCase
import com.example.clean_playground.api.ITasksRepository
import com.example.clean_playground.internal.AddTaskInteractor
import com.example.clean_playground.internal.GetTasksFlowInteractor
import dagger.Binds
import dagger.Module
import dagger.Provides

@Module
internal class ChecklistDomainModule {
	@Provides
	fun getAddTaskUseCase(repository: ITasksRepository): IAddTaskUseCase {
		return AddTaskInteractor(repository)
	}

	@Provides
	fun getGetTasksFlowUseCase(repository: ITasksRepository): IGetTasksFlowUseCase {
		return GetTasksFlowInteractor(repository)
	}
}