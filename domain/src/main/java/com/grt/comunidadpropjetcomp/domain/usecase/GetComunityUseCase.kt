package com.grt.comunidadpropjetcomp.domain.usecase

import com.grt.comunidadpropjetcomp.domain.model.ComunityModel
import com.grt.comunidadpropjetcomp.domain.repository.GetComunityRepository

/**
 * Created por Gema Rosas Trujillo
 * 17/06/2022
 * Caso de uso que se encarga de obtener de Firebase la comunidad coincidente con el id pasado como parámetro
 */
/*
class GetComunityUseCase(
    private val comunityRepository: GetComunityRepository
) : UseCase<String, List<ComunityModel>>() {

    override suspend fun executeUseCase(input: String):List<ComunityModel> {

        return comunityRepository.getComunity(input).getOrDefault(emptyList())
    }
}*/

class GetComunityUseCase (
    private val repo: GetComunityRepository
) {
    operator fun invoke(idComunity: String) = repo.getComunityFromFirestore(idComunity)
}