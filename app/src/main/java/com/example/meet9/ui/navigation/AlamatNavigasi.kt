package com.example.meet9.ui.navigation

interface AlamatNavigasi {
    val route: String             //untuk menyimpan routing halaman

}
object DestinasiHome : AlamatNavigasi{
    override val route = "home"

}
object DestinasiDetail : AlamatNavigasi {
    override val route = "detail"
    const val NIM = "nim"
    val routesWithArg = "$route/{$NIM}"

    object DestinasiUpdate : AlamatNavigasi {
        override val route = "detail"
        const val NIM = "nim"
        val routesWithArg = "$route/{$NIM}"
    }
}