package aoc.day04

import aoc.Day
import java.time.*

fun <T> Collection<T>.splitWhen(itemMatches: (item: T) -> Boolean): Collection<Collection<T>> {
	val result = mutableListOf<List<T>>()

	var currentList = mutableListOf<T>()
	for (item in this) {
		if(itemMatches(item)){
			if(!currentList.isEmpty()){
				result.add(currentList.toList())
			}
			currentList = mutableListOf<T>()
		}
		currentList.add(item)
	}
	result.add(currentList.toList())
	return result.toList()
}

object Day04 : Day {

	private fun parseGuards(input: List<String>): Collection<Guard> {
		return input.sorted()
		.map { Line.parse(it) }
		.splitWhen { "begins shift" in it.message }
		.map { Shift.parse(it) }
		.groupBy { it.guardId }
		.map { (id, shifts) -> Guard(id, shifts) }
	}

	override fun part1(input: List<String>): String {
		val guards = parseGuards(input)

		val sleepiestGuard = guards.maxBy { it.totalNapDuration }
		val sleepiestMinute = sleepiestGuard?.sleepiestMinute

		println("Guard #${sleepiestGuard?.id} was asleep most often at minute ${sleepiestMinute}")

		return (sleepiestGuard!!.id * sleepiestMinute!!).toString()
	}

	override fun part2(input: List<String>): String {
		return input[0]
	}

}
