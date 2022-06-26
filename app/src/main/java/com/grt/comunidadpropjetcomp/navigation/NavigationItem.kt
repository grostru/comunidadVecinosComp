package com.grt.comunidadpropjetcomp.navigation

import com.grt.comunidadpropjetcomp.R

/**
 * Created por Gema Rosas Trujillo
 * 26/06/2022
 */
sealed class NavigationItem(var route: String, var icon: Int, var title: String) {
    object Info : NavigationItem("info", R.drawable.ic_informacion, "Información")
    object Normas : NavigationItem("normas", R.drawable.ic_hoja, "Normas")
    object Interes : NavigationItem("deInteres", R.drawable.ic_carpeta, "De Interés")
}