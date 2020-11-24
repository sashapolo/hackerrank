import org.junit.jupiter.api.DynamicTest.dynamicTest
import org.junit.jupiter.api.TestFactory
import kotlin.test.assertEquals

class Test {

    @TestFactory
    fun tests() =
            listOf(
                    7 to "asasd",
                    10 to "abcbaba",
                    10 to "aaaa"
            ).map { (expected, str) ->
                dynamicTest("String $str should produce $expected special substrings") {
                    assertEquals(expected, substrCount(str))
                }
            }
}