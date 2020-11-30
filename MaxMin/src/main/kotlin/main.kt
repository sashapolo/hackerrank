fun maxMin(k: Int, arr: List<Int>): Int {
    val sorted = arr.sorted()
    return (0..(arr.size - k)).asSequence()
            .map { sorted[it + k - 1] - sorted[it] }
            .minOrNull()!!
}

fun main() {
    val n = readLine()!!.trim().toInt()
    val k = readLine()!!.trim().toInt()

    val arr = (0 until n)
            .map { readLine()!!.trim() }
            .map { it.toInt() }
            .toList()

    val result = maxMin(k, arr)

    println(result)
}