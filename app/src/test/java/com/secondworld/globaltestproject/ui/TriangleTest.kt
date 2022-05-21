package com.secondworld.globaltestproject.ui

import org.junit.Assert.*
import org.junit.Test

class TriangleTest{

    @Test
    fun test_valid_data(){
        val triangle = Triangle(3,4,5)
        val actual = triangle.isRightTriangle()
        val expected = true
        assertEquals(expected, actual)
    }

}
