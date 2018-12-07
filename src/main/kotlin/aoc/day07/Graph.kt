package aoc.day07

class Graph(){

	private val nodes = mutableSetOf<Node>()

	fun addConnection(parentId: Char, childId: Char){
		val parent = nodes.find { it.id == parentId } ?: Node(parentId)
		val child = nodes.find { it.id == childId } ?: Node(childId)

		parent.addChild(child)
		child.addParent(parent)

		nodes.add(parent)
		nodes.add(child)
	}

	val availableNodes get() = nodes.filter { it.isAvailable }.sortedBy { it.id }

	val nextAvailableNode get() = availableNodes.firstOrNull()

	fun printGraph() {
		val roots = nodes.filter { it.parents.isEmpty() }
		for(root in roots){
			printNode(root)
		}
	}
	private fun printNode(node: Node, indent: Int = 1){
		for(i in 0..indent) print(' ')
		println(node)
		for(child in node.children) {
			printNode(child, indent + 1)
		}
	}

}