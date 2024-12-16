package com.example.meet9.ui.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.meet9.ui.view.mahasiswa.HomeMhsView
import com.example.roomdatabase.ui.theme.view.mahasiswa.DestinasiInsert
import com.example.roomdatabase.ui.theme.view.mahasiswa.InsertMhsView



@Composable
fun PengelolaHalaman(
    navController: NavHostController = rememberNavController(),
    modifier: Modifier = Modifier
) {
    NavHost(navController = navController,startDestination = DestinasiInsert.route) {
        composable(
            route = DestinasiInsert.route
        ) {
            HomeMhsView(
                onDetailClick = { nim ->
                    navController.navigate("${DestinasiDetail.route}/$nim")

                    println(
                        "pengelolaHalaman:nim = @nim"
                    )
                },
                onAddMhs = {
                    navController.navigate(DestinasiInsert.route)
                },
                modifier = modifier
            )
        }
            composable(
                route = DestinasiInsert.route
            ){
            InsertMhsView(
                onBack = { navController.popBackStack() },
                onNavigate = {  }
            )
        }
    }
}
