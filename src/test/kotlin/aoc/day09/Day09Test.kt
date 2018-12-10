package aoc.day09

import aoc.AocTestUtil
import aoc.inputForDay
import org.junit.Test
import org.junit.Ignore
import kotlin.test.assertEquals

class Day09Test {

	private val day = Day09
	private val util: AocTestUtil = AocTestUtil(day)

	@Test
	fun testPart1_sample0() {
		util.testPart1(listOf("9 players; last marble is worth 25 points"), "32")
	}

	@Test
	fun testPart1_sample1() {
		util.testPart1(listOf("10 players; last marble is worth 1618 points"), "8317")
	}

	@Test
	fun testPart1_sample2() {
		util.testPart1(listOf("13 players; last marble is worth 7999 points"), "146373")
	}

	@Test
	fun testPart1_sample3() {
		util.testPart1(listOf("17 players; last marble is worth 1104 points"), "2764")
	}

	@Test
	fun testPart1_sample4() {
		util.testPart1(listOf("21 players; last marble is worth 6111 points"), "54718")
	}

	@Test
	fun testPart1_sample5() {
		util.testPart1(listOf("30 players; last marble is worth 5807 points"), "37305")
	}

	@Test
	fun testPart1() {
		util.testPart1(inputForDay(9), "390592")
	}

	@Test
	@Ignore
	fun testPart2_sample0() {
		util.testPart2(listOf(""), "TODO")
	}

	@Test
	@Ignore
	fun testPart2() {
		util.testPart2(inputForDay(9), "TODO")
	}

}

