package com.enesk.basicoutsideintdd.unittests

import com.enesk.basicoutsideintdd.Car
import junit.framework.TestCase.assertEquals
import org.junit.Test

class CarShould {

    private val car = Car(5.0)

    @Test
    fun looseFuelWhenItTurnOn() {
        car.turnOn()

        assertEquals(4.5, car.fuel)
    }
}