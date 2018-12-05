package aoc.day05

import aoc.Day

object Day05: Day {

	fun doFold(acc: String, c: Char): String {
			if(acc.isEmpty()){
				return "${c}"
			}
			val lastChar = acc.last()
			if(lastChar.equals(c, ignoreCase = true)){
				if(lastChar.isUpperCase() != c.isUpperCase()){
					return acc.dropLast(1)
				}
			}
			return acc + c
	}

	fun process(polymer: String): String {
		return polymer.fold("") { acc, c -> doFold(acc, c) }
	}

	override fun part1(input: List<String>): String {
		return process(input[0]).length.toString()
	}

	override fun part2(input: List<String>): String {
		val baseInput = input[0]

		val results = mutableMapOf<Char, Int>()
		for( c in 'a'..'z' ){
			val candidate = process(baseInput.replace(Regex("[$c${c.toUpperCase()}]"), ""))
			results.put(c, candidate.length)
		}
		return results.values.min().toString()
	}

}
