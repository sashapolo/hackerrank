import java.util.*

// Complete the hourglassSum function below.
fun hourglassSum(arr: Array<Array<Int>>): Int =
        (0..3).asSequence()
                .flatMap { i -> (0..3).asSequence().map { j -> computeHourglass(arr, i, j) } }
                .maxOrNull()
                ?: 0

private fun computeHourglass(arr: Array<Array<Int>>, i: Int, j: Int): Int =
        arr[i][j] + arr[i][j + 1] + arr[i][j + 2] +
                arr[i + 1][j + 1] +
                arr[i + 2][j] + arr[i + 2][j + 1] + arr[i + 2][j + 2]

fun main() {
    val scan = Scanner(System.`in`)

    val arr = Array(6) { Array(6) { 0 } }

    for (i in 0 until 6) {
        arr[i] = scan.nextLine().split(" ").map { it.trim().toInt() }.toTypedArray()
    }

    val result = hourglassSum(arr)

    println(result)
}
