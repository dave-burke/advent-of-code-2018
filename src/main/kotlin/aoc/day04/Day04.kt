package aoc.day04

import aoc.Day
import java.time.*
import java.time.format.*

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

	val lineRegex = Regex("""^\[(\d\d\d\d-\d\d-\d\d \d\d:\d\d)\] (.*)$""")
	val guardRegex = Regex("""^Guard #(\d+) begins shift$""")
	val dateFormat = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm")

	fun parse(line: String): Pair<LocalDateTime, String> {
		val (date, string) = lineRegex.matchEntire(line)!!.groupValues.drop(1)
		return (LocalDateTime.parse(date, dateFormat) to string)
	}

	fun toGuard(lines: Iterable<Pair<LocalDateTime, String>>): Guard {
		val id = guardRegex.matchEntire(lines.first().second)!!.groupValues[1].toInt()
		val naps = lines.drop(1)
		.splitWhen { "falls asleep" in it.second}
		.map { Pair(it.first().first, it.last().first) }
		return Guard(id, naps)
	}

	fun parseGuards(input: List<String>): Collection<Guard> {
		 return input
		.map(this::parse)
		.sortedBy { it.first }
		.splitWhen { (_, message) -> "Guard #" in message }
		.filter { it.size > 1 }
		.map(this::toGuard)
		.groupingBy { it.id }.reduce { _, prev, cur -> prev.withNaps(cur.naps) }
		.values
	}

	override fun part1(input: List<String>): String {
		val sleepiestGuard = parseGuards(input).maxBy { it.totalSleep }!!

		val id = sleepiestGuard.id
		val totalSleep = sleepiestGuard.totalSleep
		val sleepiestMinute = sleepiestGuard.sleepiestMinute
		println("The sleepiest guard was #$id at $totalSleep minutes. The sleepiest minute was $sleepiestMinute")
		return (id * sleepiestMinute).toString()
	}

	override fun part2(input: List<String>): String {
		return input[0]
	}

}
