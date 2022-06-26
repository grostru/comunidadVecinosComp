package com.grt.comunidadpropjetcomp.domain.repository

import com.grt.comunidadpropjetcomp.domain.model.ComunityModel
import com.grt.comunidadpropjetcomp.domain.model.Response
import kotlinx.coroutines.flow.Flow

/**
 * Created por Gema Rosas Trujillo
 * 17/06/2022
 * Interface del caso de uso que obtiene la Comunidad que coincide con el id de búsqueda
 */
interface GetComunityRepository {
    fun getComunityFromFirestore(idComunity:String): Flow<Response<ComunityModel>>
}