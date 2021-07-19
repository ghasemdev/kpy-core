package kpy.util.extension

import java.util.*
import kotlin.collections.ArrayDeque
import kotlin.collections.ArrayList
import kotlin.collections.HashSet
import kotlin.collections.LinkedHashSet

/*
* Collection builders & extension methods
*
* @author jakode
* @since v3.0.0 07/19/2021
*/

/**
 * Return a integer Array from range
 * @see Array
 */
fun arrayOf(range: IntRange): Array<Int> {
    val elements = range.toList()
    return if (elements.isNotEmpty()) elements.toTypedArray() else emptyArray()
}

/**
 * Return a long Array from range
 * @see Array
 */
fun arrayOf(range: LongRange): Array<Long> {
    val elements = range.toList()
    return if (elements.isNotEmpty()) elements.toTypedArray() else emptyArray()
}

/**
 * Return a integer List from range
 * @see List
 */
fun listOf(range: IntRange): List<Int> {
    val elements = range.toList()
    return elements.ifEmpty { emptyList() }
}

/**
 * Return a long List from range
 * @see List
 */
fun listOf(range: LongRange): List<Long> {
    val elements = range.toList()
    return elements.ifEmpty { emptyList() }
}

/**
 * Return a integer MutableList from range
 * @see MutableList
 */
fun mutableListOf(range: IntRange): MutableList<Int> {
    val elements = range.toMutableList()
    return elements.ifEmpty { mutableListOf() }
}

/**
 * Return a long MutableList from range
 * @see MutableList
 */
fun mutableListOf(range: LongRange): MutableList<Long> {
    val elements = range.toMutableList()
    return elements.ifEmpty { mutableListOf() }
}

/**
 * Return a integer Set from range
 * @see Set
 */
fun setOf(range: IntRange): Set<Int> {
    val elements = range.toSet()
    return elements.ifEmpty { emptySet() }
}

/**
 * Return a long Set from range
 * @see Set
 */
fun setOf(range: LongRange): Set<Long> {
    val elements = range.toSet()
    return elements.ifEmpty { emptySet() }
}

/**
 * Return a integer MutableSet from range
 * @see MutableSet
 */
fun mutableSetOf(range: IntRange): MutableSet<Int> {
    val elements = range.toMutableSet()
    return elements.ifEmpty { mutableSetOf() }
}

/**
 * Return a long MutableSet from range
 * @see MutableSet
 */
fun mutableSetOf(range: LongRange): MutableSet<Long> {
    val elements = range.toMutableSet()
    return elements.ifEmpty { mutableSetOf() }
}

/**
 * Return a integer HashSet from range
 * @see HashSet
 */
fun hashSetOf(range: IntRange): HashSet<Int> {
    val elements = range.toHashSet()
    return elements.ifEmpty { hashSetOf() }
}

/**
 * Return a long HashSet from range
 * @see HashSet
 */
fun hashSetOf(range: LongRange): HashSet<Long> {
    val elements = range.toHashSet()
    return elements.ifEmpty { hashSetOf() }
}

/**
 * Return a integer LinkedHashSet from range
 * @see LinkedHashSet
 */
fun linkedSetOf(range: IntRange): LinkedHashSet<Int> {
    val elements = LinkedHashSet(range.toList())
    return elements.ifEmpty { linkedSetOf() }
}

/**
 * Return a long LinkedHashSet from range
 * @see LinkedHashSet
 */
fun linkedSetOf(range: LongRange): LinkedHashSet<Long> {
    val elements = LinkedHashSet(range.toList())
    return elements.ifEmpty { linkedSetOf() }
}

/**
 * Return a integer SortedSet from range
 * @see SortedSet
 */
fun sortedSetOf(range: IntRange): SortedSet<Int> {
    val elements = range.toSortedSet()
    return elements.ifEmpty { sortedSetOf() }
}

/**
 * Return a long SortedSet from range
 * @see SortedSet
 */
fun sortedSetOf(range: LongRange): SortedSet<Long> {
    val elements = range.toSortedSet()
    return elements.ifEmpty { sortedSetOf() }
}

