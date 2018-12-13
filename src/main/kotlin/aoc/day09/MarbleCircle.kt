package aoc.day09

import kotlin.math.absoluteValue

class MarbleCircle(){

	val _marbles = CircleDeque<Int>()

	init {
		_marbles.add(0)
	}

	val marbles get() = _marbles.toList()

	private var prevMarble = 0

	var nextMarble = 1
		private set

	private fun moveClockwise(n: Int = 1){
		_marbles.rotate(n)
	}

	private fun moveCounterClockwise(n: Int = 1){
		_marbles.rotate(n * -1)
	}

	fun addMarble(): Int {
		val points: Int
		if(nextMarble % 23 == 0){
			moveCounterClockwise(7)
			val removed = _marbles.removeLast()
			prevMarble = _marbles.last()
			points = removed + nextMarble
		} else {
			moveClockwise(2)
			_marbles.addLast(nextMarble)
			prevMarble = nextMarble
			points = 0
		}
		nextMarble++
		return points
	}

	fun normalized(): List<Int> {
		val copy = CircleDeque<Int>()
		copy.addAll(marbles.reversed())
		while(copy.first != 0) {
			copy.rotate(1)
		}
		return copy.toList()
	}

	override fun toString(): String {
		val index = prevMarble
		return normalized().map { marble ->
			if(marble == index){
				return@map "($marble)"
			} else {
				return@map marble.toString().padStart(2, ' ').padEnd(3, ' ')
			}
		}.joinToString("")
	}

}
