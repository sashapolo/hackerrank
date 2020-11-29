fun getMinimumCost(k: Int, c: List<Int>): Int =
        c.asSequence()
                .sortedDescending()
                .mapIndexed { i, price -> price * (i / k + 1) }
                .sum()


fun main() {

    val nk = readLine()!!.split(" ")

    val n = nk[0].trim().toInt()
    val k = nk[1].trim().toInt()

    val c = readLine()!!.split(" ").map { it.trim().toInt() }

    val minimumCost = getMinimumCost(k, c)

    println(minimumCost)
}