package com.example.placeholder

import android.os.Bundle
import android.text.Layout
import android.util.Log
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Search
import androidx.compose.runtime.*
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import coil.annotation.ExperimentalCoilApi
import com.example.placeholder.models.Albums
import com.example.placeholder.models.AlbumsItem
import com.example.placeholder.ui.theme.PlaceHolderTheme
import com.example.placeholder.ui.theme.Purple500
import com.example.placeholder.viewmodel.AlbumViewModel
import dagger.hilt.android.AndroidEntryPoint
import java.util.*
import kotlin.collections.ArrayList

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    private val viewModel: AlbumViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            PlaceHolderTheme {
//                ReciveData(viewModel, "x")
                Surface(color = MaterialTheme.colors.background) {
                    Column() {
                        TTT()

                    }
                }
            }
        }
    }

    @Composable
    fun TTT() {
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
                    Row(Modifier.fillMaxWidth(1f)
                        .padding(3.dp),
                    horizontalArrangement = Arrangement.Center, ) {
                        Text(text = it.title,
                        maxLines = 1,
                        )
                    }
                }
            }
        }


    }
}
