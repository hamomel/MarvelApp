package com.example.roman_zotov.marvelapp.ui.base

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.app.AppCompatActivity
import com.example.roman_zotov.marvelapp.R

/**
 * Created by Roman_Zotov on 02-Feb-18.
 */
abstract class OneFragmentActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_one_fragment)
        supportFragmentManager.beginTransaction()
                .replace(R.id.main_frame, getFragment())
                .commit()
    }

    abstract fun getFragment(): Fragment
}