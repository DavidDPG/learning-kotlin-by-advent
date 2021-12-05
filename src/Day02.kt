data class Point(val verticalValue: Int, val horizontalValue: Int) {
	operator fun plus(other: Point) =
		Point(verticalValue + other.verticalValue, horizontalValue + other.horizontalValue)

	operator fun plus(movement: Command) = when(movement) {
		is Command.Forward -> Point(verticalValue, horizontalValue + movement.amount)
		is Command.Down -> Point(verticalValue + movement.amount, horizontalValue)
		is Command.Up -> Point(verticalValue - movement.amount, horizontalValue)
	}

	val multiple
		get() = verticalValue * horizontalValue
}

sealed class Command {

	companion object {
		fun fromString(string: String): Command {
			val values = string.split(" ")
			return when (values.first()) {
				"forward" -> Forward(values.last().toInt())
				"down" -> Down(values.last().toInt())
				else -> Up(values.last().toInt())
			}
		}
	}

	data class Forward(val amount: Int) : Command()
	data class Down(val amount: Int) : Command()
	data class Up(val amount: Int) : Command()

}

fun main() {
	fun part1(input: List<String>): Int {
		return input
			.map { Command.fromString(it) }
			.fold(Point(0, 0)) {point, command -> point + command}
			.multiple
	}

	fun part2(input: List<String>): Int {
		return TODO()
	}

	val input = readInput("Day02")

	println(part1(input))
	println(part2(input))
}