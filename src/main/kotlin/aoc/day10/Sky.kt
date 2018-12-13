package aoc.day10

class Sky(val stars: Collection<Star>) {

	init {
		if(stars.isEmpty()) throw IllegalArgumentException("Must have at least one star")
	}

	fun step() {
		stars.forEach { it.step() }
	}

	fun back() {
		stars.forEach { it.back() }
	}

	fun minX() = stars.map { it.x }.min()!!
	fun maxX() = stars.map { it.x }.max()!!
	fun minY() = stars.map { it.y }.min()!!
	fun maxY() = stars.map { it.y }.max()!!
	fun width() = maxX() - minX()
	fun height() = maxY() - minY()
	fun area() = width().toLong() * height().toLong()

	override fun toString(): String {
		val sb = StringBuilder()
		for(y in minY()..maxY()) {
			for(x in minX()..maxX()) {
				if(stars.any { it.x == x && it.y == y }){
					sb.append('#')
				} else {
					sb.append('.')
				}
			}
			sb.append('\n')
		}
		return sb.toString()
	}
}
