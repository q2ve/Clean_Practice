package com.example.clean_playground.di

import com.example.clean_playground.api.IRetrofitClient
import com.example.clean_playground.api.IRoomClient
import com.example.clean_playground.api.ITasksRepository
import com.example.clean_playground.internal.RetrofitClient
import com.example.clean_playground.internal.RoomClient
import com.example.clean_playground.internal.TasksRepository
import dagger.Binds
import dagger.Module

@Module
internal interface ChecklistDataModule {
	@Binds
	fun getTasksRepository(repository: TasksRepository): ITasksRepository

	@Binds
	fun getRoom(roomClient: RoomClient): IRoomClient

	@Binds
	fun getRetrofit(retrofitClient: RetrofitClient): IRetrofitClient
}