package aoc.day06

import kotlin.math.absoluteValue

data class Point(val x: Int, val y: Int) {
	infix fun distanceTo(other: Point): Int {
		return (this.x - other.x).absoluteValue + (this.y - other.y).absoluteValue
	}
}