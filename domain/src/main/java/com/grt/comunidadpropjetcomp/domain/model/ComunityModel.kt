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
    var respeto:String?=null,
    var lat:String?=null,
    var lng:String?=null,
    var direccion:String?=null,
    var phonePresident:String?=null,
    var namePresident:String?=null,
    var phoneAdministrator:String?=null,
    var nameAdministrator:String?=null,
    var direccionAdministrator:String?=null,
    var latAdmin:String?=null,
    var lngAdmin:String?=null
)