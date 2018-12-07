package aoc.day07

import aoc.Day

object Day07: Day {

	// e.g. Step E must be finished before step H can begin.
	val regex = Regex("""Step ([A-Z]) must be finished before step ([A-Z]) can begin.""")

	fun loadInstructions(input: List<String>): Graph {
		val graph = Graph()

		for(line in input){
			val matcher = regex.matchEntire(line) ?: throw IllegalStateException("Could not parse $line")
			val (id, childId) = matcher.groupValues.drop(1).map { it.first() }
			graph.addConnection(id, childId)
		}

		return graph
	}

	override fun part1(input: List<String>): String {
		val graph = loadInstructions(input)

		graph.printGraph()

		var result = ""
		var next = graph.nextAvailableNode
		while(next != null){
			result += next.id
			next.markDone()
			next = graph.nextAvailableNode
		}
		return result
	}

	override fun part2(input: List<String>): String {
		TODO("Not unlocked")
	}

}
