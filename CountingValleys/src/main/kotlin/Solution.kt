import java.util.*

// Complete the countingValleys function below.
fun countingValleys(n: Int, s: String): Int {
    var currentLevel = 0
    var numValleys = 0
    for (direction in s) {
        when (direction) {
            'U' -> {
                currentLevel++
                if (currentLevel == 0) {
                    numValleys++
                }
            }
            'D' -> currentLevel--
        }
    }
    return numValleys
}

fun main() {
    val scan = Scanner(System.`in`)

    val n = scan.nextLine().trim().toInt()

    val s = scan.nextLine()

    val result = countingValleys(n, s)

    println(result)
}
