import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*

class ThePackersProblemKtTest {

    @Test
    fun `given test 1`() {
        val boxEvents = mutableListOf<BoxEvent>()
        listOf("O 4", "C 4", "O 2", "C 2", "O 10", "C 10").forEach {
            val pair = it.split(" ")
            val event = BoxEvent(pair[0][0], pair[1].toInt())
            boxEvents.add(event)
        }

        val result = validatePackersWork(boxEvents)
        assertEquals("Good Job! 1", result)
    }

    @Test
    fun `given test 2`() {
        val boxEvents = mutableListOf<BoxEvent>()
        listOf(
            "O 5", "O 5", "O 4", "C 4", "C 5", "C 5"
        ).forEach {
            val pair = it.split(" ")
            val event = BoxEvent(pair[0][0], pair[1].toInt())
            boxEvents.add(event)
        }

        val result = validatePackersWork(boxEvents)
        assertEquals("Good Job! 3", result)
    }

    @Test
    fun `given test 3`() {
        val boxEvents = mutableListOf<BoxEvent>()
        listOf(
            "O 5", "O 6", "C 6", "C 5"
        ).forEach {
            val pair = it.split(" ")
            val event = BoxEvent(pair[0][0], pair[1].toInt())
            boxEvents.add(event)
        }

        val result = validatePackersWork(boxEvents)
        assertEquals("You are fired!", result)
    }

    @Test
    fun `given test 4`() {
        val boxEvents = mutableListOf<BoxEvent>()
        listOf(
            "O 4", "C 5", "O 5", "C 4"
        ).forEach {
            val pair = it.split(" ")
            val event = BoxEvent(pair[0][0], pair[1].toInt())
            boxEvents.add(event)
        }

        val result = validatePackersWork(boxEvents)
        assertEquals("You are fired!", result)
    }

    @Test
    fun `my test 1`() {
        val boxEvents = mutableListOf<BoxEvent>()
        listOf(
            "O 6", "O 6", "O 4", "C 4", "O 2", "O 2", "O 1", "C 1", "C 2", "C 2", "C 6", "C 6",

            ).forEach {
            val pair = it.split(" ")
            val event = BoxEvent(pair[0][0], pair[1].toInt())
            boxEvents.add(event)
        }

        val result = validatePackersWork(boxEvents)
        assertEquals("Good Job! 5", result)
    }
}