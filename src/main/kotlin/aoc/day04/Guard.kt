package aoc.day04

import java.time.*

operator fun LocalDateTime.minus(other: LocalDateTime) = Duration.between(other, this)

data class Guard(val id: Int, val naps: List<Pair<LocalDateTime, LocalDateTime>> = listOf()) {

	fun withNaps(newNaps: List<Pair<LocalDateTime, LocalDateTime>>): Guard {
		return this.copy(naps = naps + newNaps)
	}

	private fun sleepyMinutes(): Collection<Int> {
		return naps.flatMap { (start, end) -> start.minute until end.minute }
	}

	private fun sleepyMinuteCounts(): Map<Int, Int> {
		return sleepyMinutes().groupingBy { it }.eachCount()
	}

	val totalSleep = naps.map{ (start, end) -> (end - start).toMinutes() }.sum().toInt()
	val sleepiestMinute: Int = sleepyMinuteCounts().maxBy { (_,v) -> v }!!.key

}
