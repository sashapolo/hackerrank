import kotlin.test.Test
import kotlin.test.assertEquals

class Test {
    @Test
    fun testFirstCase() {
        assertEquals(3, minimumBribes(intArrayOf(2, 1, 5, 3, 4)))
    }

    @Test
    fun testSecondCase() {
        assertEquals(null, minimumBribes(intArrayOf(2, 5, 1, 3, 4)))
    }

    @Test
    fun testThirdCase() {
        assertEquals(7, minimumBribes(intArrayOf(1, 2, 5, 3, 7, 8, 6, 4)))
    }
}