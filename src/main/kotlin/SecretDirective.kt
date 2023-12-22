import kotlin.math.min

/**
 * Get the length of the shortest string in both texts and then cut the unnecessary parts.
 *
 * Create lists of columns from text1 and texts2.
 *
 * Try to find common part in every pair of columns: first from text1 columns and
 * second from text 2 columns.
 * While doing so update maximum common part.
 *
 */

fun main() {
    val leftTextLinesNumber = readln().toInt()
    val leftTextLines = mutableListOf<String>()
    repeat(leftTextLinesNumber) {
        leftTextLines.add(readln())
    }
    val rightTextLinesNumber = readln().toInt()
    val rightTextLines = mutableListOf<String>()
    repeat(rightTextLinesNumber) {
        rightTextLines.add(readln())
    }
    val leftColumns = getListOfColumns(leftTextLines)
    val rightColumns = getListOfColumns(rightTextLines)
    val longest = findDirective(leftColumns, rightColumns)

    if (longest.isEmpty()) {
        println("-")
    } else {
        println(longest)
    }
}


fun findDirective(columnsFromLeftText: List<String>, columnsFromRightText: List<String>): String {
    var longest = ""
    for (left in columnsFromLeftText) {
        for (right in columnsFromRightText) {
            val currentLongest = getLongestCommonSubstring(left, right)
            if (currentLongest.length > longest.length) {
                longest = currentLongest
            }
        }
    }
    return longest
}

fun getLongestCommonSubstring(left: String, right: String): String {
    var longestCommonSubstring = ""

    for (i in left.indices) {
        var rightIndex = 0

        while (rightIndex < right.length) {
            var j = rightIndex
            while (j < right.length && right[j] != left[i]) {
                j++
            }
            if (j == right.length) {
                rightIndex++
                continue
            }
            var k = 0
            while (i + k < left.length && k + j < right.length && left[i + k] == right[j + k]) {
                k++
            }
            if (k > longestCommonSubstring.length) {
                longestCommonSubstring = left.substring(i, i + k)
            }
            rightIndex++
        }
    }
    return longestCommonSubstring
}

fun getListOfColumns(lines: List<String>): List<String> {
    var minLength = lines[0].length

    lines.forEach { minLength = min(minLength, it.length) }
    val columns = mutableListOf<String>()
    for (i in 0 until minLength) {
        val column = StringBuilder()
        for (line in lines) {
            column.append(line[i])
        }
        columns.add(column.toString())
    }
    return columns
}