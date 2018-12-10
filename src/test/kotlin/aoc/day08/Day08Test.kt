package aoc.day08

import aoc.AocTestUtil
import aoc.inputForDay
import org.junit.Test
import org.junit.Ignore
import kotlin.test.assertEquals

class Day08Test {

	private val day = Day08
	private val util: AocTestUtil = AocTestUtil(day)

	@Test
	fun testPart1_sample0() {
		util.testPart1(listOf("2 3 0 3 10 11 12 1 1 0 1 99 2 1 1 2"), "138")
	}

	@Test
	fun testPart1() {
		util.testPart1(inputForDay(8), "47112")
	}

	@Test
	fun testPart2_sample0() {
		util.testPart2(listOf("2 3 0 3 10 11 12 1 1 0 1 99 2 1 1 2"), "66")
	}

	@Test
	fun testPart2() {
		util.testPart2(inputForDay(8), "28237")
	}

}
