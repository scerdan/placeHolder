package com.example.placeholder

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import com.example.placeholder.ui.theme.InitViewSearch
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
//                ReciveData(viewModel, "x")
                Surface(color = MaterialTheme.colors.background) {
                    Column() {
                        InitViewSearch(viewModel)
                    }
                }
            }
        }
    }

//    @Composable
//    fun InitViewSearch() {
//        val textState = remember { mutableStateOf("") }
//        OutlinedTextField(textState.value,
//            onValueChange = { textState.value = it },
//            Modifier
//                .padding(10.dp)
//                .fillMaxWidth(1f),
//
//            label = {
//                Text(text = "Search your albums")
//            })
//        Log.e("INPOU", textState.value)
//        ReciveData(viewModel, textState.value)
//    }
//
//
//    @Composable
//    fun ReciveData(
//        ivm: AlbumViewModel = hiltViewModel(),
//        query: String
//    ) {
//        val tit by ivm.getUserFromApi(query).observeAsState()
//        val query = remember {
//            mutableStateOf(query)
//        }
//        tit?.let {
//            Log.e("RESULTADO", it.size.toString())
//            MostrarListado(it)
//        }
//    }
//
//
//    @Composable
//    fun MostrarListado(album: Albums) {
//        Column() {
//            LazyColumn() {
//                items(album) {
//                    Row(Modifier.fillMaxWidth(1f)
//                        .padding(3.dp),
//                    horizontalArrangement = Arrangement.Center, ) {
//                        Text(text = it.title,
//                        maxLines = 1,
//                        )
//                    }
//                }
//            }
//        }
//    }
}
