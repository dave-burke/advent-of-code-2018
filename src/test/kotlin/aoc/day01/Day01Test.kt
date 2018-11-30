package aoc.day01

import kotlin.test.Test
import kotlin.test.assertEquals

class Day01Test {

    @Test
    fun testPart1() {
        // Given
        val input = listOf("test")

        // When
        val result: String = Day01().part1(input)

        // Then
        assertEquals("test", result)
    }

    @Test
    fun testPart2() {
        // Given
        val input = listOf("test")

        // When
        val result: String = Day01().part2(input)

        // Then
        assertEquals("test", result)
    }

}
