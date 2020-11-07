import kotlin.test.Test
import kotlin.test.assertEquals

class Test {
    @Test
    fun testCase1() {
        val queries = listOf(
                1 to 5,
                1 to 6,
                3 to 2,
                1 to 10,
                1 to 10,
                1 to 6,
                2 to 5,
                3 to 2,
        )
        assertEquals(listOf(false, true), freqQuery(queries))
    }

    @Test
    fun testCase2() {
        val queries = listOf(
                1 to 5,
                3 to 1,
                2 to 5,
                3 to 1
        )
        assertEquals(listOf(true, false), freqQuery(queries))
    }

    @Test
    fun testCase3() {
        val queries = listOf(
                1 to 5,
                2 to 6,
                3 to 1
        )
        assertEquals(listOf(true), freqQuery(queries))
    }
}