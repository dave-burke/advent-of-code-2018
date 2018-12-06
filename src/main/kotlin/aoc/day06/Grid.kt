package aoc.day06

data class Grid(val pairs: List<Pair<Int, Int>>) {
	private val xVals = pairs.map { it.first }
	val maxX = xVals.max()
	val minX = xVals.min()

	private val yVals = pairs.map { it.second }
	val maxY = yVals.max()
	val minY = yVals.min()

}
