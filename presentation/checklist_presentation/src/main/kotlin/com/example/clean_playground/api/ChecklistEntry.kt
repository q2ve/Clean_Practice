package com.example.clean_playground.api

import androidx.fragment.app.Fragment
import com.example.clean_playground.internal.ChecklistFragment

interface ChecklistEntry {
	companion object {
		fun getChecklistFragment(): Fragment = ChecklistFragment()
	}
}