package com.example.roman_zotov.marvelapp.ui.character

import android.app.Application
import android.arch.lifecycle.AndroidViewModel
import android.arch.lifecycle.MutableLiveData
import android.arch.paging.PagedList
import com.example.roman_zotov.marvelapp.data.network.responces.Character
import com.example.roman_zotov.marvelapp.serviceLocator.ServiceLocator

/**
 * Created by Roman_Zotov on 02-Feb-18.
 */
class CharactersViewModel(application: Application) : AndroidViewModel(application) {

    private val repository = ServiceLocator.charactersRepository

    val characters by lazy { createCharactersLiveData() }

    private fun createCharactersLiveData(): MutableLiveData<PagedList<Character>> {
        val liveData = MutableLiveData<PagedList<Character>>()
        liveData.value = repository.getCharactersList()
        return liveData
    }

    fun invalidate() {
        characters.value = repository.getCharactersList()
    }

    fun getCharacters() = repository.getAllCharacters()
}