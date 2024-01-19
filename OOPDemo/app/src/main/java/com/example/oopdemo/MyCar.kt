package com.example.oopdemo

import android.util.Log

class MyCar : Car(),SpeedController{
    override fun start() {
        Log.i("MyTag","MyCar is starting..${starting()}")
        super.start()
    }

    override fun accelerate() {
        TODO("Not yet implemented")
    }

    override fun decellerate() {
        TODO("Not yet implemented")
    }


}