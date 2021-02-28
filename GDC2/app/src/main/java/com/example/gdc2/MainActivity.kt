package com.example.gdc2

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView
import android.widget.Toast
import com.google.android.material.button.MaterialButton
import com.google.android.material.textfield.TextInputEditText


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val textInputEditTextUsername : TextInputEditText = findViewById(R.id.textInputEditTextUsername)
        val textInputEditTextPassword : TextInputEditText = findViewById(R.id.textInputEditTextPassword)
        val buttonLogin : MaterialButton = findViewById(R.id.inputButton)
        val buttonSignUp : MaterialButton = findViewById(R.id.signUpSendButton)

        buttonLogin.setOnClickListener(){
            Toast.makeText(this,"Giriş Başarılı: " + textInputEditTextUsername.text, Toast.LENGTH_SHORT).show()
        }

        buttonSignUp.setOnClickListener(){
            val intent = Intent(this,SignUpActivity::class.java)
            startActivity(intent)
        }



    }


}
