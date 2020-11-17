import kotlin.math.abs

// Complete the makeAnagram function below.
fun makeAnagram(a: String, b: String): Int {
    val frequencies = IntArray('z' - 'a' + 1)
    a.forEach { frequencies[it - 'a'] += 1 }
    b.forEach { frequencies[it - 'a'] -= 1 }
    return frequencies.sumBy { abs(it) }
}

fun main() {
    val a = readLine()!!
    val b = readLine()!!
    val res = makeAnagram(a, b)
    println(res)
}
