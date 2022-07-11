package com.grt.comunidadpropjetcomp.data.firestore

import com.google.firebase.firestore.CollectionReference
import com.google.firebase.firestore.FirebaseFirestore
import com.grt.comunidadpropjetcomp.data.Constants
import com.grt.comunidadpropjetcomp.domain.model.ComunityModel
import com.grt.comunidadpropjetcomp.domain.model.Response
import com.grt.comunidadpropjetcomp.domain.repository.GetComunityRepository
import kotlinx.coroutines.channels.awaitClose
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.callbackFlow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.tasks.await
import javax.inject.Inject
import javax.inject.Singleton

/**
 * Created por Gema Rosas Trujillo
 * 17/06/2022
 *
 * Clase que implementa la conexión a la BBDD Firestore para obtener la Comunidad de Propietarios
 *
 * */
@Singleton
class FirestoreComunityRepository
        @Inject constructor(private val db: FirebaseFirestore)
    : GetComunityRepository {

    override fun getComunityFromFirestore(idComunity: String): Flow<Response<ComunityModel>> = callbackFlow {
        val snapshotListener = db.collection(Constants.COLL_COMUNITYS).document(idComunity).addSnapshotListener { snapshot, e ->
            val response = if (snapshot != null) {
                val comunity = snapshot.toObject(ComunityModel::class.java)
                Response.Success(comunity)
            } else {
                Error(e?.message ?: e.toString())
            }
            trySend(response as Response<ComunityModel>).isSuccess
        }
        awaitClose {
            snapshotListener.remove()
        }
    }
}
