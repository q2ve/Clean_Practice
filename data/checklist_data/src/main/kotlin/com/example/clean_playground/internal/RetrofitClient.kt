package com.example.clean_playground.internal

import com.example.clean_playground.api.IRetrofitClient
import com.q2ve.personal_multiapp.entities.Dto
import com.q2ve.personal_multiapp.entities.DtoTask
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

internal class RetrofitClient @Inject constructor(): IRetrofitClient {
	override fun getTasksFlow(): Flow<List<DtoTask>> {
		val list1 = listOf(
			DtoTask(1, "First unchecked", false),
			DtoTask(2, "Second checked", true),
			DtoTask(3, "Third checked", true),
			DtoTask(4, "Fourth unchecked", false),
		)
		val list2 = listOf(
			DtoTask(1, "BEBRA checked", true),
			DtoTask(2, "BEBRA checked", true),
			DtoTask(4, "BEBRA unchecked", false),
		)

		return flow {
			delay(10000)
			emit(list1)
			delay(10000)
			emit(list2)
		}
	}

	override suspend fun insertAndReplace(task: DtoTask): Result<Unit> {
		return Result.success(Unit)
	}
}