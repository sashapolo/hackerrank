class SortedList<T : Comparable<T>>(capacity: Int) : MutableList<T> by ArrayList<T>(capacity) {
    override fun add(element: T): Boolean {
        add(sortedIndex(element), element)
        return true
    }

    override fun remove(element: T): Boolean {
        removeAt(sortedIndex(element))
        return true
    }

    private fun sortedIndex(element: T): Int {
        val index = binarySearch(element)
        return if (index < 0) {
            -index - 1
        } else {
            index
        }
    }
}

// Complete the activityNotifications function below.
fun activityNotifications(expenditure: Array<Int>, d: Int): Int {
    val sortedList = SortedList<Int>(d)
    var numOfNotifications = 0
    expenditure.forEachIndexed { index, currentExpenditure ->
        if (sortedList.size == d) {
            val median = if (d % 2 == 0) {
                (sortedList[(d / 2) - 1] + sortedList[d / 2]) / 2.0
            } else {
                sortedList[d / 2].toDouble()
            }
            if (currentExpenditure >= 2 * median) {
                numOfNotifications += 1
            }
            sortedList.remove(expenditure[index - d])
        }
        sortedList.add(currentExpenditure)
    }
    return numOfNotifications
}

fun main() {
    val nd = readLine()!!.split(" ")
    val n = nd[0].trim().toInt()
    val d = nd[1].trim().toInt()
    val expenditure = readLine()!!.split(" ").map{ it.trim().toInt() }.toTypedArray()
    val result = activityNotifications(expenditure, d)
    println(result)
}