package com.q2ve.personal_multiapp.feature_checklist.internal.feed.items


internal interface AbstractChecklistItem {
	fun areItemsTheSame(anotherItem: AbstractChecklistItem): Boolean
	fun areContentsTheSame(anotherItem: AbstractChecklistItem): Boolean
}