package aoc.day01

import aoc.Day

class Day01 : Day {

    override fun part1(input: List<String>): String {
	    var result: Int = 0
	    for (freq in input) {
		    val sign = freq.get(0)
		    val magnitude = freq.drop(1).toInt()
		    if(sign == '+') {
			    result += magnitude
			} else if (sign == '-') {
				result -= magnitude
			} else {
				throw IllegalStateException("Unknown operation $sign")
			}
		}
        return result.toString()
    }

    override fun part2(input: List<String>): String {
        return input.joinToString(separator = "\n")
    }
}
