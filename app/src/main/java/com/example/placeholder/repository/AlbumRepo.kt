package com.example.placeholder.repository

import com.example.placeholder.data.ApiService
import com.example.placeholder.models.Albums
import retrofit2.Response
import javax.inject.Inject

class AlbumRepo @Inject constructor(private val apiService: ApiService) {

    suspend fun getAnimeFilm(): Response<Albums> {
        return apiService.getSearchAlbum()
    }

}