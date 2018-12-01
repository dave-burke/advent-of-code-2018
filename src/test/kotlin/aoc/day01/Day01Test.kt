package aoc.day01

import kotlin.test.Test
import kotlin.test.assertEquals

class Day01Test {

	private fun testPart1(input: List<String>, expected: String) {
		// Given the input

		// When
        val result: String = Day01().part1(input)

        // Then
        assertEquals(expected, result)
	}

    @Test
    fun testPart1_sampl1() {
	    testPart1(listOf("+1", "+1", "+1"), "3")
    }

    @Test
    fun testPart1_sampl2() {
	    testPart1(listOf("+1", "+1", "-2"), "0")
    }

    @Test
    fun testPart1_sampl3() {
	    testPart1(listOf("-1", "-2", "-3"), "-6")
    }

}
