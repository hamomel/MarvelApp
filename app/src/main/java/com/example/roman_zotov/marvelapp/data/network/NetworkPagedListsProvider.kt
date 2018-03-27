package com.example.roman_zotov.marvelapp.data.network

import android.arch.paging.LivePagedListBuilder
import com.example.roman_zotov.marvelapp.data.network.api.CharactersApi
import com.example.roman_zotov.marvelapp.data.network.responces.Character

/**
 * Created by hamom on 27.03.18.
 */
object NetworkPagedListsProvider {
    private const val DEFAULT_PAGE_SIZE = 30

    val characters by lazy { LivePagedListBuilder<Int, Character>(
            CharactersDataSourceFactory(CharactersApi.create()),
            DEFAULT_PAGE_SIZE)
    }
}