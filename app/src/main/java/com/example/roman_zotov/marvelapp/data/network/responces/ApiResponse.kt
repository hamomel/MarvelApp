package com.example.roman_zotov.marvelapp.data.network.responces

data class ApiResponse(val copyright: String = "",
                       val code: Int = 0,
                       val data: Data?,
                       val attributionHTML: String = "",
                       val attributionText: String = "",
                       val etag: String = "",
                       val status: String = "")