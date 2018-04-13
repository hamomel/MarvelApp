package com.example.roman_zotov.marvelapp.ui.character

import android.app.Application
import android.arch.lifecycle.AndroidViewModel
import android.arch.lifecycle.ViewModel
import com.example.roman_zotov.marvelapp.data.network.CharactersRepository
import com.example.roman_zotov.marvelapp.serviceLocator.ServiceLocator

/**
 * Created by Roman_Zotov on 02-Feb-18.
 */
class CharactersViewModel(private val repository: CharactersRepository) : ViewModel() {
    fun getCharacters() = repository.getAllCharacters()
}