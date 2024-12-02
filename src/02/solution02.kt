import kotlin.math.abs

fun main() {
    day = 2

    fun reportIsSafe(report: List<Int>): Boolean {
        var changeDirection = 0 // 0 if not yet determined
        for (index in 0..<report.size-1) {
            val current = report[index]
            val next = report[index+1]
            if (current == next) return false

            val thisChangeDirection = if (next > current) 1 else -1
            if (changeDirection == 0) changeDirection = thisChangeDirection // if not determined, set initial direction
            else if (changeDirection != thisChangeDirection) return false // if already determined, unsafe if it changes

            if (abs(current - next) > 3) return false
        }
        return true
    }

    fun parseReports(input: List<String>): List<List<Int>> {
        return input.map { line ->
            line.split(" ").map { it.toInt() }
        }
    }

    fun part1(input: List<String>): Int {
        val reports = parseReports(input)
        val amount = reports.count { reportIsSafe(it) }
        return amount
    }

    fun part2(input: List<String>): Int {
        val fullReports = parseReports(input)
        val amount = fullReports.count { fullReport ->
            if (reportIsSafe(fullReport)) return@count true
            for (index in fullReport.indices) {
                val subReport = fullReport.filterIndexed { filteringIndex, _ -> filteringIndex != index }
                if (reportIsSafe(subReport)) return@count true
            }
            return@count false
        }
        return amount
    }

    part1(testInput).println("p1 test")
    part1(input).println("p1 real")
    part2(testInput).println("p2 test")
    part2(input).println("p2 real")
}