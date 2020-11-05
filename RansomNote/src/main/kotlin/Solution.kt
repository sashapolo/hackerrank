import java.util.*

// Complete the checkMagazine function below.
fun checkMagazine(magazine: Array<String>, note: Array<String>): Boolean {
    fun Array<String>.wordCount() = groupingBy { it }.eachCount()

    val magazineWordCount = magazine.wordCount()
    val noteWordCount = note.wordCount()

    return noteWordCount.all { (word, count) ->
        val magazineCount = magazineWordCount[word] ?: 0
        magazineCount >= count
    }
}

fun main() {
    val scan = Scanner(System.`in`)
    val mn = scan.nextLine().split(" ")
    val magazine = scan.nextLine().split(" ").toTypedArray()
    val note = scan.nextLine().split(" ").toTypedArray()

    println(if (checkMagazine(magazine, note)) "Yes" else "No")
}