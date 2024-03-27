package com.example.formula1app

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.google.android.gms.maps.model.LatLng
import com.google.maps.android.compose.GoogleMap
import com.google.maps.android.compose.Marker
import com.google.maps.android.compose.rememberMarkerState

class MapsActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val long = this.intent.getStringExtra("long")
        val lat = this.intent.getStringExtra("lat")

        val listTrackLocations =
            intent.getSerializableExtra("listLocationTrack") as ArrayList<Pair<Double, Double>>?


        setContent {
            GoogleMap {
                if (lat != null && long != null) {
                    Marker(
                        state = rememberMarkerState(
                            position = LatLng(
                                lat.toDouble(),
                                long.toDouble()
                            )
                        )
                    )
                }

                listTrackLocations?.let { locations ->
                    for (location in locations) {
                        val latitude = location.first
                        val longitude = location.second
                        Marker(
                            state = rememberMarkerState(
                                position = LatLng(
                                    latitude,
                                    longitude
                                )
                            )
                        )
                    }
                }

            }

        }
    }
}
