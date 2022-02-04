package com.example.placeholder.ui.theme.views

import android.util.Log
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import androidx.navigation.navArgument
import com.example.placeholder.R
import com.example.placeholder.models.Photos
import com.example.placeholder.ui.theme.navigation.Screen
import com.example.placeholder.viewmodel.AlbumViewModel
import java.net.URLEncoder
import java.nio.charset.StandardCharsets


@ExperimentalMaterialApi
@Composable
fun InitViewSearch(viewModel: AlbumViewModel, navController: NavHostController) {
    val textState = remember { mutableStateOf("") }
    OutlinedTextField(textState.value,
        onValueChange = { textState.value = it },
        Modifier
            .padding(10.dp)
            .fillMaxWidth(1f),

        label = {
            Text(text = "Search your albums")
        })
    Log.e("INPOU", textState.value)
    ReciveData(viewModel, textState.value, navController)
}


@ExperimentalMaterialApi
@Composable
fun ReciveData(
    ivm: AlbumViewModel = hiltViewModel(),
    query: String,
    navController: NavHostController
) {
    val viewM by ivm.getUserFromApi(query).observeAsState()
    val query = remember {
        mutableStateOf(query)
    }
    viewM?.let {
        Log.e("RESULTADO", it.size.toString())
        MostrarListado(it, navController)
    }
}


@ExperimentalMaterialApi
@Composable
fun MostrarListado(album: Photos, navController: NavHostController) {
    Column() {
        LazyColumn(
            modifier = Modifier.fillMaxSize(1f),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            items(album) {
                Card(
                    shape = MaterialTheme.shapes.small, modifier = Modifier
                        .fillMaxWidth(0.9f)
                        .padding(0.dp,12.dp),
                    elevation = 5.dp,
                    backgroundColor = Color.Yellow,
                ) {
                    Row(
                        Modifier
                            .fillMaxWidth(1f)
                            .padding(3.dp),
                        horizontalArrangement = Arrangement.Start,
                    ) {
                        Text(
                            text = it.id.toString(),
                            maxLines = 1,
                            fontSize = 10.sp,
                        )
                    }
                    Row(
                        Modifier
                            .fillMaxWidth(1f)
                            .clickable {
                                val encodedUrl = URLEncoder.encode(it.url, StandardCharsets.UTF_8.toString())
                                navController.navigate("DetailScreen/${encodedUrl}/${it.title}/${it.id}")
                            }
                            .padding(3.dp),
                        horizontalArrangement = Arrangement.Start,
                    ) {
                        Text(
                            text = it.title,
                            maxLines = 1,
                            fontSize = 30.sp
                        )
                    }
                }
            }
        }
    }
}