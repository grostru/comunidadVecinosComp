package com.grt.comunidadpropjetcomp.ui.screen

import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import com.grt.comunidadpropjetcomp.R

/**
 * Created por Gema Rosas Trujillo
 * 16/06/2022
 *
 * Representación de la vista principal en Jetpack compose
 */

@Composable
fun TopBar(name:String) {
    TopAppBar(
        title = { Text(text = "Comunidad de Propietarios ${name}", fontSize = 18.sp) },
        backgroundColor = colorResource(id = R.color.teal_700),
        contentColor = Color.White
    )
}




