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

		eachCoordinate(action = {coordinate ->
			val nearest = points.sortedBy { it distanceTo coordinate}
			if((coordinate distanceTo nearest[0]) != (coordinate distanceTo nearest[1])) {
				regionsByPointTmp.getOrDefault(nearest[0], mutableListOf()).add(coordinate)
				pointsByCoordinateTmp[coordinate] = nearest[0]
			}
		})

		regionsByPoint = regionsByPointTmp.map { (k, v) -> k to v.toList() }.toMap()
		pointsByCoordinate = pointsByCoordinateTmp.toMap()
	}

	private val letters = mapOf(
			0 to "a",
			1 to "b",
			2 to "c",
			3 to "d",
			4 to "e",
			5 to "f"
	)

	private fun eachCoordinate(action: (Point) -> Unit, rowAction: (i: Int) -> Unit = { }) {
		for(y in 0..maxY) {
			for(x in 0..maxX) {
				action(Point(x, y))
			}
			rowAction(y)
		}
	}

	fun printHeatMap(coordinate: Point){
		eachCoordinate(
				action={ other ->
					val distance = other distanceTo coordinate
					if(other in points){
						val index = points.indexOf(other)
						print(letters[index]?.padStart(2, ' ') + " ")
					} else {
						print(distance.toString().padStart(2, '0') + " ")
					}
				},
				rowAction={ println() }
		)
		points.forEachIndexed { index, point -> println("Point ${letters[index]?.toUpperCase()} is ${point distanceTo coordinate} away from $coordinate") }
	}

	fun printPoints(){
		eachCoordinate(
				action={ coordinate ->
					if(coordinate in points){
						val index = points.indexOf(coordinate)
						print(letters[index])
					} else {
						print(".")
					}
				},
				rowAction = { println() }
		)
	}

	fun printRegions(){
		eachCoordinate(
				action={ coordinate ->
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
				},
				rowAction = { println() }
		)
	}

}
