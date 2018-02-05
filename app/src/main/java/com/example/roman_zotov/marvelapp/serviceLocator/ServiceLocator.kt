package com.example.roman_zotov.marvelapp.serviceLocator

import com.example.roman_zotov.marvelapp.data.network.CharactersRepository
import com.example.roman_zotov.marvelapp.data.network.api.CharactersApi
import com.example.roman_zotov.marvelapp.utils.BASE_URL
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

/**
 * Created by Roman_Zotov on 02-Feb-18.
 */

object ServiceLocator {

    private val charactersApi: CharactersApi by lazy { createChaaractersApi() }
    private val okhttpClient: OkHttpClient by lazy { createOkhttpClient() }
    private val retrofit: Retrofit by lazy { createRetrofit() }

    val charactersRepository: CharactersRepository by lazy { CharactersRepository(charactersApi) }

    private fun createOkhttpClient(): OkHttpClient {
        val logger = HttpLoggingInterceptor()
        logger.level = HttpLoggingInterceptor.Level.BODY

        return OkHttpClient.Builder()
                .addInterceptor(logger)
                .build()
    }


    private fun createRetrofit(): Retrofit = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .client(okhttpClient)
            .build()

    private fun createChaaractersApi(): CharactersApi = retrofit.create(CharactersApi::class.java)
}