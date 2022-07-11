package com.grt.comunidadpropjetcomp.domain.usecase

import com.grt.comunidadpropjetcomp.domain.model.ComunityModel
import com.grt.comunidadpropjetcomp.domain.repository.GetComunityRepository
import com.grt.comunidadpropjetcomp.domain.repository.GetTablonRepository

/**
 * Created por Gema Rosas Trujillo
 * 01/07/2022
 * Caso de uso que se encarga de obtener de Firebase la comunidad coincidente con el id pasado como parámetro
 */

class GetTablonUseCase (
    private val repo: GetTablonRepository
) {
    operator fun invoke(idComunity:String) = repo.getTablonFromFirestore(idComunity)
}