package aoc.day01

import aoc.AocTestUtil
import kotlin.test.Test

class Day01Test {

	private val util: AocTestUtil = AocTestUtil(Day01())

	@Test
	fun testPart1_sample0() {
		util.testPart1(listOf("+1", "-2", "+3", "+1"), "3")
	}

	@Test
	fun testPart1_sample1() {
		util.testPart1(listOf("+1", "+1", "+1"), "3")
	}

	@Test
	fun testPart1_sample2() {
		util.testPart1(listOf("+1", "+1", "-2"), "0")
	}

	@Test
	fun testPart1_sample3() {
		util.testPart1(listOf("-1", "-2", "-3"), "-6")
	}

	@Test
	fun testPart2_sample0() {
		util.testPart2(listOf("+1", "-2", "+3", "+1"), "2")
	}

	@Test
	fun testPart2_sample1() {
		util.testPart2(listOf("+1", "-1"), "0")
	}

	@Test
	fun testPart2_sample2() {
		util.testPart2(listOf("+3", "+3", "+4", "-2", "-4"), "10")
	}

	@Test
	fun testPart2_sample3() {
		util.testPart2(listOf("-6", "+3", "+8", "+5", "-6"), "5")
	}

	@Test
	fun testPart2_sample4() {
		util.testPart2(listOf("+7", "+7", "-2", "-7", "-4"), "14")
	}
}
