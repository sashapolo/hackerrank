import java.util.*

// Complete the minimumBribes function below.
fun minimumBribes(q: IntArray): Int? {
    val isChaotic = q.mapIndexed { i, value -> i to value }.any { (i, value) -> (value - 1) - i > 2 }
    if (isChaotic) {
        return null
    }

    var bribes = 0
    do {
        var changed = false
        for (i in q.indices) {
            val value = q[i]
            if (value - 1 != i && value > q[i + 1]) {
                q.swap(i, i + 1)
                bribes += 1
                changed = true
            }
        }
    } while (changed)
    return bribes
}

fun IntArray.swap(i: Int, j: Int) {
    val t = this[j]
    this[j] = this[i]
    this[i] = t
}

fun main() {
    val scan = Scanner(System.`in`)

    val t = scan.nextLine().trim().toInt()

    for (tItr in 1..t) {
        val n = scan.nextLine().trim().toInt()

        val q = scan.nextLine().split(" ").map { it.trim().toInt() }.toIntArray()

        println(minimumBribes(q) ?: "Too chaotic")
    }
}