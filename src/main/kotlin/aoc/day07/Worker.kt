package aoc.day07


class Worker(val baseWork: Int = 60) {

	private val letters = "ABCDEFGHIJKLMNOPQRSTUVWXYZ"

	var node: Node? = null
		private set

	var idle = node == null
		get() = node == null

	var work = 0
		private set

	fun assign(todo: Node){
		this.node = todo
		this.node!!.status = Node.Status.IN_PROGRESS
		this.work = letters.indexOf(this.node!!.id) + 1 + baseWork
		if(this.work == -1){
			throw IllegalArgumentException("Can't work a node with ID ${this.node!!.id}. Only [A-Z] are allowed.")
		}
	}

	fun work(): String {
		if(node != null){
			this.work = this.work - 1
			if(this.work <= 0){
				this.work = 0
				this.node!!.status = Node.Status.DONE
				val id = this.node!!.id
				this.node = null
				return "$id"
			}
		}
		return ""
	}
}
