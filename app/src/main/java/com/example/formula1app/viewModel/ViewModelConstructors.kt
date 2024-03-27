package com.example.formula1app.viewModel

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.ComposeView
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.formula1app.R
import com.example.formula1app.model.ApiClient
import com.example.formula1app.model.constructorModel.Constructors
import com.example.formula1app.model.driverModel.Constructor
import com.example.formula1app.model.driverModel.Driver
import com.example.formula1app.model.driverModel.DriverStanding
import com.example.formula1app.ui.theme.formulaFont
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

}