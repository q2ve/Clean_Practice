package com.example.clean_playground.api

import com.q2ve.personal_multiapp.entities.DtoTask
import kotlinx.coroutines.flow.Flow

interface IGetTasksFlowUseCase {
	fun getTasksFlow(): Flow<List<DtoTask>>
}