package aoc.day09

import java.util.*

class CircleDeque<T>() : ArrayDeque<T>() {
	fun rotate(num: Int = 1) {
		if (num >= 0) {
			for(i in 0 until num){
				val t = this.removeLast()
				this.addFirst(t)
			}
		} else {
			for(i in 0 until Math.abs(num)) {
				val t = this.remove()
				this.addLast(t)
			}
		}
	}
}
