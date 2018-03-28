package com.example.roman_zotov.marvelapp.ui.character

import android.support.v4.app.Fragment
import com.example.roman_zotov.marvelapp.ui.base.OneFragmentActivity

class CharactersActivity : OneFragmentActivity() {
    override fun getFragment(): Fragment = CharactersFragment.newInstance()
}
