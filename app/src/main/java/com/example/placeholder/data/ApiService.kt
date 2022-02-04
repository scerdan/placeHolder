package com.example.placeholder.data

import com.example.placeholder.models.Photos
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {

    @GET("photos?")
    suspend fun getSearchAlbum(
        @Query("q") q : String
    ) : Response<Photos>
}