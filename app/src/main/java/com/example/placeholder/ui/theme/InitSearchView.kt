package com.example.placeholder.ui.theme

import android.util.Log
import android.widget.Toast
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.placeholder.models.Albums
import com.example.placeholder.viewmodel.AlbumViewModel


@Composable
fun InitViewSearch(viewModel: AlbumViewModel) {
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
    ReciveData(viewModel, textState.value)
}


@Composable
fun ReciveData(
    ivm: AlbumViewModel = hiltViewModel(),
    query: String
) {
    val tit by ivm.getUserFromApi(query).observeAsState()
    val query = remember {
        mutableStateOf(query)
    }
    tit?.let {
        Log.e("RESULTADO", it.size.toString())
        MostrarListado(it)
    }
}


@Composable
fun MostrarListado(album: Albums) {
    Column() {
        LazyColumn() {
            items(album) {
                Card(
                    shape = MaterialTheme.shapes.small, modifier = Modifier
                        .fillMaxWidth(1f)
                        .padding(10.dp)
                        .clickable { },
                    elevation = 5.dp
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