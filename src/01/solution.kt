import kotlin.math.abs

fun main() {
    day = 1

    fun part1(input: List<String>): Int {
        val pairs = input.map {
            it.split("   ").map { num -> num.toInt() }
        }
        val a = pairs.map { it[0] }.sorted()
        val b = pairs.map { it[1] }.sorted()
        val zipSum = (a zip b).sumOf { abs(it.second - it.first) }
        return zipSum
    }

    part1(testInput).println("p1 test")
    part1(input).println("p1 real")
}