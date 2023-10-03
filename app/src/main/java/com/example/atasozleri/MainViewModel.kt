package com.example.atasozleri

import android.content.Context
import androidx.lifecycle.ViewModel
import com.google.gson.Gson

class MainViewModel(val context:Context):ViewModel() {
    private var list:Array<Atasoz> = emptyArray()
    private var index=0
    init {
        list= loadwordsfromAssets()
    }


    private fun loadwordsfromAssets(): Array<Atasoz> {
           val inputStream =context.assets.open("atasoz.json")
            val size:Int=inputStream.available()
        val buffer=ByteArray(size)
        inputStream.read(buffer)
        inputStream.close()
        val json= String(buffer, Charsets.UTF_8)
        val gson= Gson()
       return gson.fromJson(json  , Array<Atasoz>::class.java)
    }

    fun getAtasoz()=list[index]
    fun nextsoz()=list[++index]
    fun prevsoz()=list[--index]
}

