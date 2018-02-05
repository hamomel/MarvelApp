package com.example.roman_zotov.marvelapp.utils


/**
 * Created by Roman_Zotov on 02-Feb-18.
 */

fun getPublicApiKey() = PUBLIC_KEY
private fun getPrivateApiKey() = PRIVATE_KEY

fun getApiMD5(timeStamp: String): String {
    val codeString = timeStamp + getPrivateApiKey() + getPublicApiKey()
    return MD5Generator.md5(codeString)
}