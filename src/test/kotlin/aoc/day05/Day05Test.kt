package aoc.day05

import aoc.AocTestUtil
import org.junit.Ignore
import org.junit.Test
import kotlin.test.assertEquals

class Day05Test {
	private val day = Day05
	private val util: AocTestUtil = AocTestUtil(day)

	@Test
	fun testPart1_sample0() {
		// Given
		val input = listOf(
				""
		)

		// When
		val result = day.part1(input)

		// Then
		assertEquals("", result)
	}

	@Test
	@Ignore
	fun testPart2_sample0() {
		// Given
		val input = listOf(
				""
		)

		// When
		val result = day.part2(input)

		// Then
		assertEquals("", result)
	}
}
