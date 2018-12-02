package aoc.day02

import aoc.Day

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

	override fun part2(input: List<String>): String {
		TODO("not implemented")
	}

}
