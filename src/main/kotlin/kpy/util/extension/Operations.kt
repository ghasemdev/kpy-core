package kpy.util.extension

/*
* Logical Operations
*
* @author jakode
* @since v2.0.0 08/14/2021
*/

/**
 * Repeats a string to the number of repetitions
 *
 * Example:
 * ```
 *      println("10" * 5)
 *      output: 1010101010
 * ```
 */
operator fun String.times(repeat: Int) = this.repeat(repeat)

/**
 * Repeats a character to the number of repetitions
 *
 * Example:
 * ```
 *      println('0' * 5)
 *      output: 00000
 * ```
 */
operator fun Char.times(repeat: Int) = this.toString() * repeat

/** not or */
infix fun Boolean.nor(other: Boolean) = !(this or other)

/** not and */
infix fun Boolean.nand(other: Boolean) = !(this and other)

/** not xor */
infix fun Boolean.xnor(other: Boolean) = !(this xor other)

/** not or */
infix fun Int.nor(other: Int): Int {
    val orResult = this or other
    return if (orResult == 0) 1 else 0
}

/** not and */
infix fun Int.nand(other: Int): Int {
    val andResult = this and other
    return if (andResult == 0) 1 else 0
}

/** not xor */
infix fun Int.xnor(other: Int): Int {
    val xorResult = this xor other
    return if (xorResult == 0) 1 else 0
}

/** not */
fun not(value: Int): Int {
    return if (value == 0) 1 else 0
}