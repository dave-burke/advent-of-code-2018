package aoc.day03

import aoc.AocTestUtil
import aoc.inputForDay
import kotlin.test.assertEquals
import org.junit.Test
import org.junit.Ignore

class Day03Test {

	private val day = Day03()
	private val util: AocTestUtil = AocTestUtil(day)

	@Test
	fun testPart1_sample0() {
		// Given
		val input = listOf(
			"#1 @ 1,3: 4x4",
			"#2 @ 3,1: 4x4",
			"#3 @ 5,5: 2x2"
		)

		// When
		val result = day.part1(input)

		// Then
		assertEquals("4", result)
	}

	@Test
	fun testPart1(){
		util.testPart1(inputForDay(3), "121259")
	}

	@Test
	fun testPart2_sample0() {
		// Given
		val input = listOf(
			"#1 @ 1,3: 4x4",
			"#2 @ 3,1: 4x4",
			"#3 @ 5,5: 2x2"
		)

		// When
		val result = day.part2(input)

		// Then
		assertEquals("3", result)
	}

	@Test
	fun testPart2(){
		util.testPart2(inputForDay(3), "239")
	}
}

