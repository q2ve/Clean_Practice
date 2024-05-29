package com.example.clean_playground.di

import dagger.Component

@Component(modules = [ChecklistDataModule::class])
interface ChecklistDataComponent: TasksApi