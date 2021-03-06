package com.example.placeholder.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.placeholder.models.Photos
import com.example.placeholder.repository.AlbumRepo
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class AlbumViewModel @Inject constructor(private val repo: AlbumRepo) : ViewModel() {
    private val _response = MutableLiveData<Photos>()

    fun getUserFromApi(query: String): LiveData<Photos> {
        viewModelScope.launch(Dispatchers.IO) {
            val album = repo.getSearch(query)
            _response.postValue(album.body())
        }
        return _response
    }

}