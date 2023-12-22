import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*

class ToyCarKtTest {

    @Test
    fun `given test 1`() {
        assertEquals(6, calculateDistance("++-+"))
    }
    @Test
    fun `given test 2`() {
        assertEquals(0, calculateDistance("---"))
    }
    @Test
    fun `given test 3`() {
        assertEquals(2, calculateDistance("+---+"))
    }
}