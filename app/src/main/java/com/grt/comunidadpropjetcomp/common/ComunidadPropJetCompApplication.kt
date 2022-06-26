package com.grt.comunidadpropjetcomp.common

import android.app.Application
import dagger.hilt.android.HiltAndroidApp
/**
 * Created por Gema Rosas Trujillo
 * 17/06/2022
 *
 * Clase en la que inciamos Koin y el contexto de la Aplicación. Esta clase siempre ha de estar
 * definida en el manifest
 */
@HiltAndroidApp
class ComunidadPropJetCompApplication: Application()

