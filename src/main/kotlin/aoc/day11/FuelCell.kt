package aoc.day11

/*
 *  Find the fuel cell's rack ID, which is its X coordinate plus 10.
 *  Begin with a power level of the rack ID times the Y coordinate.
 *  Increase the power level by the value of the grid serial number (your puzzle input).
 *  Set the power level to itself multiplied by the rack ID.
 *  Keep only the hundreds digit of the power level (so 12345 becomes 3; numbers with no hundreds digit become 0).
 *  Subtract 5 from the power level.
 */
data class FuelCell(val x: Int, val y: Int, val serialNo: Int){

	val rackId get() = x + 10

	public val powerLevel: Int 
	init {
		var result = rackId * y
		result += serialNo
		result *= rackId
		result = if(result < 100) 0 else result.toString().reversed().drop(2).take(1).toInt()
		result -= 5
		powerLevel = result
	}
}
