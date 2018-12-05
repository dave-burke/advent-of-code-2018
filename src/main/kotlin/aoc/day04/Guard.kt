package aoc.day04

import java.time.*

data class Guard(val id: Int, val shifts: List<Shift>) {

	val totalNapDuration = shifts.map { it.totalNapDuration }.sum()

	val sleepiestMinute = sleepFrequencyByMinute.maxBy { (_,v) -> v }?.key

	val sleepFrequencyByMinute: Map<Int, Int>
		get() {
			val result = mutableMapOf<Int, Int>()
			for(i in 0..59) {
				for(shift in shifts) {
					if(i in shift.napMinutes){
						val cur = result.getOrDefault(i, 0)
						result.put(i, cur + 1)
					}
				}
			}
			return result.toMap()
		}
}
