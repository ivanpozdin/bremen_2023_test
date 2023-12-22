import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*

class HonestIslandKtTest {

    @Test
    fun `given test`() {
        val result = getAllPossibleNumbersOfLiars(listOf(0, 2, 2, 3))
        assertEquals(listOf(0, 1, 3, 4), result)
    }
    @Test
    fun `my test 1`() {
        val result = getAllPossibleNumbersOfLiars(listOf(0, 0, 1, 2, 3))
        assertEquals(listOf(0, 5), result)
    }

    @Test
    fun `my test 2`() {
        val result = getAllPossibleNumbersOfLiars(listOf(0, 0, 1, 2, 3, 8, 9))
        assertEquals(listOf(0, 5, 6), result)
    }
    @Test
    fun `my test 3`() {
        val result = getAllPossibleNumbersOfLiars(listOf(0, 4, 5, 5, 5, 8, 9))
        assertEquals(listOf(0, 1, 2, 5, 6), result)
    }
}