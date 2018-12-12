package aoc.day09

import aoc.Day
import kotlin.math.roundToInt

object Day09: Day {

	fun playGame(nPlayers: Int, lastMarble: Int): Player {
		val players = CircleDeque<Player>()
		players.addAll((1..nPlayers).map { Player(it) }.toList())

		val circle = MarbleCircle()

		val checkpoint: Int
		if(lastMarble > 100) {
			checkpoint = (lastMarble.toDouble() / 100).roundToInt()
		} else {
			checkpoint = 1
		}
		for(i in 1..lastMarble){
			if ( i % checkpoint == 0){
				val percentComplete = ((i.toDouble() / lastMarble) * 100)
				println("$i / $lastMarble = $percentComplete% done")
			}
			players.first.points += circle.addMarble()
			players.rotate()
		}

		return players.toList().maxBy { it.points }!!
	}

	// e.g. 10 players; last marble is worth 1618 points
	val regex = Regex("""(\d+) players; last marble is worth (\d+) points""")
	override fun part1(input: List<String>): String {
		val (nPlayers, lastMarble) = regex.matchEntire(input[0])!!.groupValues.drop(1).map { it.toInt() }
		val winner = playGame(nPlayers, lastMarble)
		println("${winner.id} wins with ${winner.points} points")
		return winner.points.toString()
	}

	override fun part2(input: List<String>): String {
		val (nPlayers, lastMarble) = regex.matchEntire(input[0])!!.groupValues.drop(1).map { it.toInt() }
		val winner = playGame(nPlayers, lastMarble * 100)
		println("${winner.id} wins with ${winner.points} points")
		return winner.points.toString()
	}

}

