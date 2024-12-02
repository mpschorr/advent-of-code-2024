import kotlin.math.abs

fun main() {
    day = 2

    fun part1(input: List<String>): Int {
        val reports = input.map { line ->
            line.split(" ").map { it.toInt() }
        }

        val amount = reports.count { report ->
            var changeDirection = 0 // 0 if not yet determined
            for (index in 0..<report.size-1) {
                val current = report[index]
                val next = report[index+1]
                if (current == next) return@count false

                val thisChangeDirection = if (next > current) 1 else -1
                if (changeDirection == 0) changeDirection = thisChangeDirection // if not determined, set initial direction
                else if (changeDirection != thisChangeDirection) return@count false // if already determined, unsafe if it changes

                if (abs(current - next) > 3) return@count false
            }
            return@count true
        }
        return amount
    }

    part1(testInput).println("p1 test")
    part1(input).println("p1 real")
}