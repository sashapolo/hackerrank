import java.util.*
import kotlin.math.max

fun maximumSum(a: List<Long>, m: Long): Long {
    var prevSum = 0L
    var result = 0L
    val sortedSums = TreeSet<Long>()
    a.forEach {
        val currentSum = (prevSum + it) % m
        val previousLargerSum = sortedSums.higher(currentSum) ?: 0
        val maxSum = (currentSum - previousLargerSum + m) % m
        result = max(result, maxSum)

        sortedSums.add(currentSum)
        prevSum = currentSum
    }
    return result
}

fun main() {
    val q = readLine()!!.trim().toInt()

    repeat(q) {
        val m = readLine()!!.split(" ")[1].trim().toLong()
        val a = readLine()!!.split(" ").map { it.trim().toLong() }

        val result = maximumSum(a, m)

        println(result)
    }
}