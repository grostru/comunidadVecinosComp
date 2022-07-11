package com.grt.comunidadpropjetcomp.ui.screen

import android.content.Context
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.text.ClickableText
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.grt.comunidadpropjetcomp.R
import com.grt.comunidadpropjetcomp.domain.model.ComunityModel
import com.grt.comunidadpropjetcomp.navigation.BottomNavigationBar
import com.grt.comunidadpropjetcomp.ui.loginComunity.ComunityViewModel
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
    viewModel: ComunityViewModel = hiltViewModel()
){
    val uiState = viewModel.uiComunity


    PreviewInfo(navController,uiState)

}

@Composable
fun PreviewInfo(navController: NavHostController, uiState:ComunityModel) {
    val context = LocalContext.current
    val name = uiState.name?:""
    val direccion = uiState.direccion?:""
    val namePresident = uiState.namePresident?:""
    val phonePresident=uiState.phonePresident?:""
    val nameAdmin = uiState.nameAdministrator?:""
    val phoneAdmin = uiState.phoneAdministrator?:""
    val direccionAdmin = uiState.direccionAdministrator?:""
    val latAdmin = uiState.latAdmin?:""
    val lngAdmin = uiState.lngAdmin?:""
    val openDialogPhonePresident = remember { mutableStateOf(false) }
    val openDialogPhoneAdmin = remember { mutableStateOf(false) }

    Scaffold(
        topBar = { TopBar(name!!) },
        bottomBar = { BottomNavigationBar(navController) }
    ) { padding ->

        if (openDialogPhonePresident.value) {
            AlertDialogComponent(openDialogPhonePresident, phonePresident)
        }

        if (openDialogPhoneAdmin.value) {
            AlertDialogComponent(openDialogPhoneAdmin, phoneAdmin)
        }

        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(Teal700)
                .padding(16.dp)
                .verticalScroll(rememberScrollState()),
        ) {
            Text(
                text = "Dirección",
                textDecoration = TextDecoration.Underline,
                fontSize = 30.sp,
                color = Color.White,
                fontWeight = FontWeight.Bold,
                textAlign = TextAlign.Center
            )
            Spacer(modifier = Modifier.size(20.dp))
            Text(
                text = direccion,
                fontSize = 20.sp,
                color = Color.White,
                textAlign = TextAlign.Center
            )
            Spacer(modifier = Modifier.size(20.dp))
            Text(
                text = "Presidente",
                textDecoration = TextDecoration.Underline,
                fontSize = 30.sp,
                color = Color.White,
                fontWeight = FontWeight.Bold,
                textAlign = TextAlign.Center
            )
            Spacer(modifier = Modifier.size(16.dp))
            Row() {
                Column(
                    Modifier.weight(1f)
                ){
                    Text(
                        modifier = Modifier
                            .padding(8.dp),
                        fontSize = 20.sp,
                        text = namePresident,
                        color = colorResource(id = R.color.white)
                    )
                }
                val annotatedText = buildAnnotatedString {
                    withStyle(
                        style = SpanStyle(
                            color = Color.White,
                            fontWeight = FontWeight.Bold,
                            fontSize = 20.sp
                        )
                    ) {
                        append(phonePresident)
                    }
                }

                Column(
                    Modifier.weight(1f)
                ) {
                    ClickableText(
                        modifier = Modifier
                            .padding(8.dp),
                        text = annotatedText,
                        onClick = {
                            openDialogPhonePresident.value = true
                        }
                    )
                }
            }
            Spacer(modifier = Modifier.size(20.dp))
            Text(
                text = "Administrador de Finca",
                textDecoration = TextDecoration.Underline,
                fontSize = 30.sp,
                color = Color.White,
                fontWeight = FontWeight.Bold,
                textAlign = TextAlign.Center
            )
            Spacer(modifier = Modifier.size(16.dp))
            Row() {
                Column(
                    Modifier.weight(1f)
                ){
                    Text(
                        modifier = Modifier
                            .padding(8.dp),
                        fontSize = 20.sp,
                        text = nameAdmin,
                        color = colorResource(id = R.color.white)
                    )
                }
                val annotatedText = buildAnnotatedString {
                    withStyle(
                        style = SpanStyle(
                            color = Color.White,
                            fontWeight = FontWeight.Bold,
                            fontSize = 20.sp
                        )
                    ) {
                        append(phoneAdmin)
                    }
                }

                Column(
                    Modifier.weight(1f)
                ) {
                    ClickableText(
                        modifier = Modifier
                            .padding(8.dp),
                        text = annotatedText,
                        onClick = {
                            openDialogPhoneAdmin.value = true
                        }
                    )
                }
            }
            Text(
                modifier = Modifier
                    .padding(8.dp),
                fontSize = 20.sp,
                text = direccionAdmin,
                color = colorResource(id = R.color.white)
            )
            Spacer(modifier = Modifier.size(16.dp))
            MapScreen(latAdmin, lngAdmin, name)
        }
    }
}






