package com.grt.comunidadpropjetcomp.domain.repository

import com.grt.comunidadpropjetcomp.domain.model.ComunityModel
import com.grt.comunidadpropjetcomp.domain.model.Response
import com.grt.comunidadpropjetcomp.domain.model.TablonModel
import kotlinx.coroutines.flow.Flow

/**
 * Created por Gema Rosas Trujillo
 * 01/07/2022
 * Interface del caso de uso que obtiene la Comunidad que coincide con el id de búsqueda
 */
interface GetTablonRepository {
    fun getTablonFromFirestore(idComunity:String): Flow<Response<List<TablonModel>>>
}