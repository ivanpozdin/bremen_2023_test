import java.util.*
import kotlin.math.max

/**
 * We have 2n strings denoting whether box of size s is being opened of closed.
 *
 * While processing input
 * store in STACK boxes with their depth, size and capacityLeft.
 *
 * When open new box A:
 *
 * If there is open box B on top of the stack already, then we have to put A in that B.
 * If A.size > B.capacityLeft, then return "FIRED", because there is no room for A.
 * Else, we update open box: capacityLeft -= (size of new box)
 * and put A on stack with A.depth = B.depth
 *
 * If there is no box on stack, we put box A with depth 1 on it.
 *
 *
 * When close box with size s1:
 *
 * If there is open box on top of the stack with the size of s1, then we
 * 1) remove it from stack
 * 2) update maximum depth
 *
 * If there box on top of the stack has different size:
 * return "FIRED"
 */

data class Box(val depth: Int, val size: Int, var capacityLeft: Int = size)
data class BoxEvent(val type: Char, val size: Int)

const val FIRED = "You are fired!"

fun openBox(boxSize: Int, openBoxes: Stack<Box>): Boolean {
    if (openBoxes.isEmpty()) {
        openBoxes.push(Box(1, boxSize))
        return true
    }
    val topBox = openBoxes.peek()
    if (topBox.size < boxSize) {
        return false
    }
    topBox.capacityLeft -= boxSize
    openBoxes.push(Box(topBox.depth + 1, boxSize))
    return true
}

fun closeBox(boxSize: Int, openBoxes: Stack<Box>): Int {
    if (openBoxes.isEmpty()) {
        return -1
    }
    val closedBox = openBoxes.pop()
    if (closedBox.size != boxSize) {
        return -1
    }
    return closedBox.depth
}

fun validatePackersWork(boxEvents: List<BoxEvent>): String {
    val openBoxes = Stack<Box>()
    var deepest = 0

    for ((type, boxSize) in boxEvents) {
        when (type) {
            'O' -> if (!openBox(boxSize, openBoxes)) {
                return FIRED
            }

            'C' -> closeBox(boxSize, openBoxes).let {
                if (it == -1) return FIRED
                else deepest = max(deepest, it)
            }
        }
    }
    if (openBoxes.isNotEmpty()) {
        return FIRED
    }
    return "Good Job! $deepest"
}

fun main() {
    val boxEvents = mutableListOf<BoxEvent>()
    val n = readln().toInt()
    repeat(2 * n) {
        val eventSplit = readln().split(" ")
        val typeOfEvent = eventSplit[0][0]
        val sizeOfBox: Int = eventSplit[1].toInt()
        val boxEvent = BoxEvent(typeOfEvent, sizeOfBox)
        boxEvents.add(boxEvent)
    }
    println(validatePackersWork(boxEvents))
}