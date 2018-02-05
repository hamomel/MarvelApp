package com.example.roman_zotov.marvelapp.data.network

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.MutableLiveData
import com.example.roman_zotov.marvelapp.data.network.api.CharactersApi
import com.example.roman_zotov.marvelapp.data.network.responces.ApiResponse
import com.example.roman_zotov.marvelapp.data.network.responces.ResultsItem
import com.example.roman_zotov.marvelapp.utils.getApiMD5
import com.example.roman_zotov.marvelapp.utils.getPublicApiKey
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

/**
 * Created by Roman_Zotov on 02-Feb-18.
 */
class CharactersRepository(private val charadtersApi: CharactersApi) {

    fun getAllCharacters() : LiveData<List<ResultsItem>> {
        val result = MutableLiveData<List<ResultsItem>>()
        val timestamp = getTimeStamp()
        val call = charadtersApi.getAllCharacters(timestamp, getPublicApiKey(), getApiMD5(timestamp), 20.toString())

        call.enqueue(object : Callback<ApiResponse> {
            override fun onResponse(call: Call<ApiResponse>?, response: Response<ApiResponse>?) {
                val res = response?.body()
                result.value = res?.data?.results
            }

            override fun onFailure(call: Call<ApiResponse>?, t: Throwable?) {
                t?.let { throw it }
            }
        })

        return result
    }

    private fun getTimeStamp() = System.currentTimeMillis().toString()
}