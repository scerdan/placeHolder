package com.example.placeholder

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.material.ExperimentalMaterialApi
import com.example.placeholder.ui.theme.PlaceHolderTheme
import com.example.placeholder.ui.theme.navigation.NavigationGraph
import com.example.placeholder.viewmodel.AlbumViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    private val viewModel: AlbumViewModel by viewModels()

    @ExperimentalMaterialApi
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            PlaceHolderTheme {
                NavigationGraph(viewModel)
//                Surface(color = MaterialTheme.colors.background) {
//                    Column() {
//                        InitViewSearch(viewModel)
//                    }
            }

        }
    }
}

