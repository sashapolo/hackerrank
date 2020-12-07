import kotlin.math.abs

fun triplets(a: List<Int>, b: List<Int>, c: List<Int>): Long =
    b.asSequence()
        .map { a.lessThanSize(it) * c.lessThanSize(it) }
        .sum()

fun List<Int>.lessThanSize(x: Int): Long = abs(binarySearch(x) + 1).toLong()

fun main() {
    fun readList(): List<Int> =
        readLine()!!.split(" ").asSequence()
            .map { it.trim().toInt() }
            .toSortedSet()
            .toList()

    readLine()

    val a = readList()
    val b = readList()
    val c = readList()

    val ans = triplets(a, b, c)

    println(ans)
}

