package aoc.day06


data class Grid(val points: List<Point>) {
	init {
		if(points.size < 3) throw IllegalArgumentException("Grid must have at least three points in it")
	}
	val maxX = points.maxBy { it.x }!!.x
	val maxY = points.maxBy { it.y }!!.y
	val minX = points.minBy { it.x }!!.x
	val minY = points.minBy { it.y }!!.y

	val regionsByPoint: Map<Point, Collection<Point>>
	val pointsByCoordinate: Map<Point, Point>

	init {
		val regionsByPointTmp = mutableMapOf<Point, MutableList<Point>>()
		val pointsByCoordinateTmp = mutableMapOf<Point, Point>()

		eachCoordinate{ coordinate ->
			val nearestPoint = nearestPoint(coordinate)
			if(nearestPoint != null) {
				val region = regionsByPointTmp.getOrDefault(nearestPoint, mutableListOf())
				region.add(coordinate)
				regionsByPointTmp[nearestPoint] = region
				pointsByCoordinateTmp[coordinate] = nearestPoint
			}
		}

		regionsByPoint = regionsByPointTmp.map { (k, v) -> k to v.toList() }.toMap()
		pointsByCoordinate = pointsByCoordinateTmp.toMap()
	}

	private fun nearestPoint(coordinate: Point): Point? {
		val nearestPoints = points.sortedBy { it distanceTo coordinate}
		val tied = (coordinate distanceTo nearestPoints[0]) == (coordinate distanceTo nearestPoints[1])
		return if(tied) null else nearestPoints[0]
	}

	fun largestRegionPoint(): Pair<Point, Int>? {
		val pairs = points.map { 
			val size = sizeOfRegionFor(it)
			if (size == null) null else Pair(it, size)
		}.filterNotNull()

		return pairs.maxBy { it.second }
	}

	fun sizeOfRegionFor(point: Point): Int? {
		return if (hasInfiniteRegion(point)) null else regionsByPoint[point]?.size
	}

	fun hasInfiniteRegion(point: Point): Boolean {
		val region = regionsByPoint[point] ?: throw IllegalArgumentException("$point is not on this grid")
		return isInfinite(region)
	}

	private fun isInfinite(region: Collection<Point>): Boolean {
		return region.any { onEdge(it) }
	}

	private fun onEdge(coordinate: Point): Boolean {
		return coordinate.x == minX || coordinate.x == maxX || coordinate.y == minY || coordinate.y == maxY
	}

	private fun distanceSum(coordinate: Point): Int {
		return points.map { it distanceTo coordinate }.sum()
	}

	fun safeRegion(criteria: Int): Collection<Point>{
		val result = mutableListOf<Point>()
		eachCoordinate { coordinate ->
			if(distanceSum(coordinate) < criteria) {
				result.add(coordinate)
			}
		}
		return result.toList()
	}

	fun printDistanceSums() {
		printEachCoordinate{ 
			val sum = distanceSum(it)
			if(sum < 32) {
				print(sum.toString().padStart(3, '0') + " ")
			} else {
				print(" . ")
			}
		}
	}

	private fun eachCoordinate(action: (Point) -> Unit) {
		for(y in 0..maxY) {
			for(x in 0..maxX) {
				action(Point(x, y))
			}
		}
	}

	private fun printEachCoordinate(action: (Point) -> Unit) {
		for(y in 0..maxY) {
			for(x in 0..maxX) {
				action(Point(x, y))
			}
			println()
		}
	}

	private val letters = mapOf(
			0 to "a",
			1 to "b",
			2 to "c",
			3 to "d",
			4 to "e",
			5 to "f"
	)

	fun printHeatMap(coordinate: Point){
		printEachCoordinate{ other ->
			val distance = other distanceTo coordinate
			if(other in points){
				val index = points.indexOf(other)
				print(letters[index]?.padStart(2, ' ') + " ")
			} else {
				print(distance.toString().padStart(2, '0') + " ")
			}
		}
		points.forEachIndexed { index, point -> println("Point ${letters[index]?.toUpperCase()} is ${point distanceTo coordinate} away from $coordinate") }
	}

	fun printPoints(){
		printEachCoordinate{ coordinate ->
			if(coordinate in points){
				val index = points.indexOf(coordinate)
				print(letters[index])
			} else {
				print(".")
			}
		}
	}

	fun printRegions(){
		printEachCoordinate{ coordinate ->
			val point = pointsByCoordinate[coordinate]
			if(point == null){
				print(".")
			} else {
				val index = points.indexOf(point)
				val letter = letters[index]
				if(coordinate == point){
					print(letter?.toUpperCase())
				} else {
					print(letter)
				}
			}
		}
	}

}
