import java.util.*
import kotlin.math.max

// Complete the arrayManipulation function below.
fun arrayManipulation(n: Int, queries: List<IntArray>): Long {
    val array = LongArray(n)
    for ((a, b, k) in queries) {
        array[a - 1] += k.toLong()
        if (b < n) {
            array[b] -= k.toLong()
        }
    }

    var max = 0L
    var current = 0L
    for (x in array) {
        current += x
        max = max(current, max)
    }
    return max
}


fun main() {
    val scan = Scanner(System.`in`)
    val nm = scan.nextLine().split(" ")
    val n = nm[0].trim().toInt()
    val m = nm[1].trim().toInt()

    val queries = (0 until m).map { scan.nextLine().split(" ").map{ it.trim().toInt() }.toIntArray() }
    val result = arrayManipulation(n, queries)

    println(result)
}