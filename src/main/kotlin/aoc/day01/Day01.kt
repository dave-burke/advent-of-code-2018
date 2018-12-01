package aoc.day01

import aoc.Day

class Day01 : Day {

	private fun update(cur: Int, change: String): Int {
		val sign = change.get(0)
		val magnitude = change.drop(1).toInt()
		when(sign) {
			'+' -> return cur + magnitude
			'-' -> return cur - magnitude
			else -> throw IllegalStateException("Unknown operation $sign")
		}
	}

	override fun part1(input: List<String>): String {
		var result: Int = 0
		for (line in input) {
			result = update(result, line)
		}
		return result.toString()
	}

	override fun part2(input: List<String>): String {
		var cur = 0
		val seen: MutableSet<Int> = HashSet()
		seen.add(cur)
		while(true) {
			for (line in input) {
				cur = update(cur, line)
				if (!seen.add(cur)) return cur.toString()
			}
		}
	}
}
