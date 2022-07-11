package com.grt.comunidadpropjetcomp.domain.repository

import kotlinx.coroutines.flow.Flow

/**
 * Created por Gema Rosas Trujillo
 * 06/07/2022
 *
 * Interface en la que se definen los métodos que vamos a usar para almacenar y obtener
 * los datos persistidos en DataStore
 */
interface GetProfileRepository {

    // Almacenamos u obtenemos el id de la comunidad con la que nos hemos validado
    suspend fun saveIdComunityProfile(name:String)
    suspend fun getIdComunityProfile(): String

}