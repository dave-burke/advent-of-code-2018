package aoc.day01

import kotlin.test.Test
import kotlin.test.assertEquals

class Day01Test {

    @Test
    fun testDay01() {
        // Given
        val input = listOf("test")

        // When
        val result: String = Day01().exec(input)

        // Then
        assertEquals("test", result)
    }

}
