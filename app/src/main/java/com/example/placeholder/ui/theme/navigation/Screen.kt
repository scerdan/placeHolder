package com.example.placeholder.ui.theme.navigation

sealed class Screen(val route: String) {
    object SEARCH_SCREEN: Screen("SearchScreen")
    object DETAIL_SCREEN: Screen("DetailScreen/{album_image}/{album_title}/{album_id}")
}
