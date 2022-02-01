package com.example.placeholder.data

import com.example.placeholder.models.Albums
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {
    @GET("films")
    suspend fun getSearchAlbum(@Query("albumQ") albumQ: String): Response<Albums>
}