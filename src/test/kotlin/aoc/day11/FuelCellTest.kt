package aoc.day11

import aoc.AocTestUtil
import aoc.inputForDay
import org.junit.Test
import org.junit.Ignore
import kotlin.test.assertEquals

class FuelCellTest {

	@Test
	fun powerLevel_sample0() {
		// Given
		val cell = FuelCell(3, 5, 8)

		// When
		val result = cell.powerLevel

		// Then
		assertEquals(4, result)
	}
	
	@Test
	fun powerLevel_sample1() {
		// Given
		val cell = FuelCell(122, 79, 57)

		// When
		val result = cell.powerLevel

		// Then
		assertEquals(-5, result)
	}

	@Test
	fun powerLevel_sample2() {
		// Given
		val cell = FuelCell(217, 196, 39)

		// When
		val result = cell.powerLevel

		// Then
		assertEquals(0, result)
	}

	@Test
	fun powerLevel_sample3() {
		// Given
		val cell = FuelCell(101, 153, 71)

		// When
		val result = cell.powerLevel

		// Then
		assertEquals(4, result)
	}
}
