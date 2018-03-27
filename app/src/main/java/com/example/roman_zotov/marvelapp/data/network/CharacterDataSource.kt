package com.example.roman_zotov.marvelapp.data.network

import android.arch.paging.DataSource
import android.arch.paging.PositionalDataSource
import com.example.roman_zotov.marvelapp.data.network.api.CharactersApi
import com.example.roman_zotov.marvelapp.data.network.responces.Character
import com.example.roman_zotov.marvelapp.data.network.responces.CharactersResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


/**
 * Created by hamom on 27.03.18.
 */
class CharactersDataSourceFactory(private val api: CharactersApi) : DataSource.Factory<Int, Character>() {

    override fun create(): DataSource<Int, Character> = CharacterDataSource<Character>(api)

    class CharacterDataSource<Value>(private val api: CharactersApi) : PositionalDataSource<Value>() {

        override fun loadRange(params: LoadRangeParams, callback: LoadRangeCallback<Value>) {
            api.getAllCharacters(params.startPosition, params.loadSize)
                    .enqueue(object : Callback<CharactersResponse> {
                        override fun onFailure(call: Call<CharactersResponse>?, t: Throwable?) {

                        }

                        @Suppress("UNCHECKED_CAST")
                        override fun onResponse(call: Call<CharactersResponse>?, response: Response<CharactersResponse>?) {
                            val result = response?.body()?.data?.results as MutableList<List<Character>>
                            callback.onResult(result as List<Value>)
                        }

                    })
        }

        override fun loadInitial(params: LoadInitialParams, callback: LoadInitialCallback<Value>) {

            api.getAllCharacters(params.requestedStartPosition, params.requestedLoadSize)
                    .enqueue(object : Callback<CharactersResponse> {
                        override fun onFailure(call: Call<CharactersResponse>?, t: Throwable?) {

                        }

                        @Suppress("UNCHECKED_CAST")
                        override fun onResponse(call: Call<CharactersResponse>?, response: Response<CharactersResponse>?) {
                            val data = response?.body()?.data
                            val result = data?.results as MutableList<List<Character>>
                            val totalCount = data.total
                            callback.onResult(result as List<Value>, 0, totalCount)
                        }
                    })
        }
    }
}