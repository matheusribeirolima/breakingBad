package com.example.breakingbad.data

import javax.inject.Inject

class CharacterRepository @Inject constructor(private val characterApi: CharacterApi) {

    suspend fun getCharacters(limit: Int?, offset: Int?) = characterApi.getCharacters(limit, offset)
}
