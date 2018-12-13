package aoc.day10

import aoc.Day

object Day10: Day {

	override fun part1(input: List<String>): String {
		val sky = Sky(input.map { Star.parse(it) })
		var area = sky.area()
		for (i in 0..100000){
			sky.step()
			val newArea = sky.area()
			if(newArea > area){
				sky.back()
				break
			}
			area = newArea
		}
		return sky.toString()
	}

	override fun part2(input: List<String>): String {
	    TODO("Not unlocked")
	}

}

