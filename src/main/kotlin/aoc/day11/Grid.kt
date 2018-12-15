package aoc.day11

class Grid(val serialNo: Int, val width: Int = 300, val height: Int = 300){

	val cells: List<List<FuelCell>>
	init {
		val tmp = mutableListOf<MutableList<FuelCell>>()
		for(x in 0 until width) {
			tmp.add(mutableListOf<FuelCell>())
			for(y in 0 until height){
				tmp[x].add(FuelCell(x,y, serialNo))
			}
		}
		cells = tmp.map { it.toList() }.toList()
	}

	fun calcSquarePower(x: Int, y: Int, squareSize: Int = 3): Int {
		if(x > (width - squareSize) || y > (height - squareSize)){
			return 0
		}
		var sum = 0
		for(i in x until x+squareSize){
			for(j in y until y+squareSize){
				sum += cells[i][j].powerLevel
			}
		}
		return sum
	}

	fun calcMaxSquarePower(squareSize: Int = 3): FuelCell {
		return cells.flatMap { it }.maxBy { calcSquarePower(it.x, it.y, squareSize) }!!
	}

	fun calcMaxSquarePowerAnySize(): Pair<FuelCell, Int> {
		var maxCell: FuelCell? = null
		var maxSquarePower = 0
		var maxSquareSize = 0

		for(i in 0..300){
			if(i % 10 == 0) println(i) else print(i)
			val cell = calcMaxSquarePower(i)
			val squarePower = calcSquarePower(cell.x, cell.y, i)
			if(squarePower > maxSquarePower){
				maxSquarePower = squarePower
				maxCell = cell
				maxSquareSize = i
			}
		}
		return Pair(maxCell!!, maxSquareSize)
	}

	fun print(){
		print(this)
	}

	fun printSquarePowers() {
		for(x in 0 until width){
			for(y in 0 until height){
				print(calcSquarePower(x,y).toString().padStart(2, ' ').padEnd(3, ' '))
			}
			println()
		}
	}

	override fun toString(): String {
		val sb = StringBuilder();
		for(x in 0 until width){
			for(y in 0 until height){
				sb.append(cells[x][y].powerLevel.toString().padStart(2, ' ').padEnd(3, ' '))
			}
			sb.append('\n')
		}
		return sb.toString()
	}

}
