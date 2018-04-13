package com.example.roman_zotov.marvelapp.ui.di

import com.example.roman_zotov.marvelapp.data.network.CharactersRepository
import com.example.roman_zotov.marvelapp.ui.character.CharactersActivity
import com.example.roman_zotov.marvelapp.ui.character.CharactersViewModel
import org.koin.android.architecture.ext.viewModel
import org.koin.dsl.module.applicationContext

/**
 * Created by Roman_Zotov on 13-Apr-18.
 *
 */

val charactersModule = applicationContext {
    context(CharactersActivity::class.java.name){
        viewModel { CharactersViewModel(get()) }
    }
}

val appModule = applicationContext {
    bean { CharactersRepository() }
}