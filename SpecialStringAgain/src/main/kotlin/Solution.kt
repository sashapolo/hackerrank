// Complete the substrCount function below.
fun substrCount(s: String): Int {
    fun count(curIndex: Int): Int {
        val charToCompare = s[curIndex]
        var i = curIndex + 1
        var result = 1
        while (i < s.length && s[i] == charToCompare) {
            i += 1
            result += 1
        }

        val curSubstringLength = i - curIndex
        val remainingChars = s.length - i - 1
        // stop if we are at the end of the string or at a different character but it can't be in the middle
        if (remainingChars < curSubstringLength) {
            return result
        }

        val doesRemainingFit = (1..curSubstringLength).all { s[i + it] == charToCompare }
        return if (doesRemainingFit) result + 1 else result
    }

    return s.indices.sumBy { count(it) }
}

fun main() {
    val n = readLine()!!
    val s = readLine()!!
    val result = substrCount(s)

    println(result)
}