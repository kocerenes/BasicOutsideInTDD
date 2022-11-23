package com.enesk.basicoutsideintdd.acceptancetests

import com.enesk.basicoutsideintdd.Car
import junit.framework.Assert.assertEquals
import org.junit.Test

class CarFeature {

    private val car = Car(6.0)

    @Test
    fun carIsLoosingFuelWhenItTurnOn() {
        car.turnOn()
        assertEquals(5.5, car.fuel)
    }
}