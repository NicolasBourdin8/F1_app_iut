package com.example.formula1app.viewModel

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.formula1app.model.ApiClient
import com.example.formula1app.model.constructorModel.ConstructorStanding
import com.example.formula1app.model.constructorModel.Constructors
import kotlinx.coroutines.launch

class ViewModelConstructors : ViewModel() {
    var listPilot = mutableStateOf<Constructors?>(null)

    fun getConstructors() {
        viewModelScope.launch {
            try {
                val apiService = ApiClient.create("https://ergast.com/api/f1/current/")
                listPilot.value = apiService.getConstructors()
            } catch (e: Exception) {
                println(e.message)
            }
        }
    }

    fun changeSort() {
        val tempListPilot = mutableListOf<ConstructorStanding>()

        val list =
            listPilot.value?.mRData?.standingsTable?.standingsLists?.get(0)?.constructorStandings!!
        for (index in list.indices) {
            tempListPilot.add(list[list.size - index - 1])
        }


        listPilot.value?.mRData?.standingsTable?.standingsLists?.get(0)?.constructorStandings =
            tempListPilot.toList()
    }

}