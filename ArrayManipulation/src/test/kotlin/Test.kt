import kotlin.test.Test
import kotlin.test.assertEquals

class Test {
    @Test
    fun testFirstCase() {
        val query = listOf(
                intArrayOf(1, 2, 100),
                intArrayOf(2, 5, 100),
                intArrayOf(3, 4, 100)
        )
        assertEquals(200, arrayManipulation(5, query))
    }

    @Test
    fun testSecondCase() {
        val query = listOf(
                intArrayOf(2, 6, 8),
                intArrayOf(3, 5, 7),
                intArrayOf(1, 8, 1),
                intArrayOf(5, 9, 15)
        )
        assertEquals(31, arrayManipulation(10, query))
    }
}