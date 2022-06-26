package com.grt.comunidadpropjetcomp.common

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

/**
 * Created por Gema Rosas Trujillo
 * 17/06/2022
 *
 * Clase abstracta común a todos los ViewModel en el que iniciamos todos los LiveData
 * comunes a todos los ViewModel a crear
 */
abstract class BaseViewModel: ViewModel() {

    protected fun executeUseCase(
        exceptionAction : (suspend ((Throwable)->Unit))?=null,
        finalAction : (suspend  ()->Unit)?=null,
        usecaseAction: suspend ()->Unit
    ){
        viewModelScope.launch {
            try {
                usecaseAction.invoke()
            }
            catch (e:Throwable){
                exceptionAction?.invoke(e)
            }
            finally {
                finalAction?.invoke()
            }
        }
    }

    fun onInit() {
        onInitialization()
    }

    abstract fun onInitialization()

}