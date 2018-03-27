package com.example.roman_zotov.marvelapp.data.network

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.MutableLiveData
import com.example.roman_zotov.marvelapp.data.network.api.CharactersApi
import com.example.roman_zotov.marvelapp.data.network.responces.CharactersResponse
import com.example.roman_zotov.marvelapp.data.network.responces.Character
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

/**
 * Created by Roman_Zotov on 02-Feb-18.
 */
class CharactersRepository(private val charactersApi: CharactersApi) {

    fun getAllCharacters() : LiveData<List<Character>> {
        val result = MutableLiveData<List<Character>>()
        val call = charactersApi.getAllCharacters(0)

        call.enqueue(object : Callback<CharactersResponse> {
            override fun onResponse(call: Call<CharactersResponse>?,
                                    response: Response<CharactersResponse>?) {
                val res = response?.body()
                result.value = res?.data?.results
            }

            override fun onFailure(call: Call<CharactersResponse>?, t: Throwable?) {
                t?.let { throw it }
            }
        })

        return result
    }
}