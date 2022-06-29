package com.grt.comunidadpropjetcomp.ui.screen

import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import com.google.android.gms.maps.model.CameraPosition
import com.google.android.gms.maps.model.LatLng
import com.google.maps.android.compose.*

/**
 * Created por Gema Rosas Trujillo
 * 16/06/2022
 *
 * Representación de la vista principal en Jetpack compose
 */

@Composable
fun MapScreen(lat:String, lng:String, name:String){
    val context = LocalContext.current
    val latLng = LatLng(lat.toDouble(), lng.toDouble())

    GoogleMap(modifier = Modifier.fillMaxSize(),
        uiSettings = MapUiSettings(zoomControlsEnabled = true),
        cameraPositionState = CameraPositionState(
            CameraPosition(latLng,15f, 0f, 0f)
        )
    ){
        Marker(
            state = rememberMarkerState(position = latLng),
            title = name
        )
    }
}




