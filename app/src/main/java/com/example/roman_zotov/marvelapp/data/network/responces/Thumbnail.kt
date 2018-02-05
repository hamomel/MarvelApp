package com.example.roman_zotov.marvelapp.data.network.responces

data class Thumbnail(private val path: String = "", private val extension: String = "") {
    val url = path + "." + extension
}