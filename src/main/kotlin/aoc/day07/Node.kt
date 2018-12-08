package aoc.day07

data class Node(val id: Char) {

	enum class Status {
		UNSTARTED, IN_PROGRESS, DONE
	}

	private val _children = mutableSetOf<Node>()
	val children: Set<Node> get() = _children.toSet()

	private val _parents = mutableSetOf<Node>()
	val parents: Set<Node> get() = _parents.toSet()

	var status = Status.UNSTARTED

	var isDone = false
		get() = status == Status.DONE

	val isAvailable: Boolean
		get() {
			return when {
				status == Status.IN_PROGRESS -> false
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
		val available = if (isAvailable) "AVAILABLE" else "UNAVAILABLE"
		return "$id ($available - $status))"
	}

}
