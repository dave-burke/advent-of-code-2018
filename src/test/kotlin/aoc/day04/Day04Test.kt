package aoc.day04

import aoc.AocTestUtil
import aoc.inputForDay
import kotlin.test.assertEquals
import org.junit.Test
import org.junit.Ignore

class Day04Test {

	private val day = Day04
	private val util: AocTestUtil = AocTestUtil(day)

	@Test
	fun testPart1_sample0() {
		// Given
		val input = listOf("")

		// When
		val result = day.part1(input)

		// Then
		assertEquals("", result)
	}

	@Test
	@Ignore
	fun testPart2_sample0() {
		// Given
		val input = listOf("")

		// When
		val result = day.part2(input)

		// Then
		assertEquals("", result)
	}

}

