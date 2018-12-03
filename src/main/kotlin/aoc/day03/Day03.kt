package aoc.day03

import aoc.Day
import aoc.day03.Claim
import aoc.day03.Sheet

class Day03 : Day {

	override fun part1(input: List<String>): String {
		val sheet = Sheet(1001)
		sheet.addClaims(input.map { it.toClaim() })

		return sheet.countOverlaps().toString()
	}

	override fun part2(input: List<String>): String {
		val sheet = Sheet(1001)
		val claims = input.map { it.toClaim() }
		sheet.addClaims(claims)

		val results = claims.filter { !sheet.hasOverlaps(it) }
		return results[0].id.toString()
	}

}
