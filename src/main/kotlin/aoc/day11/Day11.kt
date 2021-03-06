package aoc.day11

import aoc.Day

object Day11: Day {

	override fun part1(input: List<String>): String {
		val serialNo = input[0].toInt()
		val grid = Grid(serialNo)
		val maxSquareCell = grid.calcMaxSquarePower()
		println("$maxSquareCell = ${maxSquareCell.powerLevel}")
		return "${maxSquareCell.x},${maxSquareCell.y}"
	}

	override fun part2(input: List<String>): String {
		val serialNo = input[0].toInt()
		val grid = Grid(serialNo)
		val (cell, size) = grid.calcMaxSquarePowerAnySize()
		println("Max cell is $cell in square of size $size")
		return "${cell.x},${cell.y},$size"
	}

}

