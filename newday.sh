#!/usr/bin/env bash

set -e

DAY="$1"
ZERO_DAY=`printf %02d ${DAY}`
SRC_DIR="src/main/kotlin/aoc/day${ZERO_DAY}"
mkdir "${SRC_DIR}"

echo "package aoc.day${ZERO_DAY}

import aoc.Day

object Day${ZERO_DAY}: Day {

	override fun part1(input: List<String>): String {
	    TODO(\"Not started\")
	}

	override fun part2(input: List<String>): String {
	    TODO(\"Not unlocked\")
	}

}
" > "${SRC_DIR}/Day${ZERO_DAY}.kt"

TST_DIR="src/test/kotlin/aoc/day${ZERO_DAY}"
mkdir "${TST_DIR}"

echo "package aoc.day${ZERO_DAY}

import aoc.AocTestUtil
import aoc.inputForDay
import org.junit.Test
import org.junit.Ignore
import kotlin.test.assertEquals

class Day${ZERO_DAY}Test {

	private val day = Day${ZERO_DAY}
	private val util: AocTestUtil = AocTestUtil(day)

	@Test
	fun testPart1_sample0() {
		util.testPart1(listOf(\"\"), \"\")
	}

	@Test
	@Ignore
	fun testPart1() {
		util.testPart1(inputForDay(${DAY}), \"TODO\")
	}

	@Test
	@Ignore
	fun testPart2_sample0() {
		util.testPart2(listOf(\"\"), \"TODO\")
	}

	@Test
	@Ignore
	fun testPart2() {
		util.testPart2(inputForDay(${DAY}), \"TODO\")
	}

}
" > "${TST_DIR}/Day${ZERO_DAY}Test.kt"

vim src/main/kotlin/aoc/App.kt
