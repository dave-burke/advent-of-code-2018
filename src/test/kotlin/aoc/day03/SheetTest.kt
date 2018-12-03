package aoc.day03

import kotlin.test.assertEquals
import org.junit.Test

class SheetTest {

	@Test
	fun testConstructor() {
		// Given
		val size = 10

		// When
		val result = Sheet(size)

		// Then
		assertEquals(0, result.get(9,9))
	}

	@Test
	fun testAddClaim() {
		// Given
		val size = 10
		val sheet = Sheet(size)
		val claim = Claim()

		// When
		sheet.addClaim(claim)

		// Then
		assertEquals(1, sheet.get(0,0))
	}

	@Test
	fun testCountOverlaps() {
		// Given
		val size = 5
		val sheet = Sheet(size)
		sheet.addClaim(Claim(width=2, height=2))
		sheet.addClaim(Claim(top=1, left=1, width=2, height=2))

		// When
		val result = sheet.countOverlaps()

		// Then
		sheet.print()
		assertEquals(1, result)

	}


}
