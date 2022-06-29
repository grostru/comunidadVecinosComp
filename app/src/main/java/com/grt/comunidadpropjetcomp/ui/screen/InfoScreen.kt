package com.grt.comunidadpropjetcomp.ui.screen

import android.content.Context
import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.model.CameraPosition
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.Marker
import com.google.maps.android.compose.CameraPositionState
import com.google.maps.android.compose.GoogleMap
import com.google.maps.android.compose.MapUiSettings
import com.google.maps.android.compose.MarkerState
import com.grt.comunidadpropjetcomp.R
import com.grt.comunidadpropjetcomp.domain.model.Response
import com.grt.comunidadpropjetcomp.navigation.BottomNavigationBar
import com.grt.comunidadpropjetcomp.ui.loginComunity.LoginComunityViewModel
import com.grt.comunidadpropjetcomp.ui.theme.Teal700

/**
 * Created por Gema Rosas Trujillo
 * 16/06/2022
 *
 * Representación de la vista principal en Jetpack compose
 */

@Composable
fun InfoScreen(
    context: Context,
    navController: NavHostController,
    viewModel: LoginComunityViewModel = hiltViewModel()
){
    val uiState = viewModel.uiComunity
    val name = uiState.name?:""
    val lat = uiState.lat?:""
    val lng = uiState.lng?:""
    val direccion = uiState.direccion?:""

    PreviewInfo(navController,name, direccion, lat, lng)

}

@Composable
fun PreviewInfo(navController: NavHostController, name: String, direccion:String, lat:String, lng:String) {
    Scaffold(
        topBar = { TopBar(name!!) },
        bottomBar = { BottomNavigationBar(navController) }
    ) { padding ->

        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(Color.White)
                .background(Teal700)
                .padding(16.dp),
        ) {
            Text(
                text = "Comunidad ${name}",
                fontSize = 30.sp,
                color = Color.White,
                fontWeight = FontWeight.Bold,
                textAlign = TextAlign.Center
            )
            Text(
                text = direccion,
                fontSize = 20.sp,
                color = Color.White,
                fontWeight = FontWeight.Bold,
                textAlign = TextAlign.Center
            )

            MapScreen(lat, lng, name)
        }
    }
}




