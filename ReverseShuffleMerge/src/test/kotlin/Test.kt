import kotlin.test.Test
import kotlin.test.assertEquals

class Test {
    @Test
    fun testMergeShuffle() {
        assertEquals("egg", reverseShuffleMerge("eggegg"))
        assertEquals("agfedcb", reverseShuffleMerge("abcdefgabcdefg"))
        assertEquals("aeiou", reverseShuffleMerge("aeiouuoiea"))
        assertEquals("aaaaaabaaceededecbdb", reverseShuffleMerge("bdabaceadaedaaaeaecdeadababdbeaeeacacaba"))
    }
}