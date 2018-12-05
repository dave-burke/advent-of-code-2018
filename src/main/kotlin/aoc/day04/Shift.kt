package aoc.day04

import java.time.*

data class Shift(val date: LocalDate, val guardId: Int, val naps: Collection<Nap>) {

	val totalNapDuration = naps.map { it.duration }.sum()

	val napMinutes = naps.flatMap { it.minuteRange }

	companion object {
		val guardRegex = Regex("""^Guard #(\d+) begins shift$""")

		private fun parseId(line: Line): Int {
			val matches = guardRegex.matchEntire(line.message) 
			if(matches == null) {
				throw IllegalArgumentException("Expected a guard ID line, but got ${line.message}")
			}
			return matches.groupValues[1].toInt()
		}

		private fun parseNaps(napLines: Collection<Line>): Collection<Nap> {
			return napLines.splitWhen { "falls asleep" in it.message }
			.filter { !it.isEmpty() }
			.map { Nap(it.first().time, it.last().time) }
		}

		fun parse(lines: Collection<Line>): Shift {
			val id = parseId(lines.first())
			val date = lines.first().time.toLocalDate()
			val naps = parseNaps(lines.drop(1))

			return Shift(date, id, naps)
		}
	}

}
