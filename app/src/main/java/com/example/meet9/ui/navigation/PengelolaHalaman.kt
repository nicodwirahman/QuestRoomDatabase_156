package com.example.meet9.ui.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
import com.example.roomdatabase.ui.theme.view.mahasiswa.DestinasiInsert
import com.example.roomdatabase.ui.theme.view.mahasiswa.InsertMhsView

@Composable
fun PengelolaHalaman(
    navController: NavController = rememberNavController(),
    modifier: Modifier = Modifier
){
    NavHost(
        navController = NavController,
        startDestination = DestinasiInsert.route
    ) {
        composable(
            route = DestinasiInsert.route
        ){
            InsertMhsView(
                onBack = {},onNavigate = {})
        }



    }
}