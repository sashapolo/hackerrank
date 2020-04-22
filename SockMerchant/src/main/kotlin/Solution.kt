import java.util.*

// Complete the sockMerchant function below.
fun sockMerchant(n: Int, ar: Array<Int>): Int {
    val scannedSocks = BooleanArray(100)
    var matchedPairs = 0
    for (color in ar) {
        val index = color - 1
        if (scannedSocks[index]) {
            matchedPairs++
            scannedSocks[index] = false
        } else {
            scannedSocks[index] = true
        }
    }
    return matchedPairs
}

fun main(args: Array<String>) {
    val scan = Scanner(System.`in`)

    val n = scan.nextLine().trim().toInt()

    val ar = scan.nextLine().split(" ").map{ it.trim().toInt() }.toTypedArray()

    val result = sockMerchant(n, ar)

    println(result)
}
