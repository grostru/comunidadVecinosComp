package com.grt.comunidadpropjetcomp.data.firestore

import com.google.firebase.firestore.CollectionReference
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.Query
import com.grt.comunidadpropjetcomp.data.Constants
import com.grt.comunidadpropjetcomp.data.Constants.FECHA
import com.grt.comunidadpropjetcomp.domain.model.ComunityModel
import com.grt.comunidadpropjetcomp.domain.model.Response
import com.grt.comunidadpropjetcomp.domain.model.TablonModel
import com.grt.comunidadpropjetcomp.domain.repository.GetComunityRepository
import com.grt.comunidadpropjetcomp.domain.repository.GetTablonRepository
import kotlinx.coroutines.channels.awaitClose
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.callbackFlow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.tasks.await
import javax.inject.Inject
import javax.inject.Singleton

/**
 * Created por Gema Rosas Trujillo
 * 01/07/2022
 *
 * Clase que implementa la conexión a la BBDD Firestore para obtener el Tablón de Noticias
 * ordenada por fecha
 *
 */
@Singleton
class FirestoreTablonRepository @Inject constructor(
    private val db: FirebaseFirestore
): GetTablonRepository {

    override fun getTablonFromFirestore(idComunity:String): Flow<Response<List<TablonModel>>> = callbackFlow {
        val snapshotListener = db.collection(Constants.COLL_TABLON).whereEqualTo("idComunity", idComunity).orderBy(FECHA, Query.Direction.DESCENDING).addSnapshotListener { snapshot, e ->
            val response = if (snapshot != null) {
                val listaTablon = snapshot.toObjects(TablonModelDB::class.java)
                val listaFullTablon : ArrayList<TablonModel> = arrayListOf()

                for (tablon in listaTablon){
                    listaFullTablon.add(tablon.toDomain())
                }

                Response.Success(listaFullTablon)
            } else {
                Error(e?.message ?: e.toString())
            }
            trySend(response as Response<List<TablonModel>>).isSuccess
        }
        awaitClose {
            snapshotListener.remove()
        }
    }


}
