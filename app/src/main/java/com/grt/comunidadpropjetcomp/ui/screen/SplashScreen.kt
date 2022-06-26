package com.grt.comunidadpropjetcomp.ui.screen

import androidx.compose.animation.core.animateFloat
import androidx.compose.animation.core.infiniteRepeatable
import androidx.compose.animation.core.rememberInfiniteTransition
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.grt.comunidadpropjetcomp.R
import com.grt.comunidadpropjetcomp.navigation.AppScreens
import kotlinx.coroutines.delay

/**
 * Created por Gema Rosas Trujillo
 * 16/06/2022
 *
 * Representación de la vista splash en Jetpack compose
 */

@Composable
fun SplashScreen(navController: NavHostController){

    // Permite crear una corrutina que hace referencia a una tarea asincrona
    LaunchedEffect(key1 = true){
        // Simulamos un tiempo
        delay(5000)
        // Limpiamos la vuelta atrás, puesto que no queremos que al pulsar atrás
        // se nos vuelva al splash
        navController.popBackStack()
        navController.navigate(AppScreens.MainScreen.route)
    }
    Splash()
}

@Composable
fun Splash(){
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(
            text = "Comunidad de Propietarios El Mayeto",
            fontSize = 30.sp,
            fontWeight = FontWeight.Bold,
            textAlign = TextAlign.Center
        )
        Spacer(modifier = Modifier.size(16.dp))
        Image(
            painter = painterResource(id = R.drawable.ic_logo),
            contentDescription = "Logo Comunidad El Mayeto",
            modifier = Modifier.size(150.dp, 150.dp)
        )
        Text(
            text = "Bienvenid@s",
            fontSize = 30.sp,
            fontWeight = FontWeight.Bold,

            )

        val progressValue = 1f
        val infiniteTransition = rememberInfiniteTransition()
        val progressAnimationValue by infiniteTransition.animateFloat(
            initialValue = 0.0f,
            targetValue = progressValue,animationSpec = infiniteRepeatable(animation = tween(900)))
        CircularProgressIndicator(progress = progressAnimationValue)
    }
}

