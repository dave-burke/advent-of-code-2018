package aoc.day06

import org.junit.Test
import kotlin.test.assertEquals

class PointTest {

	@Test
	fun testDistanceTo(){
		// Given
		val a = Point(0,0)
		val b = Point(1, 1)

		// When
		val result = a distanceTo b

		// Then
		assertEquals(2, result)
	}

}
