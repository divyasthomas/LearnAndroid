package com.example.myapplication

import android.content.Intent
import android.opengl.Visibility
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View.INVISIBLE
import android.view.View.VISIBLE
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
            val greetingTextView = findViewById<TextView>(R.id.tv)
            val inputField = findViewById<EditText>(R.id.etName)
            val submitButton = findViewById<Button>(R.id.button)
            val offersButton = findViewById<Button>(R.id.button2)
            var enteredName = ""
        submitButton.setOnClickListener {
            enteredName = inputField.text.toString()
            if (enteredName == ""){
                greetingTextView.text = getString(R.string.hello_message)
                Toast.makeText(this@MainActivity,
                    "Please enter your Name",
                    Toast.LENGTH_LONG).show()
                offersButton.visibility = INVISIBLE

            }
            else{
                val message = "Welcome $enteredName"
                greetingTextView.text = message
//                inputField.text.clear()
                inputField.visibility = INVISIBLE
                submitButton.visibility = INVISIBLE
                offersButton.visibility= VISIBLE

            }

            offersButton.setOnClickListener {
                val intent = Intent(this,SecondActivity:: class.java)
                intent.putExtra("USER", enteredName)
                startActivity(intent)
            }


        }
    }
}