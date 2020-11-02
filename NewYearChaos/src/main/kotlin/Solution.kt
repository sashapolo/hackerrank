import java.util.*

// Complete the minimumBribes function below.
fun minimumBribes(q: IntArray): Int? {
    var bribes = 0
    while (true) {
        var maxIndexNotInPlace = maxIndexNotInPlace(q) ?: return bribes
        val maxValue = q[maxIndexNotInPlace]
        val indexDiff = (maxValue - 1) - maxIndexNotInPlace
        if (indexDiff > 2) {
            return null
        }
        repeat(indexDiff) {
            q.swap(maxIndexNotInPlace, maxIndexNotInPlace + 1)
            maxIndexNotInPlace += 1
        }
        bribes += indexDiff
    }
}

fun IntArray.swap(i: Int, j: Int) {
    val t = this[j]
    this[j] = this[i]
    this[i] = t
}

fun maxIndexNotInPlace(q: IntArray): Int? = q.asSequence()
        .mapIndexed { i, value -> i to value }
        .filter { (i, value) -> i + 1 != value }
        .maxBy { it.second }
        ?.first


fun main() {
    val scan = Scanner(System.`in`)

    val t = scan.nextLine().trim().toInt()

    for (tItr in 1..t) {
        val n = scan.nextLine().trim().toInt()

        val q = scan.nextLine().split(" ").map { it.trim().toInt() }.toIntArray()

        println(minimumBribes(q) ?: "Too chaotic")
    }
}