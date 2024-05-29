package com.example.clean_playground.internal.feed

import androidx.recyclerview.widget.DiffUtil
import com.q2ve.personal_multiapp.feature_checklist.internal.feed.items.AbstractChecklistItem

internal class ChecklistDiffUtilCallback: DiffUtil.ItemCallback<AbstractChecklistItem>() {
	override fun areItemsTheSame(
		oldItem: AbstractChecklistItem,
		newItem: AbstractChecklistItem
	): Boolean {
		return newItem.areItemsTheSame(oldItem)
	}

	override fun areContentsTheSame(
		oldItem: AbstractChecklistItem,
		newItem: AbstractChecklistItem
	): Boolean {
		return newItem.areContentsTheSame(oldItem)
	}
}