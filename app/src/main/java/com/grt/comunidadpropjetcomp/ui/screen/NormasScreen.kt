package com.grt.comunidadpropjetcomp.ui.screen

import android.content.Context
import android.widget.Toast
import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
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
fun NormasScreen(
    context: Context,
    navController: NavHostController,
    viewModel: LoginComunityViewModel = hiltViewModel()
){

    val uiState = viewModel.uiComunity

    val name = uiState.name?:""
    val estatutos = uiState.estatutos?:""
    val instalaciones = uiState.instalaciones?:""
    val mantenimiento = uiState.mantenimiento?:""
    val contribucion = uiState.contribucion?:""
    val respeto = uiState.respeto?:""
    val obras = uiState.obras?:""

    Greeting(navController,name, estatutos, instalaciones, mantenimiento, contribucion, respeto, obras)

}

@Composable
fun Greeting(navController: NavHostController, name: String, estatutos:String, instalaciones:String, mantenimiento:String, contribucion:String, respeto:String, obras:String) {
    Scaffold(
        topBar = { TopBar(name!!) },
        bottomBar = { BottomNavigationBar(navController) }
    ) { padding ->


        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(Color.White)
                .padding(16.dp)
                .verticalScroll(rememberScrollState()),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally

        ) {

            Text(
                text = "Obligaciones y Deberes de los Propietarios",
                textAlign = TextAlign.Center,
                fontSize = 30.sp,
                fontStyle = FontStyle.Italic,
                color = colorResource(id = R.color.teal_700)
            )
            Spacer(modifier = Modifier.size(16.dp))

            // Texto Estatutos
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(8.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Image(
                    modifier = Modifier
                        .padding(8.dp)
                        .fillMaxHeight(),
                    painter = painterResource(id = R.drawable.ic_carpeta),
                    contentDescription = "",
                    alignment = Alignment.Center
                )
                Text(
                    modifier = Modifier
                        .padding(8.dp),
                    text = estatutos,
                    color = colorResource(id = R.color.teal_700)
                )
            }

            // Texto Instalaciones
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(8.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Image(
                    modifier = Modifier
                        .padding(8.dp)
                        .fillMaxHeight(),
                    painter = painterResource(id = R.drawable.ic_instalaciones),
                    contentDescription = "",
                    alignment = Alignment.Center
                )
                Text(
                    modifier = Modifier
                        .padding(8.dp),
                    text = instalaciones,
                    color = colorResource(id = R.color.teal_700)
                )
            }

            // Texto Mantenimiento
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(8.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Image(
                    modifier = Modifier
                        .padding(8.dp)
                        .fillMaxHeight(),
                    painter = painterResource(id = R.drawable.ic_mantenimiento),
                    contentDescription = "",
                    alignment = Alignment.Center
                )
                Text(
                    modifier = Modifier
                        .padding(16.dp),
                    text = mantenimiento,
                    color = colorResource(id = R.color.teal_700)
                )
            }

            // Texto Contribucion
            Spacer(modifier = Modifier.size(8.dp))
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(8.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Image(
                    modifier = Modifier
                        .padding(8.dp)
                        .fillMaxHeight(),
                    painter = painterResource(id = R.drawable.ic_hoja),
                    contentDescription = "",
                    alignment = Alignment.Center
                )
                Text(
                    modifier = Modifier
                        .padding(8.dp),
                    text = contribucion,
                    color = colorResource(id = R.color.teal_700)
                )
            }

            // Texto Respeto
            Spacer(modifier = Modifier.size(8.dp))
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(8.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Image(
                    modifier = Modifier
                        .padding(8.dp)
                        .fillMaxHeight(),
                    painter = painterResource(id = R.drawable.ic_altavoz),
                    contentDescription = "",
                    alignment = Alignment.Center
                )

                Text(
                    modifier = Modifier
                        .padding(8.dp),
                    text = respeto,
                    color = colorResource(id = R.color.teal_700)
                )
            }
                Spacer(modifier = Modifier.size(8.dp))
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(8.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Image(
                        modifier = Modifier
                            .padding(8.dp)
                            .fillMaxHeight(),
                        painter = painterResource(id = R.drawable.ic_informacion),
                        contentDescription = "",
                        alignment = Alignment.Center
                    )
                    Text(
                        modifier = Modifier
                            .padding(start = 8.dp, top = 8.dp, bottom = 40.dp, end = 8.dp),
                        text = obras,
                        color = colorResource(id = R.color.teal_700)
                    )
                }
                //ArtistCard()

        }
    }
}

    @Composable
    fun ArtistCard() {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.End
        ) {
            Image(painter = painterResource(id = R.drawable.ic_hoja),contentDescription = "")
            Column {
                Text(text = "Java", color = Color.White)
                Text(text = "Java", color = Color.White)
            }
        }
    }




