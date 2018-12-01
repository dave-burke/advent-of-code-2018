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

    private fun testPart2(input: List<String>, expected: String) {
        // Given the input

        // When
        val result: String = Day01().part2(input)

        // Then
        assertEquals(expected, result)
    }

	@Test
	fun testPart1_sample0() {
		testPart1(listOf("+1", "-2", "+3", "+1"), "3")
	}

	@Test
	fun testPart1_sample1() {
		testPart1(listOf("+1", "+1", "+1"), "3")
	}

	@Test
	fun testPart1_sample2() {
		testPart1(listOf("+1", "+1", "-2"), "0")
	}

	@Test
	fun testPart1_sample3() {
		testPart1(listOf("-1", "-2", "-3"), "-6")
	}

	@Test
	fun testPart2_sample0() {
		testPart2(listOf("+1", "-2", "+3", "+1"), "2")
	}

	@Test
	fun testPart2_sample1() {
		testPart2(listOf("+1", "-1"), "0")
	}

	@Test
	fun testPart2_sample2() {
		testPart2(listOf("+3", "+3", "+4", "-2", "-4"), "10")
	}

	@Test
	fun testPart2_sample3() {
		testPart2(listOf("-6", "+3", "+8", "+5", "-6"), "5")
	}

	@Test
	fun testPart2_sample4() {
		testPart2(listOf("+7", "+7", "-2", "-7", "-4"), "14")
	}
}
