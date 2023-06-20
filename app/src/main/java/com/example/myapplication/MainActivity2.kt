package com.example.myapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.core.widget.addTextChangedListener

class MainActivity2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)

        val message = intent.getStringExtra("extraMessage") ?: "The message is null"
        val message2 = intent.getStringExtra("extraMessage2") ?: "The message is null"
        val x = intent.getIntExtra("extraInt", 0 )

        Log.d("helloSecondActivity",message)
        Log.d("helloSecondActivity",message2)
        Log.d("helloSecondActivity",x.toString())

        val greeting = findViewById<TextView>(R.id.secondText)
        //message 代替 greeting.text
        greeting.text = message

        val myEditText = findViewById<EditText>(R.id.myEditText)
        val myEditText2 = findViewById<EditText>(R.id.myEditText2)
        val button = findViewById<Button>(R.id.CopyTheText)

        button.setOnClickListener {
            val txt = myEditText.text.toString()
            myEditText2.setText(txt)
        }

        myEditText.addTextChangedListener {text ->
            Log.d("helloSecondActivity",text.toString())
        }

        //跟上面 line 26 一样但比较复杂pattern
//        myEditText.addTextChangedListener(object: TextWatcher{
//            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
//
//            }
//
//            override fun onTextChanged(text: CharSequence?, p1: Int, p2: Int, p3: Int) {
//                Log.d("helloSecondActivity", text.toString())
//            }
//
//            override fun afterTextChanged(s: Editable?) {
//
//            }
//        })


        val backbtn = findViewById<Button>(R.id.backHome)

        backbtn.setOnClickListener { 
            val intent = Intent(this,MainActivity::class.java)
            startActivity(intent)
        }

    }
}