import java.util.*

// Complete the jumpingOnClouds function below.
fun jumpingOnClouds(c: Array<Int>): Int {
    var curPos = 0
    var numHops = 0
    while (curPos < c.size - 1) {
        curPos += 2
        if (curPos >= c.size || c[curPos] == 1) {
            curPos -= 1
        }
        numHops++
    }
    return numHops
}

fun main() {
    val scan = Scanner(System.`in`)

    val n = scan.nextLine().trim().toInt()

    val c = scan.nextLine().split(" ").map{ it.trim().toInt() }.toTypedArray()

    val result = jumpingOnClouds(c)

    println(result)
}
