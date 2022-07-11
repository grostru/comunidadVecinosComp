package com.grt.comunidadpropjetcomp.domain.usecase

import com.grt.comunidadpropjetcomp.domain.repository.GetProfileRepository


/**
 * Created por Gema Rosas Trujillo
 * 06/07/2022
 * Caso de uso para almacenar en data store el nombre
 */

class SaveProfileIdComunityUseCase (
    private val repo: GetProfileRepository
) {
    operator fun invoke(idComunity:String) = repo.saveIdComunityProfile(idComunity)
}