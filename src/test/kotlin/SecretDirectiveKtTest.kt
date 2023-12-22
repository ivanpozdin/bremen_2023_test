import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*

class SecretDirectiveKtTest {

    private fun secreteDirectiveSimulation(leftTextLines: List<String>, rightTextLines: List<String>): String {
        val leftColumns = getListOfColumns(leftTextLines)
        val rightColumns = getListOfColumns(rightTextLines)
        val longest = findDirective(leftColumns, rightColumns)

        return if (longest.isEmpty()) {
            ("-")
        } else {
            (longest)
        }
    }

    @Test
    fun `given test 1`() {
        val leftTextLines = listOf(
            "free", "sushi", "on", "mondays"
        )
        val rightTextLines = listOf(
            "play", "for", "blue", "bananas"
        )

        val result = secreteDirectiveSimulation(leftTextLines, rightTextLines)
        assertEquals("run", result)

    }

    @Test
    fun `given test 2`() {
        val leftTextLines = listOf(
            "dwarves"
        )
        val rightTextLines = listOf(
            "quiz", "job"
        )

        val result = secreteDirectiveSimulation(leftTextLines, rightTextLines)
        assertEquals("-", result)
    }

    @Test
    fun `my test 1`() {
        val leftTextLines = listOf(
            "modification", "alignment", "apron", "ameba", "breaks", "dancing", "milk", "brightest", "jurisdiction"
        )
        val rightTextLines = listOf(
            "pepperoni",
            "measurement",
            "garbage",
            "outdoors",
            "background",
            "adrenaline",
            "cinematography",
            "kennedy",
            "aesthetic",
        )

        val result = secreteDirectiveSimulation(leftTextLines, rightTextLines)
        assertEquals("goback", result)
    }
}