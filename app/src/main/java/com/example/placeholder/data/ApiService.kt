package com.example.placeholder.data

import com.example.placeholder.models.Albums
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {
    @GET("albums")
    suspend fun getSearchAlbum(): Response<Albums>

    @GET("albums?")
    suspend fun getSearchTitle(
        @Query("q") q : String
    ) : Response<Albums>
}