package aoc.day06

import aoc.Day

object Day06: Day {

	override fun part1(input: List<String>): String {
		val points = input.map { it.split(", ") }.map { Point(it[0].toInt(), it[1].toInt()) }
		val grid = Grid(points)

		println("Grid is sized from (${grid.minX},${grid.minY}) to (${grid.maxX}, ${grid.maxY})")
		println("It has points ${grid.points}")
		println("Points: ")
		grid.printPoints()
		println("Regions: ")
		grid.printRegions()

		return "17"
	}

	override fun part2(input: List<String>): String {
		TODO("Not implemented")
	}

}
