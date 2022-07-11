package com.grt.comunidadpropjetcomp.ui.screen

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Delete
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.grt.comunidadpropjetcomp.domain.model.TablonModel

@Composable
fun TablonCard(
    noticia: TablonModel
) {

    var fecha = noticia.fecha?:""

    Card(
        shape = MaterialTheme.shapes.small,
        modifier = Modifier
            .padding(
                start = 8.dp,
                end = 8.dp,
                top = 4.dp,
                bottom = 4.dp
            )
            .fillMaxWidth(),
        elevation = 3.dp,
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(all = 12.dp),
            verticalAlignment = Alignment.CenterVertically,
        ) {
            Column(
                modifier = Modifier
                    .fillMaxWidth(0.90f)
            ){
                noticia.titulo?.let { title ->
                    Text(
                        text = title + " ${fecha}",
                        color = Color.DarkGray,
                        fontSize = 25.sp
                    )
                }
                noticia.descripcion?.let { descrip ->
                    Text(
                        text = "$descrip",
                        color = Color.DarkGray,
                        fontSize = 18.sp
                    )
                }
            }
        }
    }
}