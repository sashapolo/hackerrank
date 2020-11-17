// Complete the isValid function below.
fun isValid(s: String): Boolean {
    val frequencies = s.charFrequencies().asSequence()
            .filter { it != 0 }
            .groupingBy { it }
            .eachCount()
    return when (frequencies.size) {
        1 -> true
        2 ->
            if (frequencies[1] == 1) {
                // we can remove the single outlier
                true
            } else {
                val (lessFrequent, moreFrequent) = frequencies.toList().sortedBy { it.second }
                lessFrequent.first - moreFrequent.first == 1 && lessFrequent.second == 1
            }
        else -> false
    }
}

private fun String.charFrequencies(): IntArray {
    val frequencies = IntArray('z' - 'a' + 1)
    forEach { frequencies[it - 'a'] += 1 }
    return frequencies
}

fun main() {
    val s = readLine()!!
    val result = isValid(s)
    println(if (result) "YES" else "NO")
}