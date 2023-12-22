/*
Sort replies.
Let N = number of residents

 Iterate through replies:
    Let REPLY be the current reply and INDEX be an index of REPLY.

    If INDEX <= REPLY
    there can be INDEX liars (not including current replier).
    However, if previous reply is equal to current,
    => they are both true or both false. If they are false => continue,
    if they are true => correct answer was added on previous step.

    0 is always correct possible number of liars.

    basically all reply's indexes that are smaller than current reply's index.

    if INDEX > REPLY => continue, because values <= REPLY were already processed.

 If last reply was < N => all of them can be liars, so add N.
 But if last reply was >= N => all of them can not be liars.
 */


fun getAllPossibleNumbersOfLiars(repliesUnsorted: List<Int>): List<Int> {
    val replies = repliesUnsorted.sorted()

    val possibleNumberOfLiars = mutableSetOf<Int>()
    replies.forEachIndexed { i, r ->
        if (i <= r && (i == 0 || r != replies[i - 1])) {
            possibleNumberOfLiars.add(i)
        }
    }
    // When all residents can be liars.
    if (replies.last() < repliesUnsorted.size) {
        possibleNumberOfLiars.add(repliesUnsorted.size)
    }

    return possibleNumberOfLiars.toList().sorted()
}

fun main() {
    readln()
    val residentsReplies = readln().split(" ").map { it -> it.toInt() }
    val liarsNumbers = getAllPossibleNumbersOfLiars(residentsReplies)
    println(liarsNumbers.joinToString(" "))
}