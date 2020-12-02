const val ALPHABET_SIZE: Int = 'z' - 'a' + 1

fun reverseShuffleMerge(s: String): String {
    val stats = s.charStats()
    stats.indices.forEach { stats[it] /= 2 }

    return s.reversed().smallestSubsequence(stats)
}

private fun String.charStats(startIndex: Int = 0): IntArray {
    val stats = IntArray(ALPHABET_SIZE)
    (startIndex..lastIndex).forEach { stats[this[it] - 'a'] += 1 }
    return stats
}

private fun String.smallestSubsequence(requiredSymbols: IntArray): String {
    val requiredLength = requiredSymbols.sum()
    val result = StringBuilder(requiredLength)

    var prevPosition = 0
    var curCharOffset = 0 // 'a'
    while (result.length < requiredLength) {
        // find smallest required character
        curCharOffset = (curCharOffset..requiredSymbols.lastIndex).find { requiredSymbols[it] > 0 }!!
        val curChar = (curCharOffset + 'a'.toInt()).toChar()
        val curPosition = indexOf(curChar, startIndex = prevPosition)

        // if remaining symbols are enough to satisfy the symbol requirements - add it to result and continue
        // looking for the smallest possible chars. Otherwise - backtrack and try the next symbol
        if (hasEnough(requiredSymbols, startIndex = curPosition)) {
            result.append(curChar)
            requiredSymbols[curCharOffset] -= 1
            prevPosition = curPosition + 1
            curCharOffset = 0
        } else {
            curCharOffset += 1
        }
    }

    return result.toString()
}

private fun String.hasEnough(requiredSymbols: IntArray, startIndex: Int): Boolean {
    val stats = charStats(startIndex)
    return requiredSymbols.indices.all { requiredSymbols[it] <= stats[it] }
}

fun main() {
    val s = readLine()!!
    val result = reverseShuffleMerge(s)
    println(result)
}
