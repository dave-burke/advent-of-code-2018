package aoc.day10

import aoc.AocTestUtil
import aoc.inputForDay
import org.junit.Test
import org.junit.Ignore
import kotlin.test.assertEquals

class Day10Test {

	private val day = Day10
	private val util: AocTestUtil = AocTestUtil(day)

	@Test
	fun testPart1_sample0() {
		util.testPart1(listOf(""), "")
	}

	@Test
	@Ignore
	fun testPart1() {
		util.testPart1(inputForDay(10), "TODO")
	}

	@Test
	@Ignore
	fun testPart2_sample0() {
		util.testPart2(listOf(""), "TODO")
	}

	@Test
	@Ignore
	fun testPart2() {
		util.testPart2(inputForDay(10), "TODO")
	}

}

