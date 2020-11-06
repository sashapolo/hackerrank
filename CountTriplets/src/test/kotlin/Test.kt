import org.junit.jupiter.api.DynamicTest
import org.junit.jupiter.api.DynamicTest.dynamicTest
import org.junit.jupiter.api.TestFactory
import java.util.stream.Stream
import kotlin.test.assertEquals

class Test {
    @TestFactory
    fun testAnagrams(): Stream<DynamicTest> {
        return Stream.of(
                2L to (listOf(1, 2, 2, 4) to 2),
                6L to (listOf(1, 3, 9, 9, 27, 81) to 3),
                4L to (listOf(1, 5, 5, 25, 125) to 5),
                0L to (listOf(4, 2, 1) to 2),
                4L to (listOf(1, 1, 1, 1) to 1),
                1L to (listOf(1, 2, 4, 2) to 2),
                1L to (listOf(1, 10, 1, 100) to 10)
        ).map { (expected, data) ->
            val (list, ratio) = data
            dynamicTest("List $list should produce $expected number of triplets for ratio $ratio") {
                assertEquals(expected, countTriplets(list.map { it.toLong() }, ratio))
            }
        }
    }
}