/**
 * Return a integer ArrayList from range
 * @see ArrayList
 */
fun arrayListOf(range: IntRange): ArrayList<Int> {
    val elements = ArrayList(range.toList())
    return elements.ifEmpty { arrayListOf() }
}

/**
 * Return a long ArrayList from range
 * @see ArrayList
 */
fun arrayListOf(range: LongRange): ArrayList<Long> {
    val elements = ArrayList(range.toList())
    return elements.ifEmpty { arrayListOf() }
}

/**
 * Return a linked list from elements
 * @see LinkedList
 */
fun <T> linkedListOf(vararg elements: T): LinkedList<T> =
    if (elements.isNotEmpty()) LinkedList(elements.toList()) else LinkedList()

/**
 * Return a integer linked list from range
 * @see LinkedList
 */
fun linkedListOf(range: IntRange): LinkedList<Int> {
    val elements = range.toList()
    return if (elements.isNotEmpty()) LinkedList(elements) else LinkedList()
}

/**
 * Return a long linked list from range
 * @see LinkedList
 */
fun linkedListOf(range: LongRange): LinkedList<Long> {
    val elements = range.toList()
    return if (elements.isNotEmpty()) LinkedList(elements) else LinkedList()
}

/**
 * Return a empty linked list
 * @see LinkedList
 */
fun <T> linkedListOf(): LinkedList<T> = LinkedList()

/**
 * Return a vector from elements
 * @see Vector
 */
fun <T> vectorOf(vararg elements: T): Vector<T> = if (elements.isNotEmpty()) Vector(elements.toList()) else Vector()

/**
 * Return a integer vector from range
 * @see Vector
 */
fun vectorOf(range: IntRange): Vector<Int> {
    val elements = range.toList()
    return if (elements.isNotEmpty()) Vector(elements) else Vector()
}

/**
 * Return a long vector from range
 * @see Vector
 */
fun vectorOf(range: LongRange): Vector<Long> {
    val elements = range.toList()
    return if (elements.isNotEmpty()) Vector(elements) else Vector()
}

/**
 * Return a empty vector
 * @see Vector
 * @param size default size is 10
 * @param incrementStep default step to increment size is zero
 */
fun <T> vectorOf(size: Int = 10, incrementStep: Int = 0): Vector<T> = Vector(size, incrementStep)

/**
 * Return a stack from elements
 * @see Stack
 */
fun <T> stackOf(vararg elements: T): Stack<T> =
    if (elements.isNotEmpty()) Stack<T>().also { it.addAll(elements.toList()) } else Stack()

/**
 * Return a integer stack from range
 * @see Stack
 */
fun stackOf(range: IntRange): Stack<Int> {
    val elements = range.toList()
    return if (elements.isNotEmpty()) Stack<Int>().also { it.addAll(elements) } else Stack()
}

/**
 * Return a long stack from range
 * @see Stack
 */
fun stackOf(range: LongRange): Stack<Long> {
    val elements = range.toList()
    return if (elements.isNotEmpty()) Stack<Long>().also { it.addAll(elements) } else Stack()
}

/**
 * Return a empty stack
 * @see Stack
 */
fun <T> stackOf(): Stack<T> = Stack()

/**
 * Return a queue from elements
 * @see Queue
 */
fun <T> queueOf(vararg elements: T): Queue<T> =
    if (elements.isNotEmpty()) LinkedList(elements.toList()) else LinkedList()

/**
 * Return a integer queue from range
 * @see Queue
 */
fun queueOf(range: IntRange): Queue<Int> {
    val elements = range.toList()
    return if (elements.isNotEmpty()) LinkedList(elements) else LinkedList()
}

/**
 * Return a long queue from range
 * @see Queue
 */
fun queueOf(range: LongRange): Queue<Long> {
    val elements = range.toList()
    return if (elements.isNotEmpty()) LinkedList(elements) else LinkedList()
}

/**
 * Return a empty queue
 * @see Queue
 */
fun <T> queueOf(): Queue<T> = LinkedList()

