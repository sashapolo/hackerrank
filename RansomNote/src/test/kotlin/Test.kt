import kotlin.test.Test
import kotlin.test.assertFalse
import kotlin.test.assertTrue

class Test {
    @Test
    fun testCase1() {
        val magazine = "give me one grand today night".split()
        val note = "give one grand today".split()
        assertTrue(checkMagazine(magazine, note))
    }

    @Test
    fun testCase2() {
        val magazine = "two times three is not four".split()
        val note = "two times two is four".split()
        assertFalse(checkMagazine(magazine, note))
    }

    @Test
    fun testCase3() {
        val magazine = "ive got a lovely bunch of coconuts".split()
        val note = "ive got some coconuts".split()
        assertFalse(checkMagazine(magazine, note))
    }

    private fun String.split() = split(" ").toTypedArray()
}