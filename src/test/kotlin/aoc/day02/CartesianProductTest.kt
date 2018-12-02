package aoc.day02

import aoc.day02.cartesianProduct
import kotlin.test.assertTrue
import org.junit.Test
import org.junit.Ignore

class CartesianProductTest {

	@Test
	fun testCartesianProduct() {
		//Given
		val a = listOf("a", "b")
		val b = listOf("1", "2")

		//When
		val result = a.cartesianProduct(b)

		//Then
		assertTrue(result.containsAll(listOf(
				"a" to "1",
				"a" to "2",
				"b" to "1",
				"b" to "2"
		)))
	}
}
