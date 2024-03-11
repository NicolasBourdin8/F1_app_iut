package com.example.formula1app.fragment

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
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
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
import androidx.fragment.app.Fragment
import com.example.formula1app.R

class FragmentHome : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return ComposeView(requireContext()).apply {
            setContent {
                Column(
                    modifier = Modifier.verticalScroll(rememberScrollState())
                ) {
                    HomeContent()
                }
            }
        }
    }

    @Composable
    fun HomeContent() {
        ContainerMainCategories("Drivers", R.drawable.driver_button_image)
        ContainerMainCategories("Constructors", R.drawable.constructors_button_image)
        ContainerMainCategories("Tracks", R.drawable.tracks_button_image)
    }

    @Composable
    fun ContainerMainCategories(text: String, image: Int) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(275.dp)
                .padding(start = 20.dp, end = 20.dp, top = 20.dp)
                .clip(RoundedCornerShape(40.dp))
                .background(Color.DarkGray)
        ) {
            Image(
                painter = painterResource(id = image),
                contentDescription = "hamilton image",
                modifier = Modifier.fillMaxSize(),
                contentScale = ContentScale.Crop
            )
            Row(
                modifier = Modifier
                    .fillMaxSize()
                    .background(Color.Black.copy(alpha = 0.4f))
            ) {

            }
            Row(
                verticalAlignment = Alignment.Top,
                horizontalArrangement = Arrangement.Start,
                modifier = Modifier.padding(start = 20.dp, top = 10.dp)
            ) {
                Text(
                    text = text,
                    fontSize = 20.sp,
                    color = Color.White,
                    fontWeight = FontWeight.SemiBold
                )
            }
        }
    }
}