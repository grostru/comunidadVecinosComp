package com.grt.comunidadpropjetcomp.domain.usecase

data class UseCases (
    val getComunitys: GetComunityUseCase,
    val getTablon: GetTablonUseCase,
    val getIdComunity: GetProfileIdComunityUseCase,
    val saveIdComunity: SaveProfileIdComunityUseCase
)