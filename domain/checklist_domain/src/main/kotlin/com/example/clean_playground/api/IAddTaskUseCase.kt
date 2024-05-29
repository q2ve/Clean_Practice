package com.example.clean_playground.api

import com.q2ve.personal_multiapp.entities.DtoTask

interface IAddTaskUseCase {
	suspend fun insertAndReplace(task: DtoTask): Result<Unit>
}