package com.example.placeholder.repository

import com.example.placeholder.data.ApiService
import com.example.placeholder.models.Albums
import com.example.placeholder.models.AlbumsItem
import retrofit2.Response
import javax.inject.Inject

class AlbumRepo @Inject constructor(private val apiService: ApiService) {

    suspend fun getSearch(q: String): Response<Albums> {
        return apiService.getSearchTitle(q)
    }

}
