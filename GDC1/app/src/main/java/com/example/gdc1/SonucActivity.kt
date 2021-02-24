package com.example.gdc1

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import org.w3c.dom.Text

class SonucActivity : AppCompatActivity() {
    lateinit var ad : TextView
    lateinit var zar : TextView
    lateinit var sonucMiktari : TextView
    lateinit var yeniZarAt : Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sonuc)

        ad = findViewById(R.id.textAdi)
        zar = findViewById(R.id.textZar)
        sonucMiktari = findViewById(R.id.textOdulMiktari)
        yeniZarAt =  findViewById(R.id.buttonYeniZar)


        val getZar = intent.getStringExtra("zar")
        zar.setText(getZar)

        val getName = intent.getStringExtra("adiniz")
        ad.setText(getName)

        var getZarInt = getZar.toInt()

        var hesaplananOdul = when(getZarInt)
        {
            1 -> "10 TL"
            2 -> "20 TL"
            3 -> "30 TL"
            4 -> "40 TL"
            5 -> "50 TL"
            else -> "60 TL"
        }
        sonucMiktari.setText(hesaplananOdul)

        yeniZarAt.setOnClickListener(){
            val intent = Intent(this,MainActivity::class.java)
            startActivity(intent)
        }
    }

}