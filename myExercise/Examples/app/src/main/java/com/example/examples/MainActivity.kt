package com.example.examples

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.TextView
import com.google.android.material.button.MaterialButton

class MainActivity : AppCompatActivity() {

    private lateinit var textName : EditText
    private lateinit var textAge : EditText
    private lateinit var textJob : EditText
    private lateinit var outPutText : TextView
    private lateinit var buttonCreate : MaterialButton

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        textName = findViewById(R.id.textInputName)
        textAge = findViewById(R.id.textInputAge)
        textJob = findViewById(R.id.textInputJob)
        outPutText = findViewById(R.id.textViewOutPut)
        buttonCreate = findViewById(R.id.buttonCreateSimpson)

        buttonCreate.setOnClickListener {

            val name = textName.text.toString()
            val age = textAge.text.toString().toIntOrNull()
            val job = textJob.text.toString()
            if(age == null)
            {
                outPutText.text = "Error!"
            }
            else
            {
                var simpson = Simpson(name,age.toInt(),job);
                outPutText.text = "Name :  ${simpson.name} Age : ${simpson.age}  Job : ${simpson.job}"
            }
            //outPutText.text = "Name :  ${name} Age : ${age}  Job : ${job}"
        }

    }


}