/**
 * Return a priority queue from elements
 * @see PriorityQueue
 */
fun <T> priorityQueueOf(vararg elements: T): PriorityQueue<T> =
    if (elements.isNotEmpty()) PriorityQueue(elements.toList()) else PriorityQueue()

/**
 * Return a integer priority queue from range
 * @see PriorityQueue
 */
fun priorityQueueOf(range: IntRange): PriorityQueue<Int> {
    val elements = range.toList()
    return if (elements.isNotEmpty()) PriorityQueue(elements) else PriorityQueue()
}

/**
 * Return a long priority queue from range
 * @see PriorityQueue
 */
fun priorityQueueOf(range: LongRange): PriorityQueue<Long> {
    val elements = range.toList()
    return if (elements.isNotEmpty()) PriorityQueue(elements) else PriorityQueue()
}

/**
 * Return a empty priority queue
 * @see PriorityQueue
 * @param comparator initiate queue order
 */
fun <T> priorityQueueOf(comparator: Comparator<T>? = null): PriorityQueue<T> =
    comparator?.let { PriorityQueue(comparator) } ?: PriorityQueue()

/**
 * Return a doubly queue from elements
 * @see Deque
 */
fun <T> dequeOf(vararg elements: T): Deque<T> =
    if (elements.isNotEmpty()) LinkedList(elements.toList()) else LinkedList()

/**
 * Return a integer doubly queue from range
 * @see Deque
 */
fun dequeOf(range: IntRange): Deque<Int> {
    val elements = range.toList()
    return if (elements.isNotEmpty()) LinkedList(elements) else LinkedList()
}

/**
 * Return a long doubly queue from range
 * @see Deque
 */
fun dequeOf(range: LongRange): Deque<Long> {
    val elements = range.toList()
    return if (elements.isNotEmpty()) LinkedList(elements) else LinkedList()
}

/**
 * Return a empty doubly queue
 * @see Deque
 */
fun <T> dequeOf(): Deque<T> = LinkedList()

/**
 * Return a array queue from elements
 * @see ArrayDeque
 */
fun <T> arrayDequeOf(vararg elements: T): ArrayDeque<T> =
    if (elements.isNotEmpty()) ArrayDeque(elements.toList()) else ArrayDeque()

/**
 * Return a integer array queue from range
 * @see ArrayDeque
 */
fun arrayDequeOf(range: IntRange): ArrayDeque<Int> {
    val elements = range.toList()
    return if (elements.isNotEmpty()) ArrayDeque(elements.toList()) else ArrayDeque()
}

/**
 * Return a long array queue from range
 * @see ArrayDeque
 */
fun arrayDequeOf(range: LongRange): ArrayDeque<Long> {
    val elements = range.toList()
    return if (elements.isNotEmpty()) ArrayDeque(elements.toList()) else ArrayDeque()
}

/**
 * Return a empty array queue
 * @see ArrayDeque
 */
fun <T> arrayDequeOf(): ArrayDeque<T> = ArrayDeque()

/**
 * Return a hash table from elements
 * @see Hashtable
 */
fun <T, K> hashTableOf(vararg elements: Pair<T, K>): Hashtable<T, K> =
    if (elements.isNotEmpty()) Hashtable(elements.toMap()) else Hashtable()

/**
 * Return a empty hash table
 * @see Hashtable
 */
fun <T, K> hashTableOf(): Hashtable<T, K> = Hashtable()

/**
 * Return head of the iterable
 * @param n number of elements return
 * @return sublist
 */
fun <T> Iterable<T>.head(n: Int = 10): List<T> = this.take(n)

/**
 * Return head of the array
 * @param n number of elements return
 * @return sublist
 */
fun <T> Array<out T>.head(n: Int = 10): List<T> = this.take(n)

/**
 * Return tail of the iterable
 * @param n number of elements return
 * @return sublist
 */
fun <T> Iterable<T>.tail(n: Int = 10): List<T> {
    val length = this.count() - n
    return this.drop(if (length < 0) 0 else length)
}

