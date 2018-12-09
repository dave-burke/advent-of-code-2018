package aoc.day08

data class Node(val children: List<Node>, val metadata: List<Int>) {

	val length: Int get() = 2 + children.map { it.length }.sum() + metadata.size

	val metaSum: Int get() = metadata.sum() + children.map { it.metaSum }.sum()

	companion object {

		fun parse(input: List<String>): Node {
			val nChildren = input[0].toInt()
			val nMetadata = input[1].toInt()

			var subsequence = input.drop(2)
			val children = mutableListOf<Node>()
			for(i in 0 until nChildren){
				val child = parse(subsequence)
				subsequence = subsequence.drop(child.length)
				children.add(child)
			}

			val metadata = subsequence.take(nMetadata).map { it.toInt() }
			
			return Node(children.toList(), metadata.toList())
		}

	}
}
