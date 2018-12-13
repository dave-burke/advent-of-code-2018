package aoc.day10

data class Star(var x: Int, var y: Int, val vx: Int, val vy: Int){

	fun step(){
		x += vx
		y += vy
	}

	fun back(){
		x -= vx
		y -= vy
	}

	companion object {

		//position=< 9,  1> velocity=< 0,  2>
		val regex = Regex("""position=< *(-?\d+), *(-?\d+)> velocity=< *(-?\d+), *(-?\d+)>""")

		fun parse(line: String): Star {
			val (x, y, vx, vy) = regex.matchEntire(line)!!.groupValues.drop(1).map { it.toInt() }
			return Star(x,y,vx,vy)
		}
	}
}
