package aoc.day01

import aoc.Day

class Day01 : Day {

	override fun part1(input: List<String>): String {
		return input.map(String::toInt).sum().toString()
	}

	override fun part2(input: List<String>): String {
		var cur = 0
		val seen = mutableSetOf(cur)

		val frequencies = input.map(String::toInt)
		while(true) {
			for (frequency in frequencies) {
				cur += frequency
				if (!seen.add(cur)) return cur.toString()
			}
		}
	}
}
