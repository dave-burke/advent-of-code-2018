package aoc.day07

import aoc.AocTestUtil
import aoc.inputForDay
import org.junit.Test
import org.junit.Ignore
import kotlin.test.assertEquals

class Day07Test {

	private val day = Day07
	private val util: AocTestUtil = AocTestUtil(day)

	@Test
	fun testPart1_sample0() {
		util.testPart1(listOf(
				"Step C must be finished before step A can begin.",
				"Step C must be finished before step F can begin.",
				"Step A must be finished before step B can begin.",
				"Step A must be finished before step D can begin.",
				"Step B must be finished before step E can begin.",
				"Step D must be finished before step E can begin.",
				"Step F must be finished before step E can begin."
		), "CABDFE")
	}

	@Test
	fun testPart1() {
		util.testPart1(inputForDay(7), "EUGJKYFQSCLTWXNIZMAPVORDBH")
	}

	@Test
	fun testPart2_sample0() {
		// Given
		val input = listOf(
				"Step C must be finished before step A can begin.",
				"Step C must be finished before step F can begin.",
				"Step A must be finished before step B can begin.",
				"Step A must be finished before step D can begin.",
				"Step B must be finished before step E can begin.",
				"Step D must be finished before step E can begin.",
				"Step F must be finished before step E can begin."
		)

		// When
		val result = day.doPart2(input, 2, 0, 16).first

		// Then
		assertEquals("CABFDE", result)
	}

	@Test
	fun testPart2() {
		util.testPart2(inputForDay(7), "1014")
	}

}
