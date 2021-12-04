fun main() {
    fun part1(input: List<Int>): Int {
        return input
            .windowed(size = 2, transform = { (a, b) -> a - b })
            .count { it < 0 }
    }

    fun part2(input: List<Int>): Int {
        return input.size
    }

    val input = readInputAsInt("Day01")
    println(part1(input))
    println(part2(input))
}
