package com.example.placeholder.ui.theme.views

import android.util.Log
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.navigation.NavBackStackEntry

@Composable
fun DetailScreen(navBackStackEntry: NavBackStackEntry) {
    val album_id = navBackStackEntry.arguments?.getString("album_id")
    val album_title = navBackStackEntry.arguments?.getString("album_title")
    val album_image = navBackStackEntry.arguments?.getString("album_image")

    requireNotNull(album_id)
    requireNotNull(album_title)
    requireNotNull(album_image)

    Log.e("album_id =", album_image)
    Log.e("album_title =", album_image)
    Log.e("album_image =", album_image)

    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Text(
            text = "1232323",
            style = MaterialTheme.typography.h4
        )
    }
}