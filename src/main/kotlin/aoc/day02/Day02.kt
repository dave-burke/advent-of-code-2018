package aoc.day02

import aoc.Day
import aoc.day02.cartesianProduct

class Day02 : Day {

	fun charCounts(s: String): Map<Char, Int> {
		return s.groupingBy{ it }.eachCount().toMap()
	}

	fun countPairs(input: List<String>): Int {
		return input.map { charCounts(it) }.count { 2 in it.values }
	}

	fun countTriples(input: List<String>): Int {
		return input.map { charCounts(it) }.count { 3 in it.values }
	}

	override fun part1(input: List<String>): String {
		var nPairs = countPairs(input)
		var nTriples = countTriples(input)

		println("Found $nPairs pairs and $nTriples triples")
		return (nPairs * nTriples).toString()
	}

	fun removeDiffs(a: String, b: String): String {
		return a.zip(b) { aChar, bChar -> aChar.takeIf { it == bChar }}
				.filterNotNull()
				.joinToString("")
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
