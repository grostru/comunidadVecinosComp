package com.grt.comunidadpropjetcomp.ui.screen

import android.content.ClipData
import android.content.Context
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.text.ClickableText
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material.icons.filled.Search
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.semantics.Role.Companion.Image
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.grt.comunidadpropjetcomp.R
import com.grt.comunidadpropjetcomp.data.UtilsComunity.Companion.printError
import com.grt.comunidadpropjetcomp.domain.model.Response
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
fun InteresScreen(
    context: Context,
    navController: NavHostController,
    viewModel: ComunityViewModel = hiltViewModel()
) {
    val uiState = viewModel.uiComunity
    val name = uiState.name
    val tablon = viewModel.uiTablon
    
    Scaffold(
        topBar = { TopBar(name!!) },
        bottomBar = { BottomNavigationBar(navController) }
    ){ padding ->
        LazyColumn(
            modifier = Modifier.fillMaxWidth(),
            contentPadding = PaddingValues(16.dp)
        ) {
            item {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .wrapContentHeight()
                        .padding(vertical = 25.dp),
                    horizontalArrangement = Arrangement.Center,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        "Tablón de Anuncios",
                        style = MaterialTheme.typography.h3,
                        textAlign = TextAlign.Center
                    )
                }
            }
            items(tablon) { plant ->
                TablonExpandableCard(plant)
            }
        }
    }
}





