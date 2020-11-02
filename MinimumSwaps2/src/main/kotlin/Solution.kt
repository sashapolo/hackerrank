import java.util.*

// Complete the minimumSwaps function below.
fun minimumSwaps(arr: IntArray): Int {
    var swaps = 0
    do {
        var changed = false
        for (i in arr.indices) {
            val expectedIndex = arr[i] - 1
            if (i != expectedIndex) {
                arr.swap(i, expectedIndex)
                changed = true
                swaps += 1
            }
        }
    } while (changed)
    return swaps
}

fun IntArray.swap(i: Int, j: Int) {
    val t = this[j]
    this[j] = this[i]
    this[i] = t
}

fun main(args: Array<String>) {
    val scan = Scanner(System.`in`)

    val n = scan.nextLine().trim().toInt()

    val arr = scan.nextLine().split(" ").map{ it.trim().toInt() }.toIntArray()

    val res = minimumSwaps(arr)

    println(res)
}
