package aoc.day03

import aoc.day03.Claim

class Sheet(val size: Int = 1_000) {

	val grid = Array(size) { _ -> IntArray(size) { _ -> 0 } }

	fun map(claim: Claim, function: (value: Int) -> Int) {
		for ( i in claim.left..claim.right - 1 ){
			for ( j in claim.top..claim.bottom - 1){
				grid[i][j] = function(grid[i][j])
			}
		}
	}

	fun find(predicate: (value: Int) -> Boolean): List<Int> {
		var result = mutableListOf<Int>()
		for ( i in 0..size - 1 ){
			for ( j in 0..size - 1 ){
				val gridVal = grid[i][j]
				if(predicate(gridVal)) result.add(gridVal)
			}
		}
		return result.toList()
	}

	fun anyIn(claim: Claim, predicate: (value: Int) -> Boolean): Boolean {
		for ( i in claim.left..claim.right - 1 ){
			for ( j in claim.top..claim.bottom - 1){
				if(predicate(grid[i][j])) return true
			}
		}
		return false
	}

	fun addClaim(claim: Claim){
		map(claim) { it + 1 }
	}

	fun addClaims(claims: Iterable<Claim>) {
		claims.forEach(this::addClaim)
	}

	fun get(col: Int, row: Int): Int {
		return grid[col][row]
	}

	fun countOverlaps(): Int {
		return find { it > 1 }.size
	}

	fun hasOverlaps(claim: Claim): Boolean {
		return anyIn(claim) { it > 1 }
	}

	override fun toString(): String {
		return grid.map { it.joinToString(separator=" ") }.joinToString(separator="\n")
	}

}
