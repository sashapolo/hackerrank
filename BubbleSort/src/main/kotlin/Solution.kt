import java.util.*

// Complete the countSwaps function below.
fun countSwaps(a: Array<Int>) {
    fun swap(i: Int, j: Int) {
        val t = a[i]
        a[i] = a[j]
        a[j] = t
    }

    var numSwaps = 0
    for (i in a.indices.reversed()) {
        for (j in 0 until i) {
            if (a[j] > a[j + 1]) {
                swap(j, j + 1)
                numSwaps += 1
            }
        }
    }

    println("Array is sorted in $numSwaps swaps.")
    println("First Element: ${a.first()}")
    println("Last Element: ${a.last()}")
}

fun main() {
    val scan = Scanner(System.`in`)
    val n = scan.nextLine().trim().toInt()
    val a = scan.nextLine().split(" ").map{ it.trim().toInt() }.toTypedArray()
    countSwaps(a)
}