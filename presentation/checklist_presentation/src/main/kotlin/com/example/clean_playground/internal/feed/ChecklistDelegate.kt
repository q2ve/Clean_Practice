package com.example.clean_playground.internal.feed

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.viewbinding.ViewBinding
import com.hannesdorfmann.adapterdelegates4.dsl.AdapterDelegateViewBindingViewHolder
import com.hannesdorfmann.adapterdelegates4.dsl.adapterDelegateViewBinding
import com.q2ve.personal_multiapp.feature_checklist.internal.feed.items.AbstractChecklistItem

internal inline fun <reified I: AbstractChecklistItem, reified V: ViewBinding> checklistDelegate(
	noinline inflate: (layoutInflater: LayoutInflater, parent: ViewGroup, attach: Boolean) -> V,
	noinline binding: AdapterDelegateViewBindingViewHolder<I, V>.() -> Unit
) = adapterDelegateViewBinding<I, AbstractChecklistItem, V>(
	viewBinding = { layoutInflater, parent ->
		inflate.invoke(layoutInflater, parent, false)
	},
	block = { bind { binding.invoke(this) } }
)