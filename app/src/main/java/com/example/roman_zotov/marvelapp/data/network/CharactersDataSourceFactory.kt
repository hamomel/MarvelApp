package com.example.roman_zotov.marvelapp.data.network

import android.arch.paging.DataSource
import com.example.roman_zotov.marvelapp.data.network.api.CharactersApi
import com.example.roman_zotov.marvelapp.data.network.responces.Character


/**
 * Created by hamom on 27.03.18.
 */
class CharactersDataSourceFactory(private val api: CharactersApi) : DataSource.Factory<Int, Character>() {

    override fun create(): DataSource<Int, Character> = CharacterDataSource(api)
}

