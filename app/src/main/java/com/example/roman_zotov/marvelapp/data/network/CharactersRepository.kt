package com.example.roman_zotov.marvelapp.data.network

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.MutableLiveData
import com.example.roman_zotov.marvelapp.data.network.api.CharactersApi
import com.example.roman_zotov.marvelapp.data.network.responces.Character
import com.example.roman_zotov.marvelapp.utils.getApiMD5
import com.example.roman_zotov.marvelapp.utils.getPublicApiKey
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

/**
 * Created by Roman_Zotov on 02-Feb-18.
 */
class CharactersRepository(private val charadtersApi: CharactersApi) {

    fun getAllCharacters() : LiveData<List<Character>> {
        val result = MutableLiveData<List<Character>>()
        val timestamp = getTimeStamp()
        val call = charadtersApi.getAllCharacters(timestamp, getPublicApiKey(), getApiMD5(timestamp), 20.toString())

        call.enqueue(object : Callback<List<Character>> {
            override fun onResponse(call: Call<List<Character>>?, response: Response<List<Character>>?) {
                result.value = response?.body()
            }

            override fun onFailure(call: Call<List<Character>>?, t: Throwable?) {
                t?.let { throw it }
            }
        })

        return result
    }

    private fun getTimeStamp() = System.currentTimeMillis().toString()
}