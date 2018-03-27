package com.example.roman_zotov.marvelapp.data.network.responces

data class Character(val thumbnail: Thumbnail?,
                     val urls: List<UrlWithTypeItem>?,
                     val stories: Stories?,
                     val series: Series?,
                     val comics: Comics?,
                     val name: String = "",
                     val description: String = "",
                     val modified: String = "",
                     val id: Int = 0,
                     val resourceURI: String = "",
                     val events: Events?)