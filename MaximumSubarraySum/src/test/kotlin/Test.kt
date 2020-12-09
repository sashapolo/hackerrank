import kotlin.test.Test
import kotlin.test.assertEquals

class Test {
    @Test
    fun test() {
        assertEquals(6, maximumSum(listOf(4, 4, 5).map { it.toLong() }, 7))
    }
}