package com.grt.comunidadpropjetcomp.ui.screen

import android.content.Context
import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.grt.comunidadpropjetcomp.R
import com.grt.comunidadpropjetcomp.data.UtilsComunity
import com.grt.comunidadpropjetcomp.domain.model.Response
import com.grt.comunidadpropjetcomp.navigation.NavigationItem
import com.grt.comunidadpropjetcomp.ui.loginComunity.ComunityViewModel
import com.grt.comunidadpropjetcomp.ui.theme.Teal700

/**
 * Created por Gema Rosas Trujillo
 * 16/06/2022
 *
 * Representación de la vista principal en Jetpack compose
 */

@Composable
fun MainScreen(
    context: Context,
    navController: NavHostController,
    viewModel: ComunityViewModel = hiltViewModel()
){

    Scaffold(
        content = { padding ->

            when (val booksResponse = viewModel.comunitysState.value) {
                is Response.Loading -> LinearProgressIndicator(progress = 0.5f)
                is Response.Success -> {
                    val comunity = booksResponse.data
                    if (comunity != null) {
                        LaunchedEffect(comunity){
                            viewModel.isLoadingComunity(comunity)
                            navController.navigate(NavigationItem.Interes.route)
                        }

                        Toast.makeText(context, "La Comunidad es correcta", Toast.LENGTH_LONG).show()
                    } else {
                        Toast.makeText(
                            context,
                            "La Comunidad introducida es errónea",
                            Toast.LENGTH_LONG
                        ).show()
                    }
                }
                is Response.Error -> Toast.makeText(
                    context,
                    "La Comunidad introducida es errónea",
                    Toast.LENGTH_LONG
                ).show()
            }

            when (val tablonResponse = viewModel.tablonListState.value) {
                is Response.Loading -> ProgressBar()
                is Response.Success -> LazyColumn(
                    modifier = Modifier.fillMaxSize().padding(padding)
                ) {
                    viewModel.isLoadingTablon(tablonResponse.data)
                }
                is Error -> tablonResponse.message?.let { UtilsComunity.printError(it) }
            }


            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .background(Teal700)
                    .padding(16.dp),
            ) {
                Text(
                    text = "Comunidad de Propietarios",
                    fontSize = 30.sp,
                    color = Color.White,
                    fontWeight = FontWeight.Bold,
                    textAlign = TextAlign.Center
                )
                Spacer(modifier = Modifier.size(16.dp))
                Image(
                    painter = painterResource(id = R.drawable.ic_banner),
                    contentDescription = "Logo Comunidad El Mayeto"
                )
                Spacer(modifier = Modifier.size(16.dp))

                var idComunity by remember { mutableStateOf("") }
                var nameError by remember { mutableStateOf(false) } // 1

                Column {
                    TextField(
                        modifier = Modifier.fillMaxWidth(),
                        value = idComunity,
                        onValueChange = {
                            idComunity = it
                            nameError = false // 2
                        },
                        textStyle = TextStyle(color = Color.White),
                        label = {
                            Text(
                                "Introduzca el código de su comunidad",
                                color = Color.White,
                                fontSize = 16.sp
                            )
                        },
                        isError = nameError // 3
                    )

                    val assistiveElementText =
                        if (nameError) "Error: Obligatorio" else "*Obligatorio" // 4
                    val assistiveElementColor = if (nameError) { // 5
                        MaterialTheme.colors.error
                    } else {
                        MaterialTheme.colors.onSurface.copy(alpha = ContentAlpha.medium)
                    }

                    Text(// 6
                        text = assistiveElementText,
                        color = assistiveElementColor,
                        style = MaterialTheme.typography.caption,
                        modifier = Modifier.padding(start = 16.dp)
                    )

                }

                Button(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 16.dp),
                    onClick = {
                        viewModel.getComunity(idComunity)
                        viewModel.getTablon(idComunity)
                    },
                    // Uses ButtonDefaults.ContentPadding by default
                    contentPadding = PaddingValues(
                        start = 20.dp,
                        top = 12.dp,
                        end = 20.dp,
                        bottom = 12.dp
                    )
                ) {
                    Spacer(Modifier.size(ButtonDefaults.IconSpacing))
                    Text("Iniciar Sesión")
                }

                Column(
                    modifier = Modifier.fillMaxSize(),
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    CircularProgressBar(
                        isDisplayed = false
                    )
                }
            }
        }
    )
}



@Composable
fun CircularProgressBar(
    isDisplayed: Boolean
) {
    if (isDisplayed) {
        CircularProgressIndicator()
    }
}



