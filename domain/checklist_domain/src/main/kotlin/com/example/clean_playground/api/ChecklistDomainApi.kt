package com.example.clean_playground.api

interface ChecklistDomainApi {
	fun getAddTaskUseCase(): IAddTaskUseCase
	fun getGetTasksFlowUseCase(): IGetTasksFlowUseCase
}