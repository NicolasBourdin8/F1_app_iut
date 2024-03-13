package com.example.formula1app.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.material3.Text
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.ComposeView
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.example.formula1app.R
import com.example.formula1app.viewModel.ViewModelDrivers
import com.example.formula1app.viewModel.ViewModelHome

class FragmentDrivers : Fragment() {
    private val viewModel by viewModels<ViewModelDrivers>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel.getDrivers()
    }
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return ComposeView(requireContext()).apply {
            val formulaFont = FontFamily(
                Font(R.font.formularegular, FontWeight.Normal),
                Font(R.font.formulablack, FontWeight.Black),
                Font(R.font.formulabold, FontWeight.Bold),
                Font(R.font.formulaboldweb, FontWeight.SemiBold),
                Font(R.font.formulaitalic, FontWeight.Normal, FontStyle.Italic),
                Font(R.font.formulawide, FontWeight.Thin)
            )
            setContent {
                Text(text = "driver", color = Color.White)
            }
        }
    }
}