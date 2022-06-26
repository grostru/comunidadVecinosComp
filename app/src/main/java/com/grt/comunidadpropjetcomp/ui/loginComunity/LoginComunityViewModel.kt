package com.grt.comunidadpropjetcomp.ui.loginComunity

import androidx.compose.runtime.*
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.grt.comunidadpropjetcomp.common.BaseViewModel
import com.grt.comunidadpropjetcomp.domain.model.ComunityModel
import com.grt.comunidadpropjetcomp.domain.model.Response
import com.grt.comunidadpropjetcomp.domain.usecase.GetComunityUseCase
import com.grt.comunidadpropjetcomp.domain.usecase.UseCases
import com.squareup.okhttp.Dispatcher
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject


/**
 * Created por Gema Rosas Trujillo
 * 24/03/2022
 */
@HiltViewModel
class LoginComunityViewModel @Inject constructor(
    private val useCases: UseCases
) : BaseViewModel() {

    private val _comunitysState = mutableStateOf<Response<ComunityModel>>(Response.Loading)
    val comunitysState: State<Response<ComunityModel>> = _comunitysState

    var uiComunity by mutableStateOf(ComunityModel())
        private set

    override fun onInitialization() {}

    fun getComunity(idComunity: String)= viewModelScope.launch {
        useCases.getComunitys(idComunity).collect { response ->
            _comunitysState.value = response
        }
    }

    fun isLoadingComunity(comunityModel: ComunityModel){
        uiComunity = comunityModel
    }



}