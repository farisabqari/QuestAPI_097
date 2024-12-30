package com.example.myapplicationdatabase.Navigasi

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.myapplicationdatabase.ui.View.DestinasiDetail
import com.example.myapplicationdatabase.ui.View.DestinasiEntry
import com.example.myapplicationdatabase.ui.View.DestinasiHome
import com.example.myapplicationdatabase.ui.View.DestinasiUpdate
import com.example.myapplicationdatabase.ui.View.DetailScreen
import com.example.myapplicationdatabase.ui.View.EntryMhsScreen
import com.example.myapplicationdatabase.ui.View.HomeScreen
import com.example.myapplicationdatabase.ui.View.UpdateScreen

@Composable
fun PengelolaHalaman(
    navController: NavHostController = rememberNavController()
) {
    NavHost(
        navController = navController,
        startDestination = DestinasiHome.route,
        modifier = Modifier,
    ) {
        composable(DestinasiHome.route) {
            HomeScreen(
                navigateToItemEntry = { navController.navigate(DestinasiEntry.route) },
                onDetailClick = { nim ->
                    navController.navigate("${DestinasiDetail.route}/$nim")
                }
            )
        }
        composable(DestinasiEntry.route) {
            EntryMhsScreen(
                navigateBack = {
                    navController.navigate(DestinasiHome.route) {
                        popUpTo(DestinasiHome.route) {
                            inclusive = true
                        }
                    }
                }
            )
        }
    }
}