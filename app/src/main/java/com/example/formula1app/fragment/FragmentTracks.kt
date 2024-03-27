package com.example.formula1app.fragment

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
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
import androidx.compose.material3.Button
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
import androidx.fragment.app.viewModels
import com.example.formula1app.MapsActivity
import com.example.formula1app.R
import com.example.formula1app.model.trackModel.Race
import com.example.formula1app.ui.theme.formulaFont
import com.example.formula1app.viewModel.ViewModelTracks
import java.text.Normalizer

class FragmentTracks : Fragment() {
    private val viewModel by viewModels<ViewModelTracks>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel.getTracks()
    }


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return ComposeView(requireContext()).apply {
            setContent {
                Column {
                    val getResult =
                        rememberLauncherForActivityResult(
                            ActivityResultContracts.StartActivityForResult()
                        ) {
                        }
                    Text(
                        text = "Tracks",
                        fontSize = 20.sp,
                        fontFamily = formulaFont,
                        fontWeight = FontWeight.Bold,
                        color = Color.White,
                        modifier = Modifier.padding(start = 20.dp, top = 30.dp)
                    )
                    DisplayPilot()
                    Spacer(modifier = Modifier.height(50.dp))
                    Column(
                        modifier = Modifier.fillMaxSize(),
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        Text(
                            text = "2024 seasons", fontSize = 15.sp,
                            fontFamily = formulaFont,
                            fontWeight = FontWeight.Normal,
                            color = Color.White
                        )

                        Button(onClick = {
                            val listTrackLocations = mutableListOf<Pair<Double, Double>>()

                            for (race in viewModel.listTrack.value?.mRData?.raceTable?.races!!) {
                                race.circuit?.location?.let {
                                    it.lat?.let { it1 ->
                                        it.long?.let { it2 ->
                                            Pair(
                                                it1.toDouble(),
                                                it2.toDouble()
                                            )
                                        }
                                    }
                                        ?.let { it2 -> listTrackLocations.add(it2) }
                                }
                            }

                            val intent =
                                Intent(context, MapsActivity::class.java)
                            intent.putExtra("listLocationTrack", ArrayList(listTrackLocations))

                            getResult.launch(intent)

                        }) {
                            Text(text = "Show all tracks")
                        }
                    }

                }
            }
        }
    }

    @Composable
    fun DisplayPilot() {
        viewModel.listTrack.value?.let { listPilot ->
            if (!listPilot.mRData?.raceTable?.races.isNullOrEmpty()) {
                LazyRow(
                    Modifier
                        .padding(top = 60.dp),
                    horizontalArrangement = Arrangement.spacedBy(16.dp)
                ) {
                    itemsIndexed(listPilot.mRData?.raceTable?.races!!) { index, race ->
                        if (index == 0) {
                            DisplayPilotCard(
                                race = race,
                                modifier = Modifier.padding(start = 20.dp)
                            )
                        } else {
                            DisplayPilotCard(race = race, modifier = Modifier)
                        }
                    }
                }
            }
        }
    }

    @Composable
    fun DisplayPilotCard(race: Race, modifier: Modifier) {
        val getResult =
            rememberLauncherForActivityResult(
                ActivityResultContracts.StartActivityForResult()
            ) {
            }

        var drawable: Int =
            requireContext().resources.getIdentifier(
                race.raceName?.lowercase()?.replace(' ', '_')?.let { removeAccents(it) },
                "drawable",
                requireContext().packageName
            )

        
        if (drawable == 0) {
            drawable = R.drawable.driver_button_image
        }

        Box(
            modifier = modifier
                .height(410.dp)
                .width(350.dp)
                .clip(RoundedCornerShape(40.dp))
                .background(Color.Red)
                .clickable {
                    val intent =
                        Intent(context, MapsActivity::class.java)

                    intent.putExtra("long", race.circuit?.location?.long)
                    intent.putExtra("lat", race.circuit?.location?.lat)

                    getResult.launch(intent)
                }
        ) {
            Image(
                painter = painterResource(id = drawable),
                contentDescription = "hamilton image",
                modifier = Modifier
                    .fillMaxSize(),
                contentScale = ContentScale.Crop
            )
            Row(
                modifier = Modifier
                    .fillMaxSize()
                    .background(Color.Black.copy(alpha = 0.4f))
            ) {
            }

            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(start = 20.dp),
                horizontalAlignment = Alignment.End,
                verticalArrangement = Arrangement.Bottom
            ) {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Row(
                        horizontalArrangement = Arrangement.Start,
                        verticalAlignment = Alignment.Bottom
                    ) {
                        Text(
                            text = race.raceName!!,
                            fontSize = 22.sp,
                            fontFamily = formulaFont,
                            fontWeight = FontWeight.Bold,
                            color = Color.White
                        )
                    }
                }
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 15.dp, bottom = 20.dp),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Row {
                        Text(
                            text = "Round " + race.round.toString(), fontFamily = formulaFont,
                            fontWeight = FontWeight.Normal,
                            color = Color.White
                        )
                    }
                }

            }
        }
    }

    private fun removeAccents(input: String): String {
        val normalizedString = Normalizer.normalize(input, Normalizer.Form.NFD)
        val pattern = "\\p{InCombiningDiacriticalMarks}+".toRegex()
        return pattern.replace(normalizedString, "")
    }
}