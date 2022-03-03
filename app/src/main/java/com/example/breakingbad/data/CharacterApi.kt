package com.example.breakingbad.data

import retrofit2.http.GET
import retrofit2.http.Query

interface CharacterApi {

    @GET("api/characters")
    suspend fun getCharacters(
        @Query("limit") limit: Int?,
        @Query("offset") offset: Int?
    ): List<CharacterDTO>
}
