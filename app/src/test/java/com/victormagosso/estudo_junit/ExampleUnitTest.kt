package com.victormagosso.estudo_junit

import org.junit.Test

import org.junit.Assert.*


class ExampleUnitTest {
    @Test
    fun addition_isCorrect() {
        assertEquals(4, 2 + 2)
        assertEquals(3, 2 + 1)
        assertEquals(5, 2 + 3)
        assertEquals(4, 0 + 4)
        assertEquals(12, 2 + 10)
    }
    @Test
    fun emailValidator_CorrectEmailSimples_ReturnsTrue() {
//        assertThat(MainActivity)
    }
}