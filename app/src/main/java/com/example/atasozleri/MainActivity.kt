package com.example.atasozleri

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.lifecycle.ViewModelProvider

class MainActivity : AppCompatActivity() {
    lateinit var mainViewModel: MainViewModel

    private val atext: TextView
    get() = findViewById(R.id.wordtext)
    private val aAuthor: TextView
        get() = findViewById(R.id.sozauth)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        mainViewModel= ViewModelProvider(this,MainViewModelFactory(application)).get(MainViewModel::class.java)
        setAtasoz(mainViewModel.getAtasoz())
    }
    fun setAtasoz(atasoz: Atasoz){
        atext.text=atasoz.text
        aAuthor.text=atasoz.auth
    }

    fun onPrevious(view: View) {
       setAtasoz(mainViewModel.prevsoz())
    }
    fun onNext(view: View) {
        setAtasoz(mainViewModel.nextsoz())
    }
    fun onShare(view: View) {
        val intent= Intent(Intent.ACTION_SEND)
        intent.setType("text/plain")
        intent.putExtra(Intent.EXTRA_TEXT,mainViewModel.getAtasoz().text)
        startActivity(intent)
    }
}