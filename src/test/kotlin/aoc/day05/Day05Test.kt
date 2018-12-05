package aoc.day05

import aoc.AocTestUtil
import aoc.inputForDay
import org.junit.Ignore
import org.junit.Test
import kotlin.test.assertEquals

class Day05Test {
	private val day = Day05
	private val util: AocTestUtil = AocTestUtil(day)


	private fun testProcess(input: String, expected: String){
		val result = day.process(input)
		assertEquals(expected, result)
	}

	@Test
	fun testPart1_sample0() {
		testProcess("aA", "")
	}

	@Test
	fun testPart1_sample1() {
		testProcess("abBA", "")
	}

	@Test
	fun testPart1_sample2() {
		testProcess("abAB", "abAB")
	}

	@Test
	fun testPart1_sample3() {
		testProcess("aabAAB", "aabAAB")
	}

	@Test
	fun testPart1_sample4() {
		testProcess("dabAcCaCBAcCcaDA", "dabCBAcaDA")
	}

	@Test
	fun testPart1(){
		util.testPart1(inputForDay(5), "10972")
	}

	@Test
	fun testPart2_sample0() {
		// Given
		val input = listOf(
				"dabAcCaCBAcCcaDA"
		)

		// When
		val result = day.part2(input)

		// Then
		assertEquals("4", result)
	}

	@Test
	fun testPart2(){
		util.testPart2(inputForDay(5), "5278")
	}

}
