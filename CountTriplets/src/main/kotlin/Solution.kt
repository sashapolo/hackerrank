// Complete the countTriplets function below.
fun countTriplets(arr: List<Long>, r: Int): Long {
    val awaitingSecond = HashMap<Long, Long>()
    val awaitingThird = HashMap<Long, Long>()
    return arr.asSequence()
            .map {
                val completeTriplets = awaitingThird[it] ?: 0

                val alreadyAwaitingSecond = awaitingSecond[it]
                if (alreadyAwaitingSecond != null) {
                    awaitingThird.increment(it * r, alreadyAwaitingSecond)
                }

                awaitingSecond.increment(it * r)

                completeTriplets
            }
            .sum()
}

private fun <K> MutableMap<K, Long>.increment(key: K, increment: Long = 1L) {
    val existingValue = getOrDefault(key, 0L)
    this[key] = existingValue + increment
}

fun main() {
    val nr = readLine()!!.trimEnd().split(" ")

    val n = nr[0].toInt()
    val r = nr[1].toInt()

    val arr = readLine()!!.trimEnd().split(" ").map { it.toLong() }
    val ans = countTriplets(arr, r)

    println(ans)
}