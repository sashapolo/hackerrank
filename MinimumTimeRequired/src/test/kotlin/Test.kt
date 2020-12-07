import kotlin.test.Test
import kotlin.test.assertEquals

class Test {
    @Test
    fun test() {
        assertEquals(82, minTime(listOf(63, 2, 26, 59, 16, 55, 99, 21, 98, 65).map { it.toLong() }.sorted(), 56))
    }
}