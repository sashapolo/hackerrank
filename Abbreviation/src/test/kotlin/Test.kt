
import kotlin.test.Test
import kotlin.test.assertFalse
import kotlin.test.assertTrue

class Test {
    @Test
    fun test() {
        assertTrue(abbreviation("daBcd", "ABC"))
        assertFalse(abbreviation("LLZOSYAMQRMBTZXTQMQcKGLR", "LLZOSYAMBTZXMQKLR"))
        assertFalse(abbreviation("MGYXKOVSMAHKOLAZZKWXKS", "MGXKOVSAHKOLZKKDP"))
        assertFalse(abbreviation("KLdsad", "K"))
        assertTrue(abbreviation("VLKHNlpsrlrvfxftslslrrh", "VLKHN"))
        assertFalse(abbreviation("OQSVONTNZMDJAVRZAZCVPKh", "OSVONTNZMDJAVRZAZCVPK"))
        assertTrue(abbreviation("AXbosoh", "AX"))
        assertFalse(abbreviation("EYONDOCHNZYYlBZXPGzX", "EYONDOCHNZYYBZXPGXOG"))
        assertTrue(abbreviation("bBccC", "BBC"))
        assertFalse(abbreviation("BDB", "BB"))
    }
}