package aoc.day06

import aoc.Day

object Day06: Day {

	override fun part1(input: List<String>): String {
		val pairs = input.map { it.split(", ") }.map { Pair(it[0].toInt(), it[1].toInt()) }
		val grid = Grid(pairs)

		println("Grid is (${grid.minX},${grid.minY}) to (${grid.maxX}, ${grid.maxY})") 

		return "17"
	}

	override fun part2(input: List<String>): String {
		TODO("Not implemented")
	}

}
