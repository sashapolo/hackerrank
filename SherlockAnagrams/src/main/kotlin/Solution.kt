import java.util.*

// Complete the sherlockAndAnagrams function below.
fun sherlockAndAnagrams(s: String): Int {
    val substringsWithSameChars = s.generateSubstrings()
            .map { it.toCharArray().sorted() }
            .groupingBy { it }
            .eachCount()
            .values
    return substringsWithSameChars.asSequence()
            .map { it * (it - 1) / 2 }
            .sum()
}

private fun String.generateSubstrings(): Sequence<String> = sequence {
    for (i in 0 until length) {
        for (j in i until length) {
            yield(substring(i..j))
        }
    }
}

fun main() {
    val scan = Scanner(System.`in`)
    val q = scan.nextLine().trim().toInt()
    for (qItr in 1..q) {
        val s = scan.nextLine()
        val result = sherlockAndAnagrams(s)
        println(result)
    }
}