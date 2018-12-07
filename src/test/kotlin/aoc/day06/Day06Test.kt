package aoc.day06

import aoc.AocTestUtil
import aoc.inputForDay
import org.junit.Test
import org.junit.Ignore
import kotlin.test.assertEquals

class Day06Test {

	private val day = Day06
	private val util: AocTestUtil = AocTestUtil(day)

	@Test
	fun testPart1_sample0() {
		util.testPart1(listOf(
			"1, 1",
			"1, 6",
			"8, 3",
			"3, 4",
			"5, 5",
			"8, 9"
		), "17")
	}

	@Test
	fun testPart1() {
		util.testPart1(inputForDay(6), "3401")
	}

	@Test
	@Ignore
	fun testPart2_sample0(){
		util.testPart2(listOf(""), "")
	}

}
