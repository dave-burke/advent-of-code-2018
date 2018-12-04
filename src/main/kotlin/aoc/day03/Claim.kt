package aoc.day03

fun String.toClaim(): Claim {
	// e.g. "#123 @ 3,2: 5x4"
	val regex = Regex("""#(\d+) @ (\d+),(\d+): (\d+)x(\d+)""")

	val (id, left, top, width, height) = regex.matchEntire(this)!!.groupValues.drop(1).map { it.toInt() }
	
	return Claim(id, left, top, width, height)

}
data class Claim(val id: Int = -1, val left: Int = 0, val top: Int = 0, val width: Int = 1, val height: Int = 1){

	val right = left + width
	val bottom = top + height

}
