package com.example.roman_zotov.marvelapp.ui.character

import android.app.Application
import android.arch.lifecycle.AndroidViewModel
import com.example.roman_zotov.marvelapp.serviceLocator.ServiceLocator

/**
 * Created by Roman_Zotov on 02-Feb-18.
 */
class CharactersViewModel(application: Application) : AndroidViewModel(application) {

    private val repository = ServiceLocator.charactersRepository

    fun getCharacters() = repository.getAllCharacters()
}