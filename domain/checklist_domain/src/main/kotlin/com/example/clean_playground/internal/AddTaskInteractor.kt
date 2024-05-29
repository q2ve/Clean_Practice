package com.example.clean_playground.internal

import com.example.clean_playground.api.IAddTaskUseCase
import com.example.clean_playground.api.ITasksRepository
import com.q2ve.personal_multiapp.entities.DtoTask
import javax.inject.Inject

internal class AddTaskInteractor @Inject constructor(private val repository: ITasksRepository): IAddTaskUseCase {
	override suspend fun insertAndReplace(task: DtoTask): Result<Unit> {
		return repository.insertAndReplace(task)
	}
}