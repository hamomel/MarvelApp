package com.example.roman_zotov.marvelapp.data.network.responces

data class Stories(val collectionURI: String = "",
                   val available: Int = 0,
                   val returned: Int = 0,
                   val items: List<NameWithUrlItem>?)