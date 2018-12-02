package aoc.day02

import aoc.Day
import aoc.day02.cartesianProduct

class Day02 : Day {

	fun charCounts(s: String): Map<Char, Int> {
		return s.groupingBy{ it }.eachCount().toMap()
	}

	fun hasPair(counts: Map<Char, Int>): Boolean {
		return counts.values.contains(2)
	}

	fun hasTriple(counts: Map<Char, Int>): Boolean {
		return counts.values.contains(3)
	}

	fun countPairs(input: List<String>): Int {
		return input.map { charCounts(it) }.count { hasPair(it) }
	}

	fun countTriples(input: List<String>): Int {
		return input.map { charCounts(it) }.count { hasTriple(it) }
	}

	override fun part1(input: List<String>): String {
		var nPairs = countPairs(input)
		var nTriples = countTriples(input)

		println("Found $nPairs pairs and $nTriples triples")
		return (nPairs * nTriples).toString()
	}

	fun removeDiffs(a: String, b: String): String {
		var result = ""
		for ((i, aChar) in a.withIndex()) {
			val bChar = b[i]
			if(aChar == bChar) result += aChar
		}
		return result
	}

	override fun part2(input: List<String>): String {
		val pairs = input.cartesianProduct(input)
		for((a,b) in pairs){
			val matching = removeDiffs(a,b)
			if(a.length - matching.length == 1) return matching
		}
		throw IllegalStateException("No match found!")
	}

}
