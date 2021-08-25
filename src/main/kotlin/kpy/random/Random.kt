package kpy.random

import kotlin.random.Random

/*
* Random extensions method from python language
*
* author jakode
* since v3.0.0 08/26/2021
*/

/**
 * Gets the next random `Int` from the random number generator.
 *
 * @param start Start the range
 * @param end End of range
 * @param step range steps
 */
fun Random.nextInt(start: Int = 0, end: Int, step: Int = 1) =
    nextInt((end + step - start) / step) * step + start

/**
 * Gets the next random `Long` from the random number generator.
 *
 * @param start Start the range
 * @param end End of range
 * @param step range steps
 */
fun Random.nextLong(start: Long = 0, end: Long, step: Long = 1) =
    nextLong((end + step - start) / step) * step + start

/** Returns a random element from this vararg */
fun <T> Random.choice(vararg elements: T): T = elements[nextInt(elements.size)]

/** Returns a random element from this array */
@JvmName("choiceArray")
fun <T> Random.choice(array: Array<T>): T = array[nextInt(array.size)]

/** Returns a random element from this list */
fun <T> Random.choice(list: List<T>): T = list[nextInt(list.size)]

/** Returns a random element from this set */
inline fun <reified T> Random.choice(set: Set<T>): T = choice(*set.toTypedArray())

/** Returns a random element from this map */
inline fun <reified T, K> Random.choice(map: Map<T, K>): Pair<T, K> {
    val choice = choice(map.keys)
    return Pair(choice, map[choice]!!)
}

/** Returns a random element from this collection. */
inline fun <reified K, V> Map<K, V>.random() = Random.choice(this)

/**
 * Returns a list with the randomly selected element from the specified sequence
 * @param elements
 * @param weights Optional. A list were you can weigh the possibility for each value. Default null
 * @param length Optional. An integer defining the length of the returned list
 * @return random list
 */
fun <T> Random.choices(vararg elements: T, weights: List<Int>? = null, length: Int = 1): List<T> {
    val size = elements.size
    weights?.let { require(it.size == size) { "weights size must be equals to numbers size" } }
    val randoms = arrayListOf<T>()

    // select element with weight
    if (weights != null) {
        val random = RandomWeight(weights)
        repeat(length) {
            val index = random.pickIndex()
            randoms.add(elements[index])
        }
    } else {
        repeat(length) {
            randoms.add(Random.choice(elements))
        }
    }
    return randoms
}

/**
 * Returns a list with the randomly selected element from the specified sequence
 * @param array
 * @param weights Optional. A list were you can weigh the possibility for each value. Default null
 * @param length Optional. An integer defining the length of the returned list
 * @return random list
 */
@JvmName("choicesArray")
fun <T> Random.choices(array: Array<T>, weights: List<Int>? = null, length: Int = 1): List<T> =
    choices(*array, weights = weights, length = length)

/**
 * Returns a list with the randomly selected element from the specified sequence
 * @param list
 * @param weights Optional. A list were you can weigh the possibility for each value. Default null
 * @param length Optional. An integer defining the length of the returned list
 * @return random list
 */
inline fun <reified T> Random.choices(list: List<T>, weights: List<Int>? = null, length: Int = 1): List<T> =
    choices(*list.toTypedArray(), weights = weights, length = length)

/**
 * Returns a list with the randomly selected element from the specified sequence
 * @param set
 * @param weights Optional. A list were you can weigh the possibility for each value. Default null
 * @param length Optional. An integer defining the length of the returned list
 * @return random list
 */
inline fun <reified T> Random.choices(set: Set<T>, weights: List<Int>? = null, length: Int = 1): List<T> =
    choices(*set.toTypedArray(), weights = weights, length = length)