package com.example.roman_zotov.marvelapp.data.network.responces

data class Thumbnail(val path: String = "",
                     val extension: String = "") {
    val url
      get() = path + "." + extension
}