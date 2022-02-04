package com.example.placeholder.ui.theme.navigation

import androidx.compose.foundation.layout.Column
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.placeholder.ui.theme.views.DetailScreen
import com.example.placeholder.ui.theme.views.InitViewSearch
import com.example.placeholder.viewmodel.AlbumViewModel

@ExperimentalMaterialApi
@Composable
fun NavigationGraph(viewModel: AlbumViewModel) {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = Screen.SEARCH_SCREEN.route) {
        composable(route = Screen.SEARCH_SCREEN.route) {
            Column() {
                InitViewSearch(viewModel, navController)
            }
        }
        composable(route = "DetailScreen/{album_image}/{album_title}/{album_id}",
            arguments = listOf(
                navArgument("album_image") { type = NavType.StringType },
                navArgument("album_title") { type = NavType.StringType },
                navArgument("album_id") { type = NavType.StringType }
            )
//            arguments = listOf(
//                navArgument("ID") {type = NavType.StringType},
//                navArgument("TITLE") {type = NavType.StringType},
//                navArgument("IMAGE") {type = NavType.StringType},)
        ) {
            DetailScreen(it)
        }

    }
}