package com.example.roman_zotov.marvelapp.data.network

import android.arch.lifecycle.LiveData
import android.arch.paging.LivePagedListBuilder
import android.arch.paging.PagedList
import android.os.Handler
import android.os.Looper
import com.example.roman_zotov.marvelapp.data.network.api.CharactersApi
import com.example.roman_zotov.marvelapp.data.network.responces.Character
import java.util.concurrent.Executor
import java.util.concurrent.Executors

/**
 * Created by hamom on 27.03.18.
 */
object NetworkPagedListsProvider {
    private const val DEFAULT_PAGE_SIZE = 30
    private val charactersDataSourceFactory by lazy { CharactersDataSourceFactory(CharactersApi.create()) }

    private val listConfig = PagedList.Config.Builder()
            .setEnablePlaceholders(true)
            .setInitialLoadSizeHint(DEFAULT_PAGE_SIZE * 2)
            .setPageSize(DEFAULT_PAGE_SIZE)
            .setPrefetchDistance(DEFAULT_PAGE_SIZE)
            .build()

    val characters  by lazy {
        LivePagedListBuilder<Int, Character>(
                charactersDataSourceFactory, listConfig)
                .build()
    }

    fun getCharactersList() : PagedList<Character> {
        val backGroundExecutor = Executors.newSingleThreadExecutor()
        val mainThreadExecutor = object : Executor {
            val handler = Handler(Looper.getMainLooper())
            override fun execute(command: Runnable?) {
                handler.post(command)
            }
        }

        val characterDataSource = CharacterDataSource(CharactersApi.create())

        return PagedList.Builder<Int, Character>(characterDataSource, listConfig)
                .setBackgroundThreadExecutor(mainThreadExecutor)
                .setMainThreadExecutor(mainThreadExecutor)
                .build()
    }
}
