fun abbreviation(a: String, b: String): Boolean {
    val cache = Array(a.length + 1) { BooleanArray(b.length + 1) }
    cache[0][0] = true
    for (i in a.indices) {
        cache[i + 1][0] = a[i].isLowerCase() && cache[i][0]
    }

    for (i in a.indices) {
        for (j in b.indices) {
            cache[i + 1][j + 1] = when {
                a[i] == b[j] -> cache[i][j]
                a[i].toUpperCase() == b[j] -> cache[i][j + 1] || cache[i][j]
                a[i].isLowerCase() -> cache[i][j + 1]
                else -> false
            }
        }
    }

    return cache[a.length][b.length]
}

fun main() {
    val q = readLine()!!.trim().toInt()
    repeat(q) {
        val a = readLine()!!
        val b = readLine()!!
        val result = abbreviation(a, b)
        println(if (result) "YES" else "NO")
    }
}