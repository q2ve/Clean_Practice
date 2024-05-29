package com.example.clean_playground.di

import com.example.clean_playground.api.ChecklistDomainApi
import com.example.clean_playground.api.ITasksRepository
import dagger.BindsInstance
import dagger.Component

//@Component(dependencies = [ChecklistDomainDependencies::class])
@Component(modules = [ChecklistDomainModule::class])
interface ChecklistDomainComponent: ChecklistDomainApi {

	@Component.Factory
	interface Factory {
		fun build(@BindsInstance repository: ITasksRepository): ChecklistDomainComponent
	}

	companion object {
		@Volatile
		private var component: ChecklistDomainComponent? = null

		fun initAndGet(repository: ITasksRepository): ChecklistDomainComponent? =
			when (component) {
				null -> {
					synchronized(this) {
						if (component == null) {
							component = DaggerChecklistDomainComponent.factory().build(repository)
						}
						component
					}
				}
				else -> component
			}
	}
}