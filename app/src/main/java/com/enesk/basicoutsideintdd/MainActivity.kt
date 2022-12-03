package com.enesk.basicoutsideintdd

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val engine = Engine()
        val car = Car(engine,20.00)
        car.turnOn()
    }
}