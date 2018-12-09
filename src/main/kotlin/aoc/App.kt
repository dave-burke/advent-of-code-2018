/*
 * This Kotlin source file was generated by the Gradle 'init' task.
 */
package aoc

import aoc.day01.Day01
import aoc.day02.Day02
import aoc.day03.Day03
import aoc.day04.Day04
import aoc.day05.Day05
import aoc.day06.Day06
import aoc.day07.Day07
import aoc.day08.Day08

class App {
	private val days: Map<Int, Day> = mapOf(
			1 to Day01(),
			2 to Day02(),
			3 to Day03(),
			4 to Day04,
			5 to Day05,
			6 to Day06,
			7 to Day07,
			8 to Day08
	)

	fun exec(day: Int = 1, part: Int = 1): String {
		val input = inputForDay(day)

		if (part == 1) return days[day]?.part1(input) ?: throw IllegalArgumentException("No day defined for $day")
		if (part == 2) return days[day]?.part2(input) ?: throw IllegalArgumentException("No day defined for $day")
		throw IllegalArgumentException("Only 2-part puzzles are implemented.")
	}

}
fun main(args: Array<String>) {
	val day = if (args.isEmpty()) 1 else args[0].toInt()
	val part = if (args.size <= 1) 1 else args[1].toInt()

	println(App().exec(day, part))
}
