package com.enesk.basicoutsideintdd.unittests

import com.enesk.basicoutsideintdd.Car
import junit.framework.TestCase.assertEquals
import org.junit.Test
import org.mockito.kotlin.mock
import org.mockito.kotlin.times
import org.mockito.kotlin.verify

class CarShould {

    private val engine: Engine = mock()
    private val car = Car(5.0)

    @Test
    fun looseFuelWhenItTurnOn() {
        car.turnOn()

        assertEquals(4.5, car.fuel)
    }

    @Test
    fun turnOnItsEngine() {
        car.turnOn()
        verify(engine, times(1)).turnOn()
    }
}