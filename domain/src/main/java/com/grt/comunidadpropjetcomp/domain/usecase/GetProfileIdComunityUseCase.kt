package com.grt.comunidadpropjetcomp.domain.usecase

import com.grt.comunidadpropjetcomp.domain.repository.GetProfileRepository


/**
 * Created por Gema Rosas Trujillo
 * 06/07/2022
 * Caso de uso para almacenar en data store el nombre
 */

class GetProfileIdComunityUseCase (
    private val repo: GetProfileRepository
) {
    operator fun invoke() = repo.getIdComunityProfile()
}