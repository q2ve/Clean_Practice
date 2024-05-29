package com.example.clean_playground.api

import com.q2ve.personal_multiapp.entities.DtoTask
import kotlinx.coroutines.flow.Flow

interface IRoomClient {
	fun getTasksFlow(): Flow<List<DtoTask>>
	suspend fun insertAndReplace(task: DtoTask): Result<Unit>
}