package aoc.day02

import aoc.AocTestUtil
import aoc.inputForDay
import kotlin.test.assertEquals
import org.junit.Test
import org.junit.Ignore

class Day02Test {

	private val day = Day02()
	private val util: AocTestUtil = AocTestUtil(day)

	@Test
	fun testGrouping_abcdef(){
		val result: Map<Char, Int> = day.charCounts("abcdef")
		assertEquals(result.values.contains(2), false)
		assertEquals(result.values.contains(3), false)
	}

	@Test
	fun testGrouping_bababc(){
		val result: Map<Char, Int> = day.charCounts("bababc")
		assertEquals(result.values.contains(2), true)
		assertEquals(result.values.contains(3), true)
	}

	@Test
	fun testGrouping_abbcde(){
		val result: Map<Char, Int> = day.charCounts("abbcde")
		assertEquals(result.values.contains(2), true)
		assertEquals(result.values.contains(3), false)
	}

	@Test
	fun testGrouping_abcccd(){
		val result: Map<Char, Int> = day.charCounts("abcccd")
		assertEquals(result.values.contains(2), false)
		assertEquals(result.values.contains(3), true)
	}

	@Test
	fun testGrouping_aabcdd(){
		val result: Map<Char, Int> = day.charCounts("aabcdd")
		assertEquals(result.values.contains(2), true)
		assertEquals(result.values.contains(3), false)
	}

	@Test
	fun testGrouping_abcdee(){
		val result: Map<Char, Int> = day.charCounts("abcdee")
		assertEquals(result.values.contains(2), true)
		assertEquals(result.values.contains(3), false)
	}

	@Test
	fun testGrouping_ababab(){
		val result: Map<Char, Int> = day.charCounts("ababab")
		assertEquals(result.values.contains(2), false)
		assertEquals(result.values.contains(3), true)
	}

	@Test
	fun testPart1_sample0() {
		util.testPart1(listOf(
			"abcdef",
			"bababc",
			"abbcde",
			"abcccd",
			"aabcdd",
			"abcdee",
			"ababab"
		), "12")
	}

	@Test
	fun testRemoveDiffs() {
		// Given
		val a = "fghij"
		val b = "fguij"

		// When
		val result = day.removeDiffs(a, b)

		// Then
		assertEquals("fgij", result)
	}

	@Test
	fun testPart2_sample0(){
		util.testPart2(listOf(
			"abcde",
			"fghij",
			"klmno",
			"pqrst",
			"fguij",
			"axcye",
			"wvxyz"
		), "fgij")
	}

	@Test
	fun testPart2(){
		util.testPart2(inputForDay(2), "fvstwblgqkhpuixdrnevmaycd")
	}
}

