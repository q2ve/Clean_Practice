package com.example.clean_playground.di

import com.example.clean_playground.api.ITasksRepository

interface TasksApi {
	fun getTasksRepository(): ITasksRepository
}