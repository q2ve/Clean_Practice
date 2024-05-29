package com.example.clean_playground.internal

import com.example.clean_playground.api.IRetrofitClient
import com.example.clean_playground.api.IRoomClient
import com.example.clean_playground.api.ITasksRepository
import com.q2ve.personal_multiapp.entities.DtoTask
import dagger.Lazy
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

internal class TasksRepository @Inject constructor(
	private val room: Lazy<IRoomClient>,
	private val retrofit: Lazy<IRetrofitClient>
): ITasksRepository {

	override fun getTasksFlow(): Flow<List<DtoTask>> = room.get().getTasksFlow()

	override suspend fun insertAndReplace(task: DtoTask): Result<Unit> = room.get().insertAndReplace(task)
}