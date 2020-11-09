import java.util.*

// Complete the maximumToys function below.
fun maximumToys(prices: List<Int>, k: Int): Int {
    var moneyLeft = k
    return prices.sorted().asSequence()
            .takeWhile {
                moneyLeft -= it
                moneyLeft > 0
            }
            .count()
}

fun main() {
    val scan = Scanner(System.`in`)

    val nk = scan.nextLine().split(" ")
    val n = nk[0].trim().toInt()
    val k = nk[1].trim().toInt()
    val prices = scan.nextLine().split(" ").map{ it.trim().toInt() }.toList()

    val result = maximumToys(prices, k)

    println(result)
}
