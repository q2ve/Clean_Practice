package com.example.clean_playground.internal.feed.items

import com.example.clean_playground.databinding.ItemSummaryBinding
import com.q2ve.personal_multiapp.entities.DtoTask
import com.example.clean_playground.internal.feed.checklistDelegate
import com.q2ve.personal_multiapp.feature_checklist.internal.feed.items.AbstractChecklistItem

internal data class ItemTask(
//	val icon: TaskType.icon,
	val description: String,
	val isChecked: Boolean,
//	val onItemClicked: (ItemTask) -> Unit,
//	val onCheckboxClicked: (ItemTask, Boolean) -> Unit,
): AbstractChecklistItem {
	override fun areItemsTheSame(anotherItem: AbstractChecklistItem): Boolean {
		return anotherItem == this
	}
	override fun areContentsTheSame(anotherItem: AbstractChecklistItem) =
		areItemsTheSame(anotherItem)

	companion object {
		fun delegate() =
			checklistDelegate<ItemSummary, ItemSummaryBinding>(ItemSummaryBinding::inflate) {
				binding.summaryText.text = item.totalCount.toString()
			}

		fun fromDto(dto: DtoTask) = ItemTask(dto.description, dto.isChecked)
	}
}
