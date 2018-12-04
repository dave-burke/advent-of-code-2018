package aoc.day03

import aoc.day03.Claim

class Sheet(val size: Int = 1_001) {

	val grid = mutableMapOf<Pair<Int, Int>, Int>()

	fun getValue(x: Int, y: Int) = grid.getOrElse(Pair(x,y)){ 0 }

	fun addClaim(claim: Claim){
		for ( x in claim.left..claim.right - 1 ){
			for ( y in claim.top..claim.bottom - 1){
				grid[Pair(x,y)] = getValue(x,y) + 1
			}
		}
	}

	fun addClaims(claims: Iterable<Claim>) {
		claims.forEach(this::addClaim)
	}

	fun countOverlaps(): Int = grid.values.filter{ it > 1 }.size

	fun hasOverlaps(claim: Claim): Boolean {
		for ( x in claim.left..claim.right - 1 ){
			for ( y in claim.top..claim.bottom - 1){
				if(getValue(x,y) > 1) return true
			}
		}
		return false
	}

	override fun toString(): String {
		return (0..size).map{ x -> 
			(0..size).map{ y -> 
				getValue(x,y)
			}.joinToString(" ")
		}.joinToString("\n")
	}

}
