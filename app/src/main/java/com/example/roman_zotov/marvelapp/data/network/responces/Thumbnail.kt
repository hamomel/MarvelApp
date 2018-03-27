package com.example.roman_zotov.marvelapp.data.network.responces

private const val SERVER_STUB = "http://i.annihil.us/u/prod/marvel/i/mg/b/40/image_not_available"
private const val MY_STUB = "http://www.kartinkijane.ru/large/201503/83312.jpg"

data class Thumbnail(private val path: String = "",
                     private val extension: String = "") {
    val url
        get() = when (path) {
            SERVER_STUB -> MY_STUB
            else -> "$path.$extension"
        }

}