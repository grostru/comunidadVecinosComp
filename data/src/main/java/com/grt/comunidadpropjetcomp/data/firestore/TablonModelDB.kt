package com.grt.comunidadpropjetcomp.data.firestore

import com.google.firebase.firestore.ServerTimestamp
import com.google.firebase.Timestamp
import com.grt.comunidadpropjetcomp.domain.model.TablonModel
import java.text.SimpleDateFormat
import java.util.*


/**
 * Created por Gema Rosas Trujillo
 * 01/07/2022
 * Modelo de datos común a toda la aplicación
 */
data class TablonModelDB(
    var titulo:String?=null,
    var descripcion:String?=null,
    @ServerTimestamp var fecha: Timestamp?=null
)

fun TablonModel.toDataDB() : TablonModelDB {
    return TablonModelDB(
        titulo, descripcion
    )
}

fun TablonModelDB.toDomain() : TablonModel{
    val sdf = SimpleDateFormat("dd/MM/yyyy")
    val date =sdf.format(fecha?.toDate())

    return TablonModel(titulo, descripcion, date.toString())
}