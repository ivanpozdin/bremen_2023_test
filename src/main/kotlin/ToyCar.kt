import kotlin.math.max

fun calculateDistance(buttons: String): Int {
    var distance = 0
    var speed = 0
    buttons.forEach {
        if (it == '+') {
            speed++
        } else {
            speed = max(0, speed - 1)
        }
        distance += speed
    }
    return distance
}

fun main() {
    val distance = calculateDistance("+---+")
    print(distance)
}