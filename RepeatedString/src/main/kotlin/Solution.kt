import java.util.*

// Complete the repeatedString function below.
fun repeatedString(s: String, n: Long): Long {
    if (n < s.length) {
        return countSymbols(s, n.toInt())
    }

    val symbolsInString = countSymbols(s)

    val remainder = (n % s.length).toInt()
    val symbolsInRemainder = countSymbols(s, remainder)

    return symbolsInString * (n / s.length) + symbolsInRemainder
}

private fun countSymbols(s: String, limit: Int = s.length): Long =
    s.asSequence()
        .take(limit)
        .count { it == 'a' }
        .toLong()


fun main(args: Array<String>) {
    val scan = Scanner(System.`in`)

    val s = scan.nextLine()

    val n = scan.nextLine().trim().toLong()

    val result = repeatedString(s, n)

    println(result)
}
