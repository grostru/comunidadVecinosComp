package com.grt.comunidadpropjetcomp.ui.screen

import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
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
        modifier = Modifier.height(80.dp),
        backgroundColor = colorResource(id = R.color.teal_700)
    ) {

        Box(modifier = Modifier.fillMaxSize()) { // (2)

            Row(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(horizontal = 4.dp) // (5)
            ) {
                CompositionLocalProvider(
                    LocalContentAlpha provides ContentAlpha.high,
                    LocalTextStyle provides MaterialTheme.typography.h5
                ) {
                    Text(
                        text = name!!,
                        fontSize = 30.sp,
                        color = Color.White,
                        maxLines = 2,
                        modifier = Modifier
                            .fillMaxWidth()
                            .weight(1f)
                            .align(Alignment.CenterVertically)
                            .padding(bottom = 16.dp, top = 16.dp, start = 16.dp)
                    )
                }

                IconButton(
                    onClick = { /*TODO*/ },
                    modifier = Modifier
                        .align(Alignment.CenterVertically)
                ) {
                    Icon(
                        painter = painterResource(id = R.drawable.ic_logout),
                        tint= Color.White,
                        contentDescription = "Cerrar Sesión"
                    )
                }
            }
        }


    }
}




