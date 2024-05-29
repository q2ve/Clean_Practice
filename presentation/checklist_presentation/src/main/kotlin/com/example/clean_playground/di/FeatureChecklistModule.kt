package com.example.clean_playground.di

import com.example.clean_playground.api.IAddTaskUseCase
import com.example.clean_playground.api.IGetTasksFlowUseCase
import com.example.clean_playground.internal.ChecklistUseCases
import dagger.Module
import dagger.Provides

@Module
class FeatureChecklistModule {
	@Provides
	fun getChecklistUseCases(
		useCase1: IGetTasksFlowUseCase,
		useCase2: IAddTaskUseCase
	): ChecklistUseCases {
		return ChecklistUseCases(useCase1, useCase2)
	}
}