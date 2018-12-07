package aoc.day07

data class Node(val id: Char) {

	private val _children = mutableSetOf<Node>()
	val children: Set<Node> get() = _children.toSet()

	private val _parents = mutableSetOf<Node>()
	val parents: Set<Node> get() = _parents.toSet()

	private var isDone = false
	fun markDone(){
		isDone = true
	}

	val isAvailable: Boolean
		get() {
			return when {
				isDone -> false
				parents.isEmpty() -> true
				else -> parents.all { it.isDone }
			}
		}

	fun addParent(parent: Node){
		_parents.add(parent)
	}

	fun addChild(child: Node) {
		_children.add(child)
	}

	override fun toString(): String {
		return when {
			isDone -> "$id (DONE)"
			isAvailable -> "$id (AVAILABLE)"
			else -> "$id (BLOCKED)"
		}
	}

}