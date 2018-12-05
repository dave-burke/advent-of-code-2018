package aoc.day04

import java.time.*

data class Nap(val start: LocalDateTime, val end: LocalDateTime) {

	val minuteRange = start.minute until end.minute

	val duration = minuteRange.count()

}

