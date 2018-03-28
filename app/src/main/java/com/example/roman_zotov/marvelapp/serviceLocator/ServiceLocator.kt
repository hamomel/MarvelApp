package com.example.roman_zotov.marvelapp.serviceLocator

import com.example.roman_zotov.marvelapp.data.network.CharactersRepository
import com.example.roman_zotov.marvelapp.data.network.api.CharactersApi

/**
 * Created by Roman_Zotov on 02-Feb-18.
 */

object ServiceLocator {
    val charactersRepository: CharactersRepository by lazy { CharactersRepository() }
}