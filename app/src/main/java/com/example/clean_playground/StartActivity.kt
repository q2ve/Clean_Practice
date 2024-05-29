package com.example.clean_playground

import android.annotation.SuppressLint
import android.content.Context
import android.os.Bundle
import android.view.Gravity
import android.view.View
import android.view.ViewGroup.LayoutParams
import android.widget.FrameLayout
import android.widget.LinearLayout
import android.widget.TextView
import androidx.fragment.app.FragmentActivity
import com.example.clean_playground.api.ChecklistEntry

class StartActivity: FragmentActivity() {
	private val buttonsList = listOf<Pair<String, () -> Unit>>(
		"Тудушник, лол" to ::openTodo,
	)

	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)

		setContentView(getView(this))
	}

	@SuppressLint("ResourceType")
	private fun getView(context: Context): View {
		fun getButton(text: String, onClickAction: () -> Unit): View {
			return TextView(context).apply {
				layoutParams = LinearLayout.LayoutParams(
					LayoutParams.MATCH_PARENT, LayoutParams.MATCH_PARENT
				).apply { weight = 1F }
				gravity = Gravity.CENTER
				this.text = text

				setOnClickListener { onClickAction.invoke() }
			}
		}
		val buttonsContainer = LinearLayout(context)
		buttonsContainer.apply {
			layoutParams = LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.MATCH_PARENT)
			orientation = LinearLayout.HORIZONTAL
			buttonsList.forEach { pair ->
				addView(getButton(text = pair.first, onClickAction = pair.second))
			}
		}
		val rootContainer = FrameLayout(context).apply {
			id = 1234
			layoutParams = LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.MATCH_PARENT)
			addView(buttonsContainer)
		}

		return rootContainer
	}

	@SuppressLint("ResourceType")
	private fun openTodo() {
		supportFragmentManager.beginTransaction().apply {
			add(
				1234,
				ChecklistEntry.getChecklistFragment()
			)
			addToBackStack(null)
			commit()
		}
	}
}
