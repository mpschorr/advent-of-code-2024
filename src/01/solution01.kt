import kotlin.math.abs

fun main() {
    day = 1

    fun getLists(input: List<String>): Pair<List<Int>,List<Int>> {
        val pairs = input.map {
            it.split("   ").map { num -> num.toInt() }
        }
        val a = pairs.map { it[0] }.sorted()
        val b = pairs.map { it[1] }.sorted()
        return a to b
    }

    fun part1(input: List<String>): Int {
        val (a, b) = getLists(input)
        val zipSum = (a zip b).sumOf { abs(it.second - it.first) }
        return zipSum
    }

    fun part2(input: List<String>): Int {
        val (a, b) = getLists(input)
        val total = a.sumOf { num ->
            val countInOther = b.count { it == num }
            num * countInOther
        }
        return total
    }

    part1(testInput).println("p1 test")
    part1(input).println("p1 real")

    part2(testInput).println("p2 test")
    part2(input).println("p2 real")
}