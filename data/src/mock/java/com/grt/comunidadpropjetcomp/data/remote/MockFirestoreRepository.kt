package com.grt.comunidadpropjetcomp.data.remote

import android.content.Context
import com.grt.pokemon.data.UtilsPokemons
import com.grt.pokemon.data.database.room.toDataDB
import com.grt.pokemon.domain.model.PokemonModel
import com.grt.pokemon.domain.repository.GetPokemonsRepository
import com.squareup.picasso.Picasso
import kotlinx.coroutines.delay
import java.lang.Exception
import java.text.SimpleDateFormat
import java.util.*

class MockRemoteRepository()  : GetPokemonsRepository {

    override fun getComunityFromFirestore(idComunity: String): Flow<Response<ComunityModel>> = callbackFlow {

        val comunity = ComunityModel("El Mayeto")

        Response.Success(comunity)
    }
}