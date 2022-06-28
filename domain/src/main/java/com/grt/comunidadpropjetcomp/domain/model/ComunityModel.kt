package com.grt.comunidadpropjetcomp.domain.model

import java.io.Serializable


/**
 * Created por Gema Rosas Trujillo
 * 17/06/2022
 * Modelo de datos común a toda la aplicación
 */
data class ComunityModel(
    var name:String?=null,
    var contribucion:String?=null,
    var estatutos:String?=null,
    var instalaciones:String?=null,
    var mantenimiento:String?=null,
    var obras:String?=null,
    var respeto:String?=null
)