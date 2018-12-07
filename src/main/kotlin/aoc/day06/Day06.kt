package aoc.day06

import aoc.Day

object Day06: Day {

	override fun part1(input: List<String>): String {
		val points = input.map { it.split(", ") }.map { Point(it[0].toInt(), it[1].toInt()) }
		val grid = Grid(points)

		val (point, size) = grid.largestRegionPoint()!!
		println("The point with the largest region is $point with a size of $size")

		return size.toString()
	}

	override fun part2(input: List<String>): String {
		TODO("Not implemented")
	}

}
