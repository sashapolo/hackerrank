import kotlin.math.max

fun commonChild(s1: String, s2: String): Int {
    val cache = Array(s1.length + 1) { IntArray(s2.length + 1) }

    for (i in s1.indices) {
        for (j in s2.indices) {
            cache[i + 1][j + 1] = if (s1[i] == s2[j]) {
                1 + cache[i][j]
            } else {
                max(cache[i + 1][j], cache[i][j + 1])
            }
        }
    }

    return cache[s1.length][s2.length]
}

fun main() {
    val s1 = readLine()!!
    val s2 = readLine()!!
    val result = commonChild(s1, s2)

    println(result)
}
