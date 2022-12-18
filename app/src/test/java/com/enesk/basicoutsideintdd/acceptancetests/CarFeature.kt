package com.enesk.basicoutsideintdd.acceptancetests

import com.enesk.basicoutsideintdd.Car
import com.enesk.basicoutsideintdd.Engine
import com.example.outsideintddexample.acceptancetests.MainCoroutineScopeRule
import junit.framework.TestCase.assertEquals
import junit.framework.TestCase.assertTrue
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.delay
import kotlinx.coroutines.test.runTest
import org.junit.Rule
import org.junit.Test

@OptIn(ExperimentalCoroutinesApi::class)
class CarFeature {

    private val engine = Engine()
    private val car = Car(engine, 6.0)

    @get:Rule
    var coroutinesTestRule = MainCoroutineScopeRule()

    @Test
    fun carIsLoosingFuelWhenItTurnOn() = runTest {
        car.turnOn()
        assertEquals(5.5, car.fuel)
    }

    @Test
    fun carIsTurningOnItsEngineAndIncreasesTheTemperatureGradually() = runTest {
        car.turnOn()

        delay(2000)
        assertEquals(25, car.engine.temperature)

        delay(2000)
        assertEquals(50, car.engine.temperature)

        delay(2000)
        assertEquals(95, car.engine.temperature)

        assertTrue(car.engine.isTurnedOn)
    }
}