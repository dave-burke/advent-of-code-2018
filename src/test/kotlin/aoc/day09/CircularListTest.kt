package aoc.day09

import org.junit.Test
import kotlin.test.assertEquals

class CircularListTest {

	@Test
	fun moveIndex_shouldMoveWithinLimit(){
		// Given
		val circle = CircularList(listOf(0, 1, 2, 3, 4), 0)

		// When
		circle.moveIndex(2)

		// Then
		assertEquals(2, circle.index)
	}

	@Test
	fun moveIndex_shouldWrapAround(){
		// Given
		val circle = CircularList(listOf(0, 1, 2, 3, 4), 2)

		// When
		circle.moveIndex(3)

		// Then
		assertEquals(0, circle.index)
	}

	@Test
	fun moveIndex_shouldWrapAroundExactly(){
		// Given
		val circle = CircularList(listOf(0, 1, 2, 3, 4), 2)

		// When
		circle.moveIndex(circle.toList().size)

		// Then
		assertEquals(2, circle.index)
	}

	@Test
	fun moveIndex_shouldMoveWithinLimitBackwards(){
		// Given
		val circle = CircularList(listOf(0, 1, 2, 3, 4), 4)

		// When
		circle.moveIndex(-3)

		// Then
		assertEquals(1, circle.index)
	}

	@Test
	fun moveIndex_shouldWrapAroundBackwards(){
		// Given
		val circle = CircularList(listOf(0, 1, 2, 3, 4), 1)

		// When
		circle.moveIndex(-3)

		// Then
		assertEquals(3, circle.index)
	}

	@Test
	fun moveIndex_shouldWrapAroundExactlyBackwards(){
		// Given
		val circle = CircularList(listOf(0, 1, 2, 3, 4), 1)

		// When
		circle.moveIndex(-circle.toList().size)

		// Then
		assertEquals(1, circle.index)
	}

	@Test
	fun insert_shouldInsertAtIndex(){
		// Given
		val circle = CircularList(listOf(0, 1, 2), 1)

		// When
		circle.insert(3)

		// Then
		assertEquals(listOf(0, 3, 1, 2), circle.toList())
	}

	@Test
	fun insert_shouldInsertAt0(){
		// Given
		val circle = CircularList(listOf(0, 1, 2), 1)

		// When
		circle.insert(3, 0)

		// Then
		assertEquals(listOf(3, 0, 1, 2), circle.toList())
	}

	@Test
	fun insert_shouldInsertAtEnd(){
		// Given
		val circle = CircularList(listOf(0, 1, 2), 1)

		// When
		circle.insert(3, 3)

		// Then
		assertEquals(listOf(0, 1, 2, 3), circle.toList())
	}
}