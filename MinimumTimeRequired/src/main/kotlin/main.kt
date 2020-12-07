import kotlin.math.min

fun minTime(periods: List<Long>, goal: Long): Long {
    var minDays = 1L
    var maxDays = goal * periods.maxOrNull()!!
    var bestResult = maxDays

    while (maxDays >= minDays) {
        val numDays = (minDays + maxDays) / 2
        val production = periods.asSequence().map { numDays / it }.sum()
        if (production >= goal) {
            bestResult = min(bestResult, numDays)
            maxDays = numDays - 1
        } else {
            minDays = numDays + 1
        }
    }

    return bestResult
}

fun main() {
    val goal = readLine()!!.split(" ")[1].trim().toLong()
    val periods = readLine()!!.split(" ").map { it.trim().toLong() }

    val ans = minTime(periods, goal)

    println(ans)
}
