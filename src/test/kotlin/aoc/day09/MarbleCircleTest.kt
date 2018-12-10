package aoc.day09

import aoc.AocTestUtil
import aoc.inputForDay
import org.junit.Test
import org.junit.Ignore
import kotlin.test.assertEquals

class MarbleCircleTest {

	@Test
	fun initialCircal_shouldBeJustZero(){
		// Given
		val circle = MarbleCircle()

		// When
		val result = circle.toString()

		// Then
		assertEquals("(0)", result)
	}

	@Test
	fun addMarble_shouldAddMarbleOneAtEnd(){
		// Given
		val circle = MarbleCircle()
		circle.addMarble()

		// When
		val result = circle.toString()

		// Then
		assertEquals(" 0 (1)", result)
	}

	@Test
	fun addMarble_shouldAddMarbleTwoInTheMiddle(){
		// Given
		val circle = MarbleCircle()
		circle.addMarble()
		circle.addMarble()

		// When
		val result = circle.toString()

		// Then
		assertEquals(" 0 (2) 1 ", result)
	}

	@Test
	fun addMarble_shouldAddMarbleThreeToTheEnd(){
		// Given
		val circle = MarbleCircle()
		circle.addMarble()
		circle.addMarble()
		circle.addMarble()

		// When
		val result = circle.toString()

		// Then
		assertEquals(" 0  2  1 (3)", result)
	}

	@Test
	fun addMarble_shouldDetectMultiplesOf23(){
		// Given
		val circle = MarbleCircle()
		(1..22).forEach { circle.addMarble() }

		// When
		println(circle)
		val points = circle.addMarble()
		println(circle)

		// Then
		assertEquals(32, points)
		assertEquals(" 0 16  8 17  4 18 (19) 2 20 10 21  5 22 11  1 12  6 13  3 14  7 15 ", circle.toString())
	}
}
