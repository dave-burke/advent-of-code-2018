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

		var result = ""
		var next = graph.nextAvailableNode
		while(next != null){
			result += next.id
			next.status = Node.Status.DONE
			next = graph.nextAvailableNode
		}
		return result
	}

	fun printWorkers(second: Int, workers: Iterable<Worker>){
		print(second)
		for(worker in workers){
			val status: String
			if(worker.node == null){
				status = " . "
			} else {
				status = "${worker.node?.id}(${worker.work})"
			}
			print("\t${status}")
		}
		println()
	}

	fun doPart2(input: List<String>, nWorkers: Int = 5, baseWork: Int = 60, timeout: Int = Int.MAX_VALUE): Pair<String, Int> {
		val graph = loadInstructions(input)

		val workers = mutableListOf<Worker>()
		for(i in 0 until nWorkers){
			workers.add(Worker(baseWork))
		}

		var result = ""
		var second = 0
		loop@while(!graph.allDone){
			if(second > timeout){
				break@loop
			}
			//Assign nodes
			val idleWorkers = workers.filter { it.idle }
			var workQueue = graph.availableNodes.take(idleWorkers.size)
			for((i, node) in workQueue.withIndex()) {
				idleWorkers[i].assign(node)
			}

			printWorkers(second, workers)

			// Do work
			workers.forEach { worker ->
				result += worker.work()
			}
			second++
		}
		println("Final order is $result")
		return Pair(result, second)
	}

	override fun part2(input: List<String>): String {
		return doPart2(input).second.toString()
	}

}
