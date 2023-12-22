import kotlin.math.exp

/**
 * We are given a composition of <=10^5 exp and log functions.
 * After a set of transformations
 * we get only compositions of exp functions or only composition of log functions.
 * ------------------------------------------------------------------
 * about EXP:
 *
 * exp =: e
 * e(x) > 0
 * e(e(x)) > 1
 * e(e(e(x))) > e
 * e(e(e(e(x)))) > e^2
 * For e^1 we need to have 3 e's in our string.
 * and, in general, e^k is the minimal(not included) value for e^(k+2)
 *
 * ------------------------------------------------------------------
 * about LOG:
 * log = l for shortness
 * For x > 0
 * inf < l(x) < inf
 *
 * For x > 1, l(x)>0
 * inf < l(l(x)) < inf
 * And so on. If we have only logs in final expression it means that every value is valid.
 *
 * ------------------------------------------------------------------
 * So:
 * Write simplifier for compositions.
 * If exp, then count result in a special power of e way.
 * If log, return true
 *  EXAMPLE{
 *      exp(log(x))
 *      0.00
 *      Answer: NO
 *  }
 * Check: the initial expression has no exp in the first position.
 * If it there is, then only positive values are valid.
 *
 */
fun main() {
    val result = solveProblem("exp(exp(exp(exp(x))))", 7.30)
    println(result)
}

fun solveProblem(expression: String, a: Double): Boolean {
    // if expression looks like: exp(...), then it must be > 0
    if (expression[0] == 'e' && a <= 0) {
        return false
    }
    val simplifiedExpression = simplifyExpression(expression)
    // Simplified to just "x"
    if (simplifiedExpression.isEmpty()) {
        return true
    }
    // if all functions are logs, then the value can be any real
    if (simplifiedExpression.first() == 'l') {
        return true
    }
    // if simplified expression = exp(x), then it > 0
    if (simplifiedExpression.size == 1) {
        return a > 0
    }
    // if simplified expression = exp(exp(x)), then it > 1
    if (simplifiedExpression.size == 2) {
        return a > 1
    }
    // if simplified expression = e^(m)(x), then it > e^(m-2)
    return a > exp(simplifiedExpression.size - 2.0)
}

fun simplifyExpression(expression: String): List<Char> {
    // remove parenthesis and letter x in the end:
    val withoutParenthesis = expression.filter { it != '(' && it != ')' }
    val onlyFunctions = withoutParenthesis.substring(0, withoutParenthesis.lastIndex)
    // add every function to list
    val simplified = mutableListOf<Char>()
    for (i in 0..onlyFunctions.lastIndex - 2 step 3) {
        simplified.add(onlyFunctions[i])
    }
    // remove all ...exp(log(... and ...log(exp(... situations:
    var index = 0
    while (index <= simplified.lastIndex) {
        // remove combination of log(exp... or exp(log... when index on second function (exp and log respectfully)
        if (index > 0 && simplified[index] != simplified[index - 1]) {
            simplified.removeAt(index - 1)
            simplified.removeAt(index - 1)
            index--
            continue
        }
        if (index == simplified.lastIndex) {
            break
        }
        // remove combination of log(exp... or exp(log... when index on first function (log and exp respectfully)
        if (simplified[index] != simplified[index + 1]) {
            simplified.removeAt(index)
            simplified.removeAt(index)
            continue
        }
        index++
    }
    return simplified
}

fun printSimplifiedExpression(expression: List<Char>) {
    for (f in expression) {
        print(if (f == 'e') "exp(" else "log(")
    }
    print('x')
    print(")".repeat(expression.size))
}
