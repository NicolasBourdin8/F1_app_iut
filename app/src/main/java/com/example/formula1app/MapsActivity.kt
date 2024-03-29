package com.example.formula1app

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.google.android.gms.maps.model.CameraPosition
import com.google.android.gms.maps.model.LatLng
import com.google.maps.android.compose.GoogleMap
import com.google.maps.android.compose.Marker
import com.google.maps.android.compose.rememberCameraPositionState
import com.google.maps.android.compose.rememberMarkerState

class MapsActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val long = this.intent.getStringExtra("long")
        val lat = this.intent.getStringExtra("lat")


        val listTrackLocations =
            intent.getSerializableExtra("listLocationTrack") as ArrayList<Pair<Double, Double>>?

        val listTrackName =
            intent.getSerializableExtra("listTrackName") as ArrayList<*>?

        val listDateTrack =
            intent.getSerializableExtra("listDateTrack") as ArrayList<*>?

        setContent {

            if (lat != null && long != null) {
                val trackPosition = LatLng(lat.toDouble(), long.toDouble())

                val cameraPositionState = rememberCameraPositionState {
                    position = CameraPosition.fromLatLngZoom(trackPosition, 6f)
                }
                GoogleMap(cameraPositionState = cameraPositionState) {
                    Marker(
                        state = rememberMarkerState(
                            position = LatLng(
                                lat.toDouble(),
                                long.toDouble()
                            )
                        )
                    )
                }
            }

            if (listTrackLocations != null && listDateTrack != null && listTrackName != null)
                GoogleMap {
                    var index = 0
                    listTrackLocations.let { locations ->
                        for (location in locations) {
                            val latitude = location.first
                            val longitude = location.second
                            Marker(
                                state = rememberMarkerState(
                                    position = LatLng(
                                        latitude,
                                        longitude
                                    )
                                ),
                                title = listTrackName[index]?.toString(),
                                snippet = listDateTrack[index]?.toString()
                            )
                            index++
                        }
                    }
                }
        }
    }
}
