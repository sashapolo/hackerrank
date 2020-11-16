import kotlin.test.Test
import kotlin.test.assertEquals

class Test {
    @Test
    fun testCase1() {
        assertEquals(0, countInversions(intArrayOf(1, 1, 1, 2, 2)))
    }

    @Test
    fun testCase2() {
        assertEquals(4, countInversions(intArrayOf(2, 1, 3, 1, 2)))
    }
}