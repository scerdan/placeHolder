package com.example.placeholder.repository

import com.example.placeholder.data.ApiService
import com.example.placeholder.models.AlbumSearchResponse
import com.example.placeholder.models.Albums
import com.example.placeholder.models.AlbumsItem
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import retrofit2.Response
import javax.inject.Inject

class AlbumRepo @Inject constructor(private val apiService: ApiService) {

    suspend fun getAnimeFilm(): Response<Albums> {
        return apiService.getSearchAlbum()
    }

    suspend fun getSearch(q: String): Response<Albums> {
        return apiService.getSearchTitle(q)
    }

//    suspend fun getSearch(username: String): Response<Albums> {
//        return {
//            try {
//                val response = apiService.getSearchTitle(username)
//                val userItems = response.userItems
//                val dataMaped = userItems?.let { listSearchUser ->
//                    DataMapper.mapUserSearchResponseToDomain(listSearchUser)
//                }
//            } catch (e: Exception) {
//            }
//        }


    }

    object DataMapper {
        fun mapUserSearchResponseToDomain(data: List<AlbumsItem>): List<AlbumsItem> =
            data.map {
                AlbumsItem(
                    albumId = it.albumId,
                    id = it.id,
                    thumbnailUrl = it.thumbnailUrl,
                    title = it.title,
                    url = it.url
                )
            }
    }