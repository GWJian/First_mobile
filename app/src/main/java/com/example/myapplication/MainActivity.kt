package com.example.myapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {

    var counter = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val myBtn01 = findViewById<Button>(R.id.Button001)
        val myBtn02 = findViewById<Button>(R.id.Button002)
        val myTxt = findViewById<TextView>(R.id.myTextView)
        val btn2 = findViewById<Button>(R.id.launchSecondActivity)

        myBtn01.setOnClickListener{
            //Toast.makeText(this,"The button is clicked",Toast.LENGTH_LONG).show()
            counter++
            myTxt.text = "The button is clicked $counter times!"
        }

        myBtn02.setOnClickListener{
            counter = 0
            myTxt.text = "Back to 0,Hello World!"
        }

        btn2.setOnClickListener {
            val intent = Intent(this,MainActivity2::class.java)
            intent.putExtra("extraMessage","Greeting from the MainActivity")
            intent.putExtra("extraMessage2","Additional information")
            intent.putExtra("extraInt",100)
            startActivity(intent)
        }
    }

    override fun onStart() {
        super.onStart()
        Log.d("hello", "onStart is called")
    }

    override fun onResume() {
        super.onResume()
        Log.d("hello", "onResume is called")
    }

    override fun onPause() {
        super.onPause()
        Log.d("hello", "onPause is called")
    }

    override fun onStop() {
        super.onStop()
        Log.d("hello", "onStop is called")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d("hello", "Activity is destroyed")
    }
}