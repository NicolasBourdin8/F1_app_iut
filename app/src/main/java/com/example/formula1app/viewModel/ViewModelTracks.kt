package com.example.formula1app.viewModel

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.formula1app.model.ApiClient
import com.example.formula1app.model.trackModel.Track
import kotlinx.coroutines.launch

class ViewModelTracks : ViewModel() {
    var listTrack = mutableStateOf<Track?>(null)
    fun getTracks() {
        viewModelScope.launch {
            try {
                val apiService = ApiClient.create("https://ergast.com/api/f1/")
                listTrack.value = apiService.getTracks()
            } catch (e: Exception) {
                println(e.message)
            }
        }
    }
}