
import kotlin.test.Test
import kotlin.test.assertEquals

class Test {
    @Test
    fun testFlowers() {
        assertEquals(13, getMinimumCost(3, listOf(2, 5, 6)))
        assertEquals(15, getMinimumCost(2, listOf(2, 5, 6)))
        assertEquals(29, getMinimumCost(3, listOf(1, 3, 5, 7, 9)))
    }
}