/**
 * Return tail of the array
 * @param n number of elements return
 * @return sublist
 */
fun <T> Array<out T>.tail(n: Int = 10): List<T> {
    val length = this.size - n
    return this.drop(if (length < 0) 0 else length)
}

/**
 * finds two numbers inside the [Iterable] whose sum is equal to the [sum] variable
 * ```
 * list(..., x, ..., y, ...)
 * x + y = sum
 * ```
 */
fun Iterable<Int>.findPairOfSum(sum: Int): Pair<Int, Int>? {
    val complements = associateBy { sum - it }
    return firstNotNullOfOrNull { number ->
        val complement = complements[number]
        complement?.let { Pair(number, complement) }
    }
}

/**
 * finds two numbers inside the [Iterable] whose sum is equal to the [sum] variable
 * ```
 * list(..., x, ..., y, ...)
 * x + y = sum
 * ```
 */
fun Iterable<Long>.findPairOfSum(sum: Long): Pair<Long, Long>? {
    val complements = associateBy { sum - it }
    return firstNotNullOfOrNull { number ->
        val complement = complements[number]
        complement?.let { Pair(number, complement) }
    }
}

/**
 * finds two numbers inside the [Iterable] whose sum is equal to the [sum] variable
 * ```
 * list(..., x, ..., y, ...)
 * x + y = sum
 * ```
 */
fun Iterable<Float>.findPairOfSum(sum: Float): Pair<Float, Float>? {
    val complements = associateBy { sum - it }
    return firstNotNullOfOrNull { number ->
        val complement = complements[number]
        complement?.let { Pair(number, complement) }
    }
}

/**
 * finds two numbers inside the [Iterable] whose sum is equal to the [sum] variable
 * ```
 * list(..., x, ..., y, ...)
 * x + y = sum
 * ```
 */
fun Iterable<Double>.findPairOfSum(sum: Double): Pair<Double, Double>? {
    val complements = associateBy { sum - it }
    return firstNotNullOfOrNull { number ->
        val complement = complements[number]
        complement?.let { Pair(number, complement) }
    }
}

/**
 * finds two numbers inside the [Array] whose sum is equal to the [sum] variable
 * ```
 * list(..., x, ..., y, ...)
 * x + y = sum
 * ```
 */
fun Array<Int>.findPairOfSum(sum: Int): Pair<Int, Int>? {
    val complements = associateBy { sum - it }
    return firstNotNullOfOrNull { number ->
        val complement = complements[number]
        complement?.let { Pair(number, complement) }
    }
}

/**
 * finds two numbers inside the [Array] whose sum is equal to the [sum] variable
 * ```
 * list(..., x, ..., y, ...)
 * x + y = sum
 * ```
 */
fun Array<Long>.findPairOfSum(sum: Long): Pair<Long, Long>? {
    val complements = associateBy { sum - it }
    return firstNotNullOfOrNull { number ->
        val complement = complements[number]
        complement?.let { Pair(number, complement) }
    }
}

/**
 * finds two numbers inside the [Array] whose sum is equal to the [sum] variable
 * ```
 * list(..., x, ..., y, ...)
 * x + y = sum
 * ```
 */
fun Array<Float>.findPairOfSum(sum: Float): Pair<Float, Float>? {
    val complements = associateBy { sum - it }
    return firstNotNullOfOrNull { number ->
        val complement = complements[number]
        complement?.let { Pair(number, complement) }
    }
}

/**
 * finds two numbers inside the [Array] whose sum is equal to the [sum] variable
 * ```
 * list(..., x, ..., y, ...)
 * x + y = sum
 * ```
 */
fun Array<Double>.findPairOfSum(sum: Double): Pair<Double, Double>? {
    val complements = associateBy { sum - it }
    return firstNotNullOfOrNull { number ->
        val complement = complements[number]
        complement?.let { Pair(number, complement) }
    }
}

/**
 * finds tree numbers inside the [Iterable] whose sum is equal to the [sum] variable
 * ```
 * list(..., x, ..., y, ..., z)
 * x + y + z = sum
 * ```
 */
