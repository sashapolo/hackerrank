import java.lang.Long.max

fun candies(arr: List<Int>): Long {
    val cache = LongArray(arr.size + 1)

    fun candiesImpl(startIndex: Int) {
        for (i in startIndex..arr.lastIndex) {
            when {
                arr.localMinimum(i) -> cache[i] = 1
                arr.increasing(i) -> cache[i] = if (i == 0) 1 else cache[i - 1] + 1
                arr.decreasing(i) -> {
                    candiesImpl(i + 1)
                    cache[i] = cache[i + 1] + 1
                    return
                }
                arr.localMaximum(i) -> {
                    candiesImpl(i + 1)
                    cache[i] = max(cache[i - 1], cache[i + 1]) + 1
                    return
                }
            }
        }
    }

    candiesImpl(0)
    return cache.sum()
}

fun List<Int>.leftNeighbour(i: Int): Int? = if (i == 0) null else this[i - 1]
fun List<Int>.rightNeighbour(i: Int): Int? = if (i == lastIndex) null else this[i + 1]

fun List<Int>.localMinimum(i: Int): Boolean =
    this[i] <= leftNeighbour(i) ?: Int.MAX_VALUE
            && this[i] <= rightNeighbour(i) ?: Int.MAX_VALUE

fun List<Int>.increasing(i: Int): Boolean =
    this[i] > leftNeighbour(i) ?: 0
            && this[i] <= rightNeighbour(i) ?: Int.MAX_VALUE

fun List<Int>.decreasing(i: Int): Boolean =
    this[i] <= leftNeighbour(i) ?: Int.MAX_VALUE
            && this[i] > rightNeighbour(i) ?: 0

fun List<Int>.localMaximum(i: Int): Boolean =
    this[i] > leftNeighbour(i) ?: 0 && this[i] > rightNeighbour(i) ?: 0

fun main() {
    val n = readLine()!!.trim().toInt()
    val arr = (0 until n).map { readLine()!!.trim().toInt() }

    val result = candies(arr)

    println(result)
}