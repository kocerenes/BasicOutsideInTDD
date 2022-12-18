package com.enesk.basicoutsideintdd.unittests

import com.enesk.basicoutsideintdd.Car
import com.enesk.basicoutsideintdd.Engine
import com.example.outsideintddexample.acceptancetests.MainCoroutineScopeRule
import junit.framework.TestCase.assertEquals
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.test.runBlockingTest
import kotlinx.coroutines.test.runTest
import org.junit.Rule
import org.junit.Test
import org.mockito.kotlin.mock
import org.mockito.kotlin.times
import org.mockito.kotlin.verify
import org.mockito.kotlin.whenever

@OptIn(ExperimentalCoroutinesApi::class)
class CarShould {

    private val engine: Engine = mock()
    private val car: Car

    init {
        runTest {
            whenever(engine.turnOn()).thenReturn(flow {
                delay(2000)
                emit(25)
                delay(2000)
                emit(50)
                delay(2000)
                emit(95)
            })
        }
        car = Car(engine, 5.0)
    }

    @get:Rule
    var coroutinesTestRule = MainCoroutineScopeRule()

    @Test
    fun looseFuelWhenItTurnOn() = runTest {
        car.turnOn()
        assertEquals(4.5, car.fuel)
    }

    @Test
    fun turnOnItsEngine() = runTest {
        car.turnOn()
        verify(engine, times(1)).turnOn()
    }
}