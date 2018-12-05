package aoc.day04

import java.time.*
import java.time.format.*

data class Line(val time: LocalDateTime, val message: String) {
	companion object {
		val lineRegex = Regex("""^\[(\d\d\d\d-\d\d-\d\d \d\d:\d\d)\] (.*)$""")
		val dateFormat = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm")

		fun parse(line: String): Line {
			val (date, string) = lineRegex.matchEntire(line)!!.groupValues.drop(1)
			return Line(LocalDateTime.parse(date, dateFormat), string)
		}
	}
}
