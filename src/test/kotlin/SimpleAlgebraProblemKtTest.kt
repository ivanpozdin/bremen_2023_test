import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*

class SimpleAlgebraProblemKtTest {
    @Test
    fun `given test 1`() {
        val result = solveProblem("exp(exp(x))", 0.50)
        assertEquals(false, result)
    }

    @Test
    fun `given test 2`() {
        val result = solveProblem("log(log(exp(log(x))))", -2.39)
        assertEquals(true, result)
    }

    @Test
    fun `given test 3`() {
        val result = solveProblem("exp(x)", 0.00)
        assertEquals(false, result)
    }

    @Test
    fun `given test 4`() {
        val result = solveProblem("exp(log(x))", 0.00)
        assertEquals(false, result)
    }

    @Test
    fun `exp(log(exp(exp(x)))) 1,00`() {
        val result = solveProblem("exp(log(exp(exp(x))))", 1.00)
        assertEquals(false, result)
    }

    @Test
    fun `exp(log(exp(exp(x)))) 1,01`() {
        val result = solveProblem("exp(log(exp(exp(x))))", 1.01)
        assertEquals(true, result)
    }


    @Test
    fun `log(log(exp(log(exp(exp(x)))))) -100,00`() {
        val result = solveProblem("log(log(exp(log(exp(exp(x))))))", -100.0)
        assertEquals(true, result)
    }
}
