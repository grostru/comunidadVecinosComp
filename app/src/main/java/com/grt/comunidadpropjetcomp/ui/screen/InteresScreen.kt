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
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
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
fun InteresScreen(
    context: Context,
    navController: NavHostController,
    viewModel: LoginComunityViewModel = hiltViewModel()
){
    val uiState = viewModel.uiComunity
    val name = uiState?.name

    Scaffold(
        topBar = { TopBar(name!!) },
        bottomBar = { BottomNavigationBar(navController) }
    ) { padding ->


        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(Teal700)
                .padding(16.dp),
        ) {
            Text(
                text = "Comunidad de Propietarios El Mayeto",
                fontSize = 30.sp,
                color = Color.White,
                fontWeight = FontWeight.Bold,
                textAlign = TextAlign.Center
            )
            if (name != null) {
                Text(
                    text = name,
                    fontSize = 30.sp,
                    color = Color.White,
                    fontWeight = FontWeight.Bold,
                    textAlign = TextAlign.Center
                )
            }
        }
    }

}




