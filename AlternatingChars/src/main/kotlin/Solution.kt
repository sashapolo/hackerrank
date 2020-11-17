// Complete the alternatingCharacters function below.
fun alternatingCharacters(s: String): Int {
    var deletions = 0
    var curChar = 'X'
    s.forEach {
        if (curChar == it) {
            deletions += 1
        } else {
            curChar = it
        }
    }
    return deletions
}

fun main() {
    val q = readLine()!!.trim().toInt()
    for (qItr in 1..q) {
        val s = readLine()!!
        val result = alternatingCharacters(s)
        println(result)
    }
}