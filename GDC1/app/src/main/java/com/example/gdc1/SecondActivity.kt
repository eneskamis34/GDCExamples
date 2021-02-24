package com.example.gdc1

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class SecondActivity : AppCompatActivity() {

    lateinit var numberText : TextView
    lateinit var butonSonucGonder : Button
    lateinit var adiniz : EditText
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

        adiniz = findViewById(R.id.editTextAdiniz)
        numberText = findViewById(R.id.numberText)
        getData() // 2.sayfadan gelen veriyi çekiyoruz.
        butonSonucGonder = findViewById(R.id.buttonSonucGonder)

        butonSonucGonder.setOnClickListener(){
            odulSayfasinaGonder()
        }

    }
    private fun getData(): String? {
        val getData = intent.getStringExtra("diceNumber")
        numberText.setText(getData)
        return getData
    }

    private fun odulSayfasinaGonder() {
        val ad = adiniz.text.toString()
        val number = getData()
        val intent = Intent(this,SonucActivity::class.java)
        intent.putExtra("adiniz",ad)
        intent.putExtra("zar",number.toString())
        startActivity(intent)
    }
}