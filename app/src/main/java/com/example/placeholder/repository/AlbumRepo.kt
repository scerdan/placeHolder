package com.example.placeholder.repository

import com.example.placeholder.data.ApiService
import com.example.placeholder.models.Photos
import retrofit2.Response
import javax.inject.Inject

class AlbumRepo @Inject constructor(private val apiService: ApiService) {

    suspend fun getSearch(q: String): Response<Photos> {
        return apiService.getSearchAlbum(q)
    }

}
