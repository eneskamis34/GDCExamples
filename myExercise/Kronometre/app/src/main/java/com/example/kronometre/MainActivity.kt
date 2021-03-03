package com.example.kronometre

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    var number = 0
    var runnable : Runnable = Runnable {  }
    var handler : Handler = Handler()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
    fun start(view : View)
    {
        runnable = object : Runnable{
            override fun run() {
                number = number + 1
                textViewKronometre.text = "Time : " + number
                handler.postDelayed(this,1000)
                buttonStart.isEnabled = false
                buttonStop.isEnabled = true
            }
        }
        handler.post(runnable)
    }

    fun stop(view : View)
    {
        handler.removeCallbacks(runnable)
        number = 0
        textViewKronometre.text = "Time :"+number
        buttonStart.isEnabled = true
        buttonStop.isEnabled = false
    }

    fun pause(view:View)
    {
        textViewKronometre.text = "Time :"+number
        handler.removeCallbacks(runnable)
        buttonStart.isEnabled = true
    }

    fun nextPage(view:View)
    {
        var intent = Intent(this@MainActivity,CountDownActivity::class.java)
        startActivity(intent)
    }
}