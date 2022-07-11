package com.grt.comunidadpropjetcomp.data.firestore

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.stringPreferencesKey
import androidx.datastore.preferences.preferencesDataStore
import com.grt.comunidadpropjetcomp.domain.repository.GetProfileRepository
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.map
import javax.inject.Inject
import javax.inject.Singleton


/**
 * Created por Gema Rosas Trujillo
 * 28/01/2022
 *
 * Clase encargada de la persistencia de los datos del DataStore
 */
@Singleton
class DataStoreProfileRepository
    @Inject constructor(private val context:Context)
        : GetProfileRepository {

    private val Context.storeData: DataStore<Preferences> by preferencesDataStore(name = "ProfileSettings")
    private val KEY_PROFILE_IDCOMUNITY = stringPreferencesKey("KEY_PROFILE_IDCOMUNITY")

    override suspend fun saveIdComunityProfile(idComunity: String) {
        context.storeData.edit { preferences->
            preferences[KEY_PROFILE_IDCOMUNITY] = idComunity
        }
    }

    override suspend fun getIdComunityProfile(): String {
        return context.storeData.data.map { preferences->
            preferences[KEY_PROFILE_IDCOMUNITY]?:""
        }.first()
    }
}