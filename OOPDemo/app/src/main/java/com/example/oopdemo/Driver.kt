package com.example.oopdemo

import android.util.Log

class Driver (var name: String) {

    val car = MyCar()


    init {
        car.start()
    }

    fun showDetails(){
        Log.i("MyTag", "Name of the driver is $name")
    }
}