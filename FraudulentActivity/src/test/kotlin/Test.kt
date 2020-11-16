import kotlin.test.Test
import kotlin.test.assertEquals

class Test {
    @Test
    fun testCase1() {
        assertEquals(2, activityNotifications(arrayOf(2, 3, 4, 2, 3, 6, 8, 4, 5), 5))
    }

    @Test
    fun testCase2() {
        assertEquals(0, activityNotifications(arrayOf(1, 2, 3, 4, 4), 4))
    }
}