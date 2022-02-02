package com.example.placeholder

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import coil.annotation.ExperimentalCoilApi
import coil.compose.rememberImagePainter
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
        LazyColumn() {
            items(tit) { rta ->
                Text(text = rta.title)
            }
        }
    }
}