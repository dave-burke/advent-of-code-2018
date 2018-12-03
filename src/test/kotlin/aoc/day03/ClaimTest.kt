package aoc.day03

import kotlin.test.assertEquals
import org.junit.Test

class ClaimTest {

	@Test
	fun testToClaim(){
		// Given
		val input = "#123 @ 3,2: 5x4"

		// When
		val result = input.toClaim()

		// Then
		assertEquals(123, result.id)
		assertEquals(3, result.left)
		assertEquals(2, result.top)
		assertEquals(5, result.width)
		assertEquals(4, result.height)
	}
}