fun Iterable<Int>.findTripleOfSum(sum: Int): Triple<Int, Int, Int>? {
    return firstNotNullOfOrNull { x ->
        // x -> (y, z) where y + z = sum - x
        val pair = findPairOfSum(sum - x)
        pair?.let { Triple(x, pair.first, pair.second) }
    }
}

/**
 * finds tree numbers inside the [Iterable] whose sum is equal to the [sum] variable
 * ```
 * list(..., x, ..., y, ..., z)
 * x + y + z = sum
 * ```
 */
fun Iterable<Long>.findTripleOfSum(sum: Long): Triple<Long, Long, Long>? {
    return firstNotNullOfOrNull { x ->
        // x -> (y, z) where y + z = sum - x
        val pair = findPairOfSum(sum - x)
        pair?.let { Triple(x, pair.first, pair.second) }
    }
}

/**
 * finds tree numbers inside the [Iterable] whose sum is equal to the [sum] variable
 * ```
 * list(..., x, ..., y, ..., z)
 * x + y + z = sum
 * ```
 */
fun Iterable<Float>.findTripleOfSum(sum: Float): Triple<Float, Float, Float>? {
    return firstNotNullOfOrNull { x ->
        // x -> (y, z) where y + z = sum - x
        val pair = findPairOfSum(sum - x)
        pair?.let { Triple(x, pair.first, pair.second) }
    }
}

/**
 * finds tree numbers inside the [Iterable] whose sum is equal to the [sum] variable
 * ```
 * list(..., x, ..., y, ..., z)
 * x + y + z = sum
 * ```
 */
fun Iterable<Double>.findTripleOfSum(sum: Double): Triple<Double, Double, Double>? {
    return firstNotNullOfOrNull { x ->
        // x -> (y, z) where y + z = sum - x
        val pair = findPairOfSum(sum - x)
        pair?.let { Triple(x, pair.first, pair.second) }
    }
}

/**
 * finds tree numbers inside the [Array] whose sum is equal to the [sum] variable
 * ```
 * list(..., x, ..., y, ..., z)
 * x + y + z = sum
 * ```
 */
fun Array<Int>.findTripleOfSum(sum: Int): Triple<Int, Int, Int>? {
    return firstNotNullOfOrNull { x ->
        // x -> (y, z) where y + z = sum - x
        val pair = findPairOfSum(sum - x)
        pair?.let { Triple(x, pair.first, pair.second) }
    }
}

/**
 * finds tree numbers inside the [Array] whose sum is equal to the [sum] variable
 * ```
 * list(..., x, ..., y, ..., z)
 * x + y + z = sum
 * ```
 */
fun Array<Long>.findTripleOfSum(sum: Long): Triple<Long, Long, Long>? {
    return firstNotNullOfOrNull { x ->
        // x -> (y, z) where y + z = sum - x
        val pair = findPairOfSum(sum - x)
        pair?.let { Triple(x, pair.first, pair.second) }
    }
}

/**
 * finds tree numbers inside the [Array] whose sum is equal to the [sum] variable
 * ```
 * list(..., x, ..., y, ..., z)
 * x + y + z = sum
 * ```
 */
fun Array<Float>.findTripleOfSum(sum: Float): Triple<Float, Float, Float>? {
    return firstNotNullOfOrNull { x ->
        // x -> (y, z) where y + z = sum - x
        val pair = findPairOfSum(sum - x)
        pair?.let { Triple(x, pair.first, pair.second) }
    }
}

/**
 * finds tree numbers inside the [Array] whose sum is equal to the [sum] variable
 * ```
 * list(..., x, ..., y, ..., z)
 * x + y + z = sum
 * ```
 */
fun Array<Double>.findTripleOfSum(sum: Double): Triple<Double, Double, Double>? {
    return firstNotNullOfOrNull { x ->
        // x -> (y, z) where y + z = sum - x
        val pair = findPairOfSum(sum - x)
        pair?.let { Triple(x, pair.first, pair.second) }
    }
}