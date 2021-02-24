package com.example.gdc1

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.Toast

class MainActivity : AppCompatActivity() {

    lateinit var buttonZarAt : Button
    lateinit var zarImage : ImageView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        buttonZarAt = findViewById(R.id.buttonDiceZarAt)
        zarImage = findViewById(R.id.diceImage)

        buttonZarAt.setOnClickListener(){
            zarAt()
            sonucGonder()
        }
    }

    private fun zarAt(): Int {
        var randomNumber = (1..6).random()
        val drawableResourse = when(randomNumber)
        {
            1 -> R.drawable.dice1
            2 -> R.drawable.dice2
            3 -> R.drawable.dice3
            4 -> R.drawable.dice4
            5 -> R.drawable.dice5
            else -> R.drawable.dice6
        }
        zarImage.setImageResource(drawableResourse)
        zarImage.visibility = View.VISIBLE
        Toast.makeText(this,"Gelen Zar: "+randomNumber,Toast.LENGTH_SHORT).show()
        return randomNumber
    }

    private fun sonucGonder() {
        var randomNumber = zarAt()

        val intent = Intent(this,SecondActivity::class.java)
        intent.putExtra("diceNumber",randomNumber.toString())
        startActivity(intent)
    }

}