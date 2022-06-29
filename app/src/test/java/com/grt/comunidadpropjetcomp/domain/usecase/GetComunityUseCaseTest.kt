package com.grt.comunidadpropjetcomp.domain.usecase

import com.google.firebase.firestore.FirebaseFirestoreException
import com.grt.comunidadpropjetcomp.domain.model.ComunityModel
import com.grt.comunidadpropjetcomp.domain.model.Response
import com.grt.comunidadpropjetcomp.domain.repository.GetComunityRepository
import io.mockk.MockKAnnotations
import io.mockk.coEvery
import io.mockk.coVerify
import io.mockk.impl.annotations.MockK
import io.mockk.impl.annotations.RelaxedMockK
import kotlinx.coroutines.flow.callbackFlow
import kotlinx.coroutines.runBlocking
import org.junit.Assert.*
import org.junit.Before
import org.junit.Test

/**
 * Created por Gema Rosas Trujillo
 * 29/06/2022
 *
 * Test de nuestro Caso de Uso para obtener la comunidad de propietarios
 */

class GetComunityUseCaseTest{

    @RelaxedMockK
    //@MockK
    private lateinit var comunityRepository: GetComunityRepository

    lateinit var getComunityUseCase: GetComunityUseCase

    // Inicializamos nuestra librería Mock
    @Before
    fun onBefore(){
        // Con el this estamos mockeando el repositorio de nuestro caso de uso
        MockKAnnotations.init(this)
        getComunityUseCase = GetComunityUseCase(comunityRepository)
    }

    @Test
    fun `when The Api Doesnt Return Anything`() = runBlocking{
        //Given
        // si hay corutina se pone coevery sino every
        coEvery { comunityRepository.getComunityFromFirestore(idComunity = "") } returns callbackFlow { Response.Success(null) }

        //When
        getComunityUseCase("")

        //Then
        coVerify(exactly = 1) { comunityRepository.getComunityFromFirestore("") }
    }

    @Test
    fun `when The Api Return Error`() = runBlocking{

        //Given
        // si hay corutina se pone coevery sino every
        coEvery {
            comunityRepository.getComunityFromFirestore(idComunity = "")
        } returns callbackFlow {
            val e : FirebaseFirestoreException = FirebaseFirestoreException("Error al consultar la Comunidad", FirebaseFirestoreException.Code.NOT_FOUND)
            Error(e?.message ?: e.toString())
        }

        //When
        getComunityUseCase("")

        //Then
        coVerify(exactly = 1) { comunityRepository.getComunityFromFirestore("") }
    }

    @Test
    fun `when The Api Return a Comunity`() = runBlocking{

        val idComunity = "001"
        //Given
        // si hay corutina se pone coevery sino every
        coEvery {
            comunityRepository.getComunityFromFirestore(idComunity)
        } returns callbackFlow {
            val comunityModel = ComunityModel("Name","contribucion","estatutos","instalaciones","mantenimiento","obras","respeto","36.25","-6.25","direccion")
            Response.Success(comunityModel)
        }

        //When
        getComunityUseCase(idComunity)

        //Then
        coVerify(exactly = 1) { comunityRepository.getComunityFromFirestore(idComunity) }
    }
}