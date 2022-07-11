package com.grt.comunidadpropjetcomp.domain.model

import java.sql.Timestamp

/**
 * Created por Gema Rosas Trujillo
 * 01/07/2022
 * Modelo de datos común a toda la aplicación
 */
data class TablonModel(
    var titulo:String?=null,
    var descripcion:String?=null,
    var fecha: String?=null
)