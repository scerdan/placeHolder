package com.example.placeholder

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.hilt.navigation.compose.hiltViewModel
import coil.annotation.ExperimentalCoilApi
import com.example.placeholder.models.AlbumsItem
import com.example.placeholder.ui.theme.PlaceHolderTheme
import com.example.placeholder.viewmodel.AlbumViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    private val viewModel: AlbumViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            PlaceHolderTheme {
                ReciveData(viewModel)
            }
        }
    }

    @Composable
    fun ReciveData(
        ivm: AlbumViewModel = hiltViewModel()
    ) {
        val tit by ivm.getResponses().observeAsState()
        tit?.let { AnimeListScreen(it) }
    }

    @ExperimentalCoilApi
    @Composable
    fun AnimeListScreen(tit: ArrayList<AlbumsItem>) {
    val filtrado = tit.filter { it.title.startsWith("a") }

        mostrarListado(filtrado)

    }

    @Composable
    fun mostrarListado(filtrado: List<AlbumsItem>) {
        LazyColumn() {
            items(filtrado) {
                Text(text = "$filtrado")
            }
        }
    }
}