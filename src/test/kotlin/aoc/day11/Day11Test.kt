package aoc.day11

import aoc.AocTestUtil
import aoc.inputForDay
import org.junit.Test
import org.junit.Ignore
import kotlin.test.assertEquals

class Day11Test {

	private val day = Day11
	private val util: AocTestUtil = AocTestUtil(day)

	@Test
	fun testPart1_sample0() {
		util.testPart1(listOf("18"), "33,45")
	}

	@Test
	fun testPart1_sample1() {
		util.testPart1(listOf("42"), "21,61")
	}

	@Test
	fun testPart1() {
		util.testPart1(inputForDay(11), "21,41")
	}

	@Test
	@Ignore("Takes too long")
	fun testPart2_sample0() {
		util.testPart2(listOf("18"), "90,269,16")
	}

	@Test
	@Ignore("Takes too long")
	fun testPart2_sample1() {
		util.testPart2(listOf("42"), "232,251,12")
	}

	@Test
	@Ignore
	fun testPart2() {
		util.testPart2(inputForDay(11), "TODO")
	}

}

