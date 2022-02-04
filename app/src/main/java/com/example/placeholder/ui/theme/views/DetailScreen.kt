package com.example.placeholder.ui.theme.views

import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavBackStackEntry
import coil.compose.rememberImagePainter

@Composable
fun DetailScreen(navBackStackEntry: NavBackStackEntry) {
    val album_id = navBackStackEntry.arguments?.getString("album_id")
    val album_title = navBackStackEntry.arguments?.getString("album_title")
    val album_image = navBackStackEntry.arguments?.getString("album_image")
    requireNotNull(album_id)
    requireNotNull(album_title)
    requireNotNull(album_image)

    Card(
        shape = RoundedCornerShape(8.dp),
        modifier = Modifier
            .padding(10.dp)
            .fillMaxWidth(1f)
            .fillMaxHeight(1 / 6f)
    ) {
        Row(Modifier.fillMaxSize(1f)) {
            Column(
                Modifier
                    .fillMaxHeight(1f)
                    .fillMaxWidth(1 / 3f)
            ) {
                Image(
                    modifier = Modifier
                        .fillMaxSize(1f)
                        .aspectRatio(1f),
                    painter = rememberImagePainter(album_image),
                    contentDescription = null,
                    contentScale = ContentScale.FillWidth
                )
            }
            Column(
                modifier = Modifier
                    .fillMaxSize(1f)
            ) {
                Row(
                    Modifier
                        .background(color = Color.LightGray)
                        .fillMaxWidth(1f)
                        .fillMaxHeight(1 / 2f),
                    horizontalArrangement = Arrangement.End
                ) {
                    Text(
                        album_id, fontSize = 18.sp,
                        fontWeight = FontWeight.Bold,
                        textAlign = TextAlign.End,
                        modifier = Modifier.padding(6.dp)
                    )
                }
                Row(
                    Modifier
                        .fillMaxWidth(1f)
                        .fillMaxHeight(1f),
                    verticalAlignment = Alignment.Bottom
                ) {
                    Text(
                        album_title,
                        maxLines = 1,
                        fontWeight = FontWeight.Light,
                        fontSize = 20.sp,
                        textAlign = TextAlign.Center
                    )
                }

            }
        }


    }
}
