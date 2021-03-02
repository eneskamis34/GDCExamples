package com.example.storingdata

import android.content.Context
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    lateinit var sharedPreferences : SharedPreferences
    var getDataFromSharedPreferences : Int? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //SharedPreferences Inıtıliaze
        sharedPreferences = this.getSharedPreferences("com.example.storingdata", Context.MODE_PRIVATE)

        getDataFromSharedPreferences = sharedPreferences.getInt("age",0)
        if(getDataFromSharedPreferences == 0){
            textView.text = "Kayıtlı Yaş Yoktur!"
        }
        else {
            textView.text = "Kayıtlı Yaşınız => $getDataFromSharedPreferences"
        }

    }

    fun save(view : View)
    {

        val myAge = editText.text.toString().toIntOrNull()

        if(myAge != null)
        {
            textView.text = "Your Age => "+ myAge
            sharedPreferences.edit().putInt("age",myAge).apply()
        }
        else
        {
            textView.text = "Error!"

        }
    }

    fun delete(view : View)
    {
        getDataFromSharedPreferences = sharedPreferences.getInt("age",0)
        if(getDataFromSharedPreferences != 0)
        {
            sharedPreferences.edit().remove("age").apply()
            Toast.makeText(this,"Yaş Silindi",Toast.LENGTH_SHORT).show()
            textView.text = "Kayıtlı Yaş Yoktur!"
        }
    }

}