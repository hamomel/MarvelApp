package com.example.roman_zotov.marvelapp.data.network

import android.arch.paging.PositionalDataSource
import android.util.Log
import com.example.roman_zotov.marvelapp.BuildConfig
import com.example.roman_zotov.marvelapp.data.network.api.CharactersApi
import com.example.roman_zotov.marvelapp.data.network.responces.Character
import com.example.roman_zotov.marvelapp.data.network.responces.CharactersResponse
import com.example.roman_zotov.marvelapp.utils.TAG_PREFIX
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class CharacterDataSource(private val api: CharactersApi) : PositionalDataSource<Character>() {
    private val TAG = "$TAG_PREFIX ${CharacterDataSource::class.java.simpleName} :"

    override fun loadRange(params: LoadRangeParams, callback: LoadRangeCallback<Character>) {

        api.getAllCharacters(params.startPosition, params.loadSize)
                .enqueue(object : Callback<CharactersResponse> {
                    override fun onFailure(call: Call<CharactersResponse>?, t: Throwable?) {}

                    @Suppress("UNCHECKED_CAST")
                    override fun onResponse(call: Call<CharactersResponse>?,
                                            response: Response<CharactersResponse>?) {

                        val result = response?.body()?.data?.results as MutableList<List<Character>>
                        callback.onResult(result as List<Character>)
                    }
                })
    }

    override fun loadInitial(params: LoadInitialParams, callback: LoadInitialCallback<Character>) {

        api.getAllCharacters(params.requestedStartPosition, params.requestedLoadSize)
                .enqueue(object : Callback<CharactersResponse> {
                    override fun onFailure(call: Call<CharactersResponse>?, t: Throwable?) {}

                    @Suppress("UNCHECKED_CAST")
                    override fun onResponse(call: Call<CharactersResponse>?,
                                            response: Response<CharactersResponse>?) {

                        val data = response?.body()?.data
                        val result = data?.results as MutableList<List<Character>>
                        val totalCount = data.total

                        callback.onResult(result as List<Character>, 0, totalCount)
                    }
                })
    }
}

