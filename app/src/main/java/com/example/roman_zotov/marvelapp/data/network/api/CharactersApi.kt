package com.example.roman_zotov.marvelapp.data.network.api

import com.example.roman_zotov.marvelapp.data.network.responces.CharactersResponse
import com.example.roman_zotov.marvelapp.utils.MD5Generator
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query

/**
 * Created by Roman_Zotov on 02-Feb-18.
 */
interface CharactersApi {

    @GET("characters")
    fun getAllCharacters(@Query("offset") offset: Int,
                         @Query("limit") limit: Int = 30,
                         @Query("ts") ts: Long = System.currentTimeMillis(),
                         @Query("apikey") apiKey: String = PUBLIC_KEY,
                         @Query("hash") hash: String = getApiMD5(ts)): Call<CharactersResponse>

    companion object {
        private const val PUBLIC_KEY = "bca563781d523539266643d61532fff0"
        private const val PRIVATE_KEY = "b7af72cb5980322f72bab949d1958f1f456c040a"
        private const val BASE_URL = "http://gateway.marvel.com/v1/public/"

        fun create(): CharactersApi = createRetrofit().create(CharactersApi::class.java)

        private val interceptor = HttpLoggingInterceptor()
                .setLevel(HttpLoggingInterceptor.Level.BASIC)

        private val okHttpClient = OkHttpClient.Builder()
                .addInterceptor(interceptor)
                .build()

        private fun createRetrofit() = Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .client(okHttpClient)
                .build()

        private fun getApiMD5(timeStamp: Long): String {
            val codeString = timeStamp.toString() + PRIVATE_KEY + PUBLIC_KEY
            return MD5Generator.md5(codeString)
        }
    }
}
