package aoc.day03

import aoc.day03.Claim

class Sheet(val size: Int = 1_000) {

	val grid = Array(size) { _ -> IntArray(size) { _ -> 0 } }

	fun addClaim(claim: Claim){
		for ( i in claim.left..claim.right - 1 ){
			for ( j in claim.top..claim.bottom - 1){
				grid[i][j]++
			}
		}
	}

	fun addClaims(claims: Iterable<Claim>) {
		claims.forEach(this::addClaim)
	}

	fun get(col: Int, row: Int): Int {
		return grid[col][row]
	}

	fun countOverlaps(): Int {
		var result = 0
		for ( i in 0..size - 1 ){
			for ( j in 0..size - 1 ){
				if (grid[i][j] > 1) result++
			}
		}
		return result
	}

	fun print() {
		if(size > 100) throw IllegalStateException("You probably didn't mean to print a grid of size $size")
		grid.forEach{ row -> println(row.joinToString(separator=" "))}
	}

}
