package aoc.day04

import aoc.AocTestUtil
import aoc.inputForDay
import kotlin.test.assertEquals
import org.junit.Test
import org.junit.Ignore

class Day04Test {

	private val day = Day04
	private val util: AocTestUtil = AocTestUtil(day)

	@Test
	fun testPart1_sample0() {
		// Given
		val input = listOf(
			"[1518-11-01 00:00] Guard #10 begins shift",
			"[1518-11-01 00:05] falls asleep",
			"[1518-11-01 00:25] wakes up",
			"[1518-11-01 00:30] falls asleep",
			"[1518-11-01 00:55] wakes up",
			"[1518-11-01 23:58] Guard #99 begins shift",
			"[1518-11-02 00:40] falls asleep",
			"[1518-11-02 00:50] wakes up",
			"[1518-11-03 00:05] Guard #10 begins shift",
			"[1518-11-03 00:24] falls asleep",
			"[1518-11-03 00:29] wakes up",
			"[1518-11-04 00:02] Guard #99 begins shift",
			"[1518-11-04 00:36] falls asleep",
			"[1518-11-04 00:46] wakes up",
			"[1518-11-05 00:03] Guard #99 begins shift",
			"[1518-11-05 00:45] falls asleep",
			"[1518-11-05 00:55] wakes up"
		)

		// When
		val result = day.part1(input)

		// Then
		assertEquals("25", result)
	}

	@Test
	@Ignore
	fun testPart2_sample0() {
		// Given
		val input = listOf("")

		// When
		val result = day.part2(input)

		// Then
		assertEquals("", result)
	}

}

