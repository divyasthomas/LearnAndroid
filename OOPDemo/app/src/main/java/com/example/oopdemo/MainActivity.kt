package com.example.oopdemo

import android.content.SharedPreferences
import android.content.SharedPreferences.Editor
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText

class MainActivity : AppCompatActivity() {
    private lateinit var nametxt:EditText
    private lateinit var agetxt:EditText
    private lateinit var sf: SharedPreferences
    private lateinit var editor: Editor

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        nametxt =  findViewById(R.id.etName)
        agetxt = findViewById(R.id.etAge)
        sf = getSharedPreferences("my_sf", MODE_PRIVATE)
        editor = sf.edit()

    }

    override fun onPause() {
        super.onPause()
        val name = nametxt.text.toString()
        val age = agetxt.text.toString().toInt()
        editor.apply(){
            putString("sf_name",name)
            putInt("sf_age",age)
            commit()
        }
    }

    override fun onResume() {
        super.onResume()
        val name = sf.getString("sf_name", null)
        val age = sf.getInt("sf_age",-1)

        nametxt.setText(name.toString())
        if (age!=-1){
            agetxt.setText(age.toString())
        }

    }




}