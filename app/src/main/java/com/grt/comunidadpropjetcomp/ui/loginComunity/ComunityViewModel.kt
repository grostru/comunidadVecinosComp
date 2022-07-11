package com.grt.comunidadpropjetcomp.ui.loginComunity

import androidx.compose.runtime.*
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.google.android.material.tabs.TabLayout
import com.grt.comunidadpropjetcomp.domain.model.ComunityModel
import com.grt.comunidadpropjetcomp.domain.model.Response
import com.grt.comunidadpropjetcomp.domain.model.TablonModel
import com.grt.comunidadpropjetcomp.domain.usecase.UseCases
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject


/**
 * Created por Gema Rosas Trujillo
 * 24/03/2022
 */
@HiltViewModel
class ComunityViewModel @Inject constructor(
    private val useCases: UseCases
) : ViewModel() {

    private val _comunitysState = mutableStateOf<Response<ComunityModel>>(Response.Loading)
    val comunitysState: State<Response<ComunityModel>> = _comunitysState

    private val _tablonListState = mutableStateOf<Response<List<TablonModel>>>(Response.Loading)
    val tablonListState: State<Response<List<TablonModel>>> = _tablonListState

    private val _idComunity = MutableLiveData<String>()
    val idComunity: LiveData<String> = _idComunity

    var uiComunity by mutableStateOf(ComunityModel())
        private set

    var uiTablon: MutableList<TablonModel> = mutableListOf()
        private set

    fun getComunity(idComunity: String)= viewModelScope.launch {
        useCases.getComunitys(idComunity).collect { response ->
            _comunitysState.value = response
        }
    }

    fun isLoadingComunity(comunityModel: ComunityModel){
        uiComunity = comunityModel
    }

    fun isLoadingTablon(listTablon: List<TablonModel>){
        uiTablon = listTablon.toMutableList()
    }

    fun getTablon(idComunity: String)= viewModelScope.launch {
        useCases.getTablon(idComunity).collect { response ->
            _tablonListState.value = response
        }
    }

    // Función encargada de lanzar los casos de uso que realizan el almacenado de los datos
    // del perfil en el DataStore
    private fun saveComunity(idComunity: String) {
        _idComunity.value = idComunity

        useCases.saveIdComunity(idComunity)
    }
}