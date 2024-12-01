import kotlin.io.path.Path
import kotlin.io.path.readText

/**
 * day system, set day at beginning & just use [testInput] and [input] getters
 */
var day = 0

val paddedDay get() = day.toString().padStart(2, '0')
fun getDayFile(fileName: String) = Path("src/$paddedDay/$fileName").readText().trim().lines()
val testInput by lazy { getDayFile("test.txt") }
val input by lazy { getDayFile("input.txt") }


fun Any?.println() = println(this)
fun Any?.println(label: String) {
    kotlin.io.println("$label: $this")
}
