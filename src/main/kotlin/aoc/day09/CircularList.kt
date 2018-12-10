package aoc.day09

class CircularList<T> (
		private val list: List<T>,
		var index: Int = 0){

	private val _list = list.toMutableList()

	var indexValue = _list[index]

	fun moveIndex(n: Int){
		index = ((index+n) + _list.size) % _list.size
	}

	fun insert(value: T, i: Int = this.index) {
		_list.add(i, value)
	}

	fun remove(i: Int = this.index): T {
		val v = _list[i]
		_list.removeAt(i)
		return v
	}

	fun toList(): List<T> {
		return _list.toList()
	}

}
