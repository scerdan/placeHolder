package com.example.placeholder.models

import com.google.gson.annotations.SerializedName

data class AlbumSearchResponse(
    @SerializedName("items")
    val userItems: ArrayList<AlbumsItem>?,
    @SerializedName("total_count")
    val totalCount: Int?
)
