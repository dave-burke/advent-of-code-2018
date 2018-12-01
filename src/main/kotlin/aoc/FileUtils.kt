package aoc

fun inputForDay(day: Int): List<String> {
	val paddedDay: String = day.toString().padStart(2, '0')
	return resourceLines("day$paddedDay.txt")
}

fun resourceLines(fileName: String): List<String> {
	return ClassLoader.getSystemResourceAsStream(fileName)
			.bufferedReader()
			.readLines();
}
