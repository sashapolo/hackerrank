// Complete the countInversions function below.
fun countInversions(arr: IntArray): Long {
    return sortAndCountInversions(arr.copyOf(), arr.copyOf(), 0, arr.lastIndex)
}

private fun sortAndCountInversions(to: IntArray, from: IntArray, startIndex: Int, stopIndex: Int): Long {
    if (stopIndex - startIndex == 0) {
        return 0
    }

    val splitIndex = startIndex + (stopIndex - startIndex) / 2
    val leftInversions = sortAndCountInversions(from, to, startIndex, splitIndex)
    val rightInversions = sortAndCountInversions(from, to, splitIndex + 1, stopIndex)

    var i = startIndex
    var j = splitIndex + 1
    var k = startIndex
    var inversions = 0L
    while (i <= splitIndex && j <= stopIndex) {
        if (from[i] <= from[j]) {
            to[k++] = from[i++]
        } else {
            inversions += (splitIndex - i + 1)
            to[k++] = from[j++]
        }
    }

    val remainingRange = if (i > splitIndex) {
        j..stopIndex
    } else {
        i..splitIndex
    }
    remainingRange.forEach { to[k++] = from[it] }

    return leftInversions + rightInversions + inversions
}

fun main() {
    val t = readLine()!!.trim().toInt()

    for (tItr in 1..t) {
        val n = readLine()!!.trim().toInt()
        val arr = readLine()!!.split(" ").map { it.trim().toInt() }.toIntArray()
        val result = countInversions(arr)
        println(result)
    }
}