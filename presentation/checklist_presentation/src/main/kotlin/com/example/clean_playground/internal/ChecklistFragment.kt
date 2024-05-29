package com.example.clean_playground.internal

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.example.clean_playground.databinding.FragmentChecklistStartBinding
import com.hannesdorfmann.adapterdelegates4.AsyncListDifferDelegationAdapter
import com.example.clean_playground.internal.feed.ChecklistDiffUtilCallback
import com.example.clean_playground.internal.feed.items.ItemSummary
import com.example.clean_playground.internal.feed.items.ItemTask

internal class ChecklistFragment: Fragment() {

	private val viewModel: ChecklistViewModel by viewModels() //lazy

	private var binding: FragmentChecklistStartBinding? = null

	override fun onCreateView(
		inflater: LayoutInflater,
		container: ViewGroup?,
		savedInstanceState: Bundle?
	): View {
		val binding = FragmentChecklistStartBinding.inflate(inflater)

		binding.newTaskButton.setOnClickListener {
			viewModel.addTaskButtonPressed(
				binding.newTaskInputField.editableText?.toString() ?: ""
			)
			binding.newTaskInputField.editableText.clear()
		}

		val adapter = AsyncListDifferDelegationAdapter(
			ChecklistDiffUtilCallback(),
			ItemSummary.delegate(),
			ItemTask.delegate(),
		)

		binding.feedRecycler.adapter = adapter
		viewModel.currentState.observe(viewLifecycleOwner) { adapter.items = it.feedItems }

		return binding.root
	}

	override fun onDestroyView() {
		binding = null
		super.onDestroyView()
	}
}