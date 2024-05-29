package com.example.clean_playground.internal

import com.example.clean_playground.api.IAddTaskUseCase
import com.example.clean_playground.api.IGetTasksFlowUseCase
import javax.inject.Inject

data class ChecklistUseCases @Inject constructor(
	val getTasksFlow: IGetTasksFlowUseCase,
	val addTask: IAddTaskUseCase,
)