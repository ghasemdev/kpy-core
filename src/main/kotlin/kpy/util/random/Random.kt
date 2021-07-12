package kpy.util.random

import java.util.*
import kotlin.random.asKotlinRandom
import kotlin.random.nextInt
import kotlin.random.nextLong

/*
* Random extensions method from python language
*
* author jakode
* since v1.0.0 5/11/2021
*/

private val rand = Random()

/**
 * Gets the next random `Int` from the random number generator in the specified [range].
 *
 * Generates an `Int` random value uniformly distributed in the specified [range]:
 * from `range.start` inclusive to `range.endInclusive` inclusive.
 */
fun kotlin.random.Random.randInt(range: IntRange) = randomInt(range)

/**
 * Gets the next random `Int` from the random number generator.
 *
 * @param start Start the range
 * @param end End of range
 * @param step range steps
 */
fun kotlin.random.Random.randInt(start: Int = 0, end: Int, step: Int = 1) = randomInt(start, end, step)

private fun randomInt(range: IntRange): Int = rand.asKotlinRandom().nextInt(range)

private fun randomInt(start: Int, end: Int, step: Int): Int {
    return rand.nextInt((end + step - start) / step) * step + start
}

/**
 * Gets the next random `Long` from the random number generator in the specified [range].
 *
 * Generates an `Long` random value uniformly distributed in the specified [range]:
 * from `range.start` inclusive to `range.endInclusive` inclusive.
 */
fun kotlin.random.Random.randLong(range: LongRange) = randomLong(range)

/**
 * Gets the next random `Long` from the random number generator.
 *
 * @param start Start the range
 * @param end End of range
 * @param step range steps
 */
fun kotlin.random.Random.randLong(start: Long = 0, end: Long, step: Long = 1) = randomLong(start, end, step)

private fun randomLong(range: LongRange): Long = rand.asKotlinRandom().nextLong(range)

private fun randomLong(start: Long, end: Long, step: Long): Long {
    return rand.asKotlinRandom().nextLong((end + step - start) / step) * step + start
}

fun <T> kotlin.random.Random.choice(vararg numbers: T): T {
    val length = numbers.size
    return numbers[rand.nextInt(length)]
}

@JvmName("choiceArray")
fun <T> kotlin.random.Random.choice(array: Array<T>): T = choice(*array)

inline fun <reified T> kotlin.random.Random.choice(list: List<T>): T = choice(*list.toTypedArray())

inline fun <reified T> kotlin.random.Random.choice(set: Set<T>): T = choice(*set.toTypedArray())

inline fun <reified T, K> kotlin.random.Random.choice(map: Map<T, K>): Pair<T, K> {
    val choice = choice(map.keys)
    return Pair(choice, map[choice]!!)
}

inline fun <reified K, V> Map<K, V>.random() = kotlin.random.Random.choice(this)