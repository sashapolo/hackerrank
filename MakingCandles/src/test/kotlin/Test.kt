import kotlin.test.Test
import kotlin.test.assertEquals

class Test {
    @Test
    fun test() {
        assertEquals(3, minimumPasses(3, 1, 2, 12))
        assertEquals(4, minimumPasses(1, 2, 1, 60))
        assertEquals(16, minimumPasses(1, 1, 6, 45))
    }

    @Test
    fun longTest() {
        assertEquals(1000000000000, minimumPasses( 1, 1, 1000000000000, 1000000000000))
    }

    @Test
    fun longTest2() {
        assertEquals(617737754, minimumPasses( 1, 100, 10000000000, 1000000000000))
    }

    @Test
    fun cornerCase() {
        assertEquals(1, minimumPasses(4294967296, 4294967296, 1000000000, 10000000000))
    }
}