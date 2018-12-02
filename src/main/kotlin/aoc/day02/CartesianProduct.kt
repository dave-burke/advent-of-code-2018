package aoc.day02

// Extensions
fun <T, S> Collection<T>.cartesianProduct(other: Iterable<S>): List<Pair<T, S>> {
	val result: MutableList<Pair<T,S>> = mutableListOf()
	for(a in this){
		for(b in other){
			result.add(a to b)
		}
	}
	return result
}

