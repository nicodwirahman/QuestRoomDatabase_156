package com.example.meet9.ui.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.meet9.ui.view.mahasiswa.DetailMhsView
import com.example.meet9.ui.view.mahasiswa.HomeMhsView
import com.example.meet9.ui.view.mahasiswa.UpdateMhsView
import com.example.mvvmdengandatabase.ui.navigation.DestinasiDetail
import com.example.mvvmdengandatabase.ui.navigation.DestinasiUpdate
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
        composable(
            DestinasiDetail.routesWithArg,
            arguments = listOf(
                navArgument(DestinasiDetail.NIM){
                    type = NavType.StringType
                }
            )
        ) {
            val nim = it.arguments?.getString(DestinasiDetail.NIM)
            nim?.let { nim ->
                DetailMhsView(
                    onBack = {
                        navController.popBackStack()
                    },
                    onEditClick = {
                        navController.navigate("${DestinasiUpdate.route}/$it")
                    },
                    modifier = modifier,
                    onDeleteClick = {
                        navController.popBackStack()
                    }
                )
            }

        }

composable(
    DestinasiUpdate.routeWithArg,
    arguments = listOf(
        navArgument(DestinasiUpdate.NIM){
            type = NavType.StringType
        }
    )
)
{
    UpdateMhsView(
        onBack = {
            navController.popBackStack()
        },
        onNavigate = {
            navController.popBackStack()
        },
        modifier = modifier
    )
}
    }
}
