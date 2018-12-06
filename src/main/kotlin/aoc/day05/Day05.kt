package aoc.day05

import aoc.Day

object Day05: Day {

	fun process(polymer: String): String {
		return polymer.fold("") { acc, c ->
			if(acc.isEmpty()){
				return@fold "$c"
			}
			val lastChar = acc.last()
			if(lastChar.equals(c, ignoreCase = true)){
				if(lastChar.isUpperCase() != c.isUpperCase()){
					return@fold acc.dropLast(1)
				}
			}
			return@fold acc + c
		}
	}

	override fun part1(input: List<String>): String {
		return process(input[0]).length.toString()
	}

	override fun part2(input: List<String>): String {
		// It takes 3x as long if we don't pre-process here
		val baseInput = process(input[0])

		val results = mutableMapOf<Char, Int>()
		for( c in baseInput.toLowerCase().asIterable().distinct() ){
			val candidate = process(baseInput.replace(Regex("[$c${c.toUpperCase()}]"), ""))
			println("$c -> ${candidate.length}")
			results[c] = candidate.length
		}
		return results.values.min().toString()
	}

}
