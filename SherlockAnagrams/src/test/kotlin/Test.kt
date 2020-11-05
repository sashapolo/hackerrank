
import org.junit.jupiter.api.DynamicTest
import org.junit.jupiter.api.DynamicTest.dynamicTest
import org.junit.jupiter.api.TestFactory
import java.util.stream.Stream
import kotlin.test.assertEquals

class Test {
    @TestFactory
    fun testAnagrams(): Stream<DynamicTest> {
        return Stream.of(
                4 to "abba",
                0 to "abcd",
                3 to "ifailuhkqq",
                10 to "kkkk",
                5 to "cdcd"
        ).map { (expected, str) ->
            dynamicTest("String $str should contain $expected anagrams") {
                assertEquals(expected, sherlockAndAnagrams(str))
            }
        }
    }
}