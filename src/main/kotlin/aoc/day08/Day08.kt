package aoc.day08

import aoc.Day

object Day08: Day {

	override fun part1(input: List<String>): String {
		val numbers = input[0].split(' ')

		val root = Node.parse(numbers)

		return root.metaSum.toString()
	}

	override fun part2(input: List<String>): String {
		val numbers = input[0].split(' ')

		val root = Node.parse(numbers)

		return root.value.toString()
	}

}
