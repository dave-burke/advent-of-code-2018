package aoc

import kotlin.test.assertEquals

class AocTestUtil(private val day: Day) {

	fun testPart1(input: List<String>, expected: String) {
		// Given the input

		// When
		val result: String = day.part1(input)

		// Then
		assertEquals(expected, result)
	}

	fun testPart2(input: List<String>, expected: String) {
		// Given the input

		// When
		val result: String = day.part2(input)

		// Then
		assertEquals(expected, result)
	}

}