
// Complete the freqQuery function below.
fun freqQuery(queries: List<Pair<Int, Int>>): List<Boolean> {
    val elementCount = HashMap<Int, Int>()
    val frequencyCount = HashMap<Int, Int>()
    val result = ArrayList<Boolean>()

    queries.forEach { (command, value) ->
        when (command) {
            1 -> {
                val frequency = elementCount.increment(value)
                frequencyCount.increment(frequency)
                frequencyCount.decrement(frequency - 1)
            }
            2 -> {
                val frequency = elementCount[value] ?: 0
                if (frequency != 0) {
                    elementCount.decrement(value)
                    frequencyCount.decrement(frequency)
                    frequencyCount.increment(frequency - 1)
                }
            }
            3 -> result.add(frequencyCount[value] ?: 0 > 0)
        }
    }

    return result
}

private fun <K> MutableMap<K, Int>.increment(key: K): Int {
    val existingValue = this[key] ?: 0
    val newValue = existingValue + 1
    this[key] = newValue
    return newValue
}

private fun <K> MutableMap<K, Int>.decrement(key: K): Int {
    val existingValue = this[key] ?: 0
    if (existingValue == 0) {
        return 0
    }
    val newValue = existingValue - 1
    this[key] = newValue
    return newValue
}

fun main() {
    val q = readLine()!!.trim().toInt()

    val queries = ArrayList<Pair<Int, Int>>(q)

    repeat(q) {
        val (i, j) = readLine()!!.trimEnd().split(" ").map{ it.toInt() }.toTypedArray()
        queries.add(i to j)
    }

    val ans = freqQuery(queries)

    println(ans.asSequence().map { if (it) 1 else 0 }.joinToString("\n"))
}
