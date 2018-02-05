package com.example.roman_zotov.marvelapp.data.network.api

import com.example.roman_zotov.marvelapp.data.network.responces.ApiResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

/**
 * Created by Roman_Zotov on 02-Feb-18.
 */
interface CharactersApi {

    @GET("characters")
    fun getAllCharacters(@Query("ts") ts: String,
                         @Query("apikey") apiKey: String,
                         @Query("hash") hash: String,
                         @Query("offset") offset: String) : Call<ApiResponse>
}
