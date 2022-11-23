package com.enesk.basicoutsideintdd

class Car(var fuel: Double) {

    fun turnOn() {
        fuel -= 0.5
    }
}