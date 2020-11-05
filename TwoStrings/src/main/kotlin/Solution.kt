import java.util.*

// Complete the twoStrings function below.
fun twoStrings(s1: String, s2: String): Boolean {
    val chars = s1.toSet()
    return s2.any { chars.contains(it) }
}

fun main() {
    val scan = Scanner(System.`in`)
    val q = scan.nextLine().trim().toInt()
    for (qItr in 1..q) {
        val s1 = scan.nextLine()
        val s2 = scan.nextLine()
        val result = twoStrings(s1, s2)
        println(if (result) "YES" else "NO")
    }
}