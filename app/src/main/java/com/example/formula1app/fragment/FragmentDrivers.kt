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
import com.example.formula1app.R
import com.example.formula1app.model.driverModel.Constructor
import com.example.formula1app.model.driverModel.Driver
import com.example.formula1app.model.driverModel.DriverStanding
import com.example.formula1app.ui.theme.formulaFont
import com.example.formula1app.viewModel.ViewModelDrivers
import java.text.Normalizer

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
            setContent {
                Column {
                    Text(
                        text = "Drivers",
                        fontSize = 20.sp,
                        fontFamily = formulaFont,
                        fontWeight = FontWeight.Bold,
                        color = Color.White,
                        modifier = Modifier.padding(start = 20.dp, top = 30.dp)
                    )
                    DisplayPilot()
                    Spacer(modifier = Modifier.height(50.dp))
                    Row(
                        modifier = Modifier.fillMaxSize(),
                        horizontalArrangement = Arrangement.Center
                    ) {
                        Text(
                            text = "2024 seasons", fontSize = 15.sp,
                            fontFamily = formulaFont,
                            fontWeight = FontWeight.Normal,
                            color = Color.White
                        )
                    }

                }
            }
        }
    }

    private fun createFakeList(): List<DriverStanding> {
        val fakeList: MutableList<DriverStanding> = mutableListOf()

        for (i in 1..5) {
            val driverStanding = DriverStanding()
            val driver = Driver()
            driver.familyName = "Jean"
            driver.givenName = "Louis"
            driver.nationality = "France"
            driverStanding.driver = driver

            val listConstructor: MutableList<Constructor> = mutableListOf()
            val constructor = Constructor()
            constructor.name = "Fiat"
            listConstructor.add(constructor)
            driverStanding.constructors = listConstructor
            driverStanding.wins = "20"
            driverStanding.points = (10 * i).toString()
            driverStanding.positionText = i.toString()
            driverStanding.position = i.toString()

            fakeList.add(driverStanding)
        }

        return fakeList
    }

    @Composable
    fun DisplayPilotNoAPI() {

        val listDriver = createFakeList()

        LazyRow(
            Modifier
                .padding(top = 60.dp),
            horizontalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            itemsIndexed(listDriver) { index, pilot ->
                if (index == 0) {
                    DisplayPilotCard(
                        pilot = pilot,
                        modifier = Modifier.padding(start = 20.dp)
                    )
                } else {
                    DisplayPilotCard(pilot = pilot, modifier = Modifier)
                }
            }
        }
    }

    @Composable
    fun DisplayPilot() {
        viewModel.listPilot.value?.let { listPilot ->
            if (!listPilot.mRData?.standingsTable?.standingsLists?.get(0)?.driverStandings.isNullOrEmpty()) {
                LazyRow(
                    Modifier
                        .padding(top = 60.dp),
                    horizontalArrangement = Arrangement.spacedBy(16.dp)
                ) {
                    itemsIndexed(listPilot.mRData?.standingsTable?.standingsLists?.get(0)?.driverStandings!!) { index, pilot ->
                        if (index == 0) {
                            DisplayPilotCard(
                                pilot = pilot,
                                modifier = Modifier.padding(start = 20.dp)
                            )
                        } else {
                            DisplayPilotCard(pilot = pilot, modifier = Modifier)
                        }
                    }
                }
            }
        }
    }

    @Composable
    fun DisplayPilotCard(pilot: DriverStanding, modifier: Modifier) {
        Box(
            modifier = modifier
                .height(410.dp)
                .width(350.dp)
                .clip(RoundedCornerShape(40.dp))
                .background(Color.Red)
        ) {
            var nameImage: String =
                (pilot.driver?.givenName?.lowercase()
                    ?: "") + "_" + (pilot.driver?.familyName?.lowercase()
                    ?: "")


            var drawable: Int =
                requireContext().resources.getIdentifier(
                    removeAccents(nameImage),
                    "drawable",
                    requireContext().packageName
                )


            if (drawable == 0) {
                drawable = R.drawable.driver_button_image
            }
            Image(
                painter = painterResource(drawable),
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

            Row(
                horizontalArrangement = Arrangement.End,
                verticalAlignment = Alignment.Top,
                modifier = Modifier
                    .fillMaxSize()
                    .padding(end = 40.dp, top = 20.dp)
            ) {

                Text(
                    text = pilot.position.orEmpty(),
                    fontSize = 25.sp,
                    fontFamily = formulaFont,
                    fontWeight = FontWeight.Bold,
                    color = Color.White
                )
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
                        pilot.driver?.givenName?.let {
                            Text(
                                text = it,
                                fontSize = 22.sp,
                                fontFamily = formulaFont,
                                fontWeight = FontWeight.Bold,
                                color = Color.White
                            )
                        }
                        Spacer(modifier = Modifier.width(10.dp))
                        pilot.driver?.familyName?.let {
                            Text(
                                text = it,
                                fontSize = 22.sp,
                                fontFamily = formulaFont,
                                fontWeight = FontWeight.Normal,
                                color = Color.White
                            )
                        }
                    }
                    pilot.points?.let {
                        Text(
                            text = "$it pts",
                            fontSize = 16.sp,
                            fontFamily = formulaFont,
                            fontWeight = FontWeight.Normal,
                            color = Color.White,
                            modifier = Modifier.padding(end = 20.dp, top = 5.dp)
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
                        Image(
                            painter = painterResource(id = R.drawable.ic_trophy),
                            contentDescription = "icon trophy",
                            modifier = Modifier.width(20.dp)
                        )
                        Spacer(modifier = Modifier.width(10.dp))
                        Text(
                            text = pilot.wins.orEmpty(), fontFamily = formulaFont,
                            fontWeight = FontWeight.Normal,
                            color = Color.White
                        )
                    }
                    pilot.constructors?.get(0)?.name?.let {
                        Text(
                            text = it, modifier = Modifier.padding(end = 20.dp), fontSize = 16.sp,
                            fontFamily = formulaFont,
                            fontWeight = FontWeight.Bold,
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