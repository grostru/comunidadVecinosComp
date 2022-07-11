package com.grt.comunidadpropjetcomp.ui.screen

import android.content.Intent
import android.net.Uri
import android.widget.Toast
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.core.content.ContextCompat.startActivity
import com.google.maps.android.compose.*
import com.grt.comunidadpropjetcomp.R

/**
 * Created por Gema Rosas Trujillo
 * 30/06/2022
 *
 * Representación de la vista principal en Jetpack compose
 */

@Composable
fun AlertDialogComponent(openDialog:MutableState<Boolean>, phone:String) {

    val context = LocalContext.current

    AlertDialog(
        onDismissRequest = { openDialog.value = false },
        title = { Text(text = "Tu Comunidad de Propietarios", color = Color.White) },
        text = { Text("¿Está seguro que desea llamar por teléfono?", color = Color.White) },
        confirmButton = {
                TextButton(
                    onClick = {
                        openDialog.value = false
                        val dialIntent = Intent(Intent.ACTION_DIAL)
                        dialIntent.data = Uri.parse("tel:${phone}}")
                        startActivity(context,dialIntent, null)
                    }
                ) {
                    Text("Aceptar", color = Color.White)
                }
            },
        dismissButton = {
                TextButton(
                    onClick = {
                        openDialog.value = false
                    }
                ) {
                    Text("Cancelar", color = Color.White)
                }
            },
        backgroundColor = colorResource(id = R.color.teal_700),
        contentColor = Color.White
    )
}




