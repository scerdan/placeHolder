package com.example.placeholder.viewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.placeholder.models.AlbumsItem
import com.example.placeholder.repository.AlbumRepo
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class AlbumViewModel @Inject constructor(private val repo: AlbumRepo) : ViewModel() {
    private val _response = MutableLiveData<ArrayList<AlbumsItem>>()

    fun getResponses(): LiveData<ArrayList<AlbumsItem>> {
        viewModelScope.launch(Dispatchers.IO) {
            val album = repo.getAnimeFilm()
            _response.postValue(album.body())
        }
        return _response
    }
}