package com.example.formula1app.viewModel

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.ViewModel

class ViewModelHome : ViewModel() {
    fun replaceFragment(fragment: Fragment, fragmentManager: FragmentManager, frameLayout: Int) {
        fragmentManager.beginTransaction().replace(frameLayout, fragment)
            .addToBackStack(null).commit()
    }
}