import kotlin.test.Test
import kotlin.test.assertEquals

class Test {
    @Test
    fun testFirstCase() {
        assertEquals(3, minimumSwaps(intArrayOf(2, 3, 4, 1, 5)))
    }

    @Test
    fun testSecondCase() {
        assertEquals(3, minimumSwaps(intArrayOf(1, 3, 5, 2, 4, 6, 7)))
    }
}