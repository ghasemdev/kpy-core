package kpy.util.extension

import java.util.*
import kotlin.collections.ArrayDeque

/*
* Collection builders & extension methods
*
* @author jakode
* @since v3.1.0 07/22/2021
*/

/**
 * Return an integer Array from range
 * @see Array
 */
fun arrayOf(range: IntRange): Array<Int> = range.toList().toTypedArray()

/**
 * Return a long Array from range
 * @see Array
 */
fun arrayOf(range: LongRange): Array<Long> = range.toList().toTypedArray()

/**
 * Return an integer List from range
 * @see List
 */
fun listOf(range: IntRange): List<Int> = range.toList()

/**
 * Return a long List from range
 * @see List
 */
fun listOf(range: LongRange): List<Long> = range.toList()

/**
 * Return an integer MutableList from range
 * @see MutableList
 */
fun mutableListOf(range: IntRange): MutableList<Int> = range.toMutableList()

/**
 * Return a long MutableList from range
 * @see MutableList
 */
fun mutableListOf(range: LongRange): MutableList<Long> = range.toMutableList()

/**
 * Return an integer Set from range
 * @see Set
 */
fun setOf(range: IntRange): Set<Int> = range.toSet()

/**
 * Return a long Set from range
 * @see Set
 */
fun setOf(range: LongRange): Set<Long> = range.toSet()

/**
 * Return an integer MutableSet from range
 * @see MutableSet
 */
fun mutableSetOf(range: IntRange): MutableSet<Int> = range.toMutableSet()

/**
 * Return a long MutableSet from range
 * @see MutableSet
 */
fun mutableSetOf(range: LongRange): MutableSet<Long> = range.toMutableSet()

/**
 * Return an integer HashSet from range
 * @see HashSet
 */
fun hashSetOf(range: IntRange): HashSet<Int> = range.toHashSet()

/**
 * Return a long HashSet from range
 * @see HashSet
 */
fun hashSetOf(range: LongRange): HashSet<Long> = range.toHashSet()

/**
 * Return an integer LinkedHashSet from range
 * @see LinkedHashSet
 */
fun linkedSetOf(range: IntRange): LinkedHashSet<Int> = LinkedHashSet(range.toList())

/**
 * Return a long LinkedHashSet from range
 * @see LinkedHashSet
 */
fun linkedSetOf(range: LongRange): LinkedHashSet<Long> = LinkedHashSet(range.toList())

/**
 * Return an integer SortedSet from range
 * @see SortedSet
 */
fun sortedSetOf(range: IntRange): SortedSet<Int> = range.toSortedSet()

/**
 * Return a long SortedSet from range
 * @see SortedSet
 */
fun sortedSetOf(range: LongRange): SortedSet<Long> = range.toSortedSet()

/**
 * Return an integer ArrayList from range
 * @see ArrayList
 */
fun arrayListOf(range: IntRange): ArrayList<Int> = ArrayList(range.toList())

/**
 * Return a long ArrayList from range
 * @see ArrayList
 */
fun arrayListOf(range: LongRange): ArrayList<Long> = ArrayList(range.toList())

/**
 * Return a linked list from elements
 * @see LinkedList
 */
fun <T> linkedListOf(vararg elements: T): LinkedList<T> =
    if (elements.isNotEmpty()) LinkedList(elements.toList()) else LinkedList()

/**
 * Return an integer linked list from range
 * @see LinkedList
 */
fun linkedListOf(range: IntRange): LinkedList<Int> = LinkedList(range.toList())

/**
 * Return a long linked list from range
 * @see LinkedList
 */
fun linkedListOf(range: LongRange): LinkedList<Long> = LinkedList(range.toList())

/**
 * Return an empty linked list
 * @see LinkedList
 */
fun <T> linkedListOf(): LinkedList<T> = LinkedList()

/**
 * Return a vector from elements
 * @see Vector
 */
fun <T> vectorOf(vararg elements: T): Vector<T> = if (elements.isNotEmpty()) Vector(elements.toList()) else Vector()

/**
 * Return an integer vector from range
 * @see Vector
 */
fun vectorOf(range: IntRange): Vector<Int> = Vector(range.toList())

/**
 * Return a long vector from range
 * @see Vector
 */
fun vectorOf(range: LongRange): Vector<Long> = Vector(range.toList())

/**
 * Return an empty vector
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
 * Return an integer stack from range
 * @see Stack
 */
fun stackOf(range: IntRange): Stack<Int> = Stack<Int>().also { it.addAll(range.toList()) }

/**
 * Return a long stack from range
 * @see Stack
 */
fun stackOf(range: LongRange): Stack<Long> = Stack<Long>().also { it.addAll(range.toList()) }

/**
 * Return an empty stack
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
 * Return an integer queue from range
 * @see Queue
 */
fun queueOf(range: IntRange): Queue<Int> = LinkedList(range.toList())

/**
 * Return a long queue from range
 * @see Queue
 */
fun queueOf(range: LongRange): Queue<Long> = LinkedList(range.toList())

/**
 * Return an empty queue
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
 * Return an integer priority queue from range
 * @see PriorityQueue
 */
fun priorityQueueOf(range: IntRange): PriorityQueue<Int> = PriorityQueue(range.toList())

/**
 * Return a long priority queue from range
 * @see PriorityQueue
 */
fun priorityQueueOf(range: LongRange): PriorityQueue<Long> = PriorityQueue(range.toList())

/**
 * Return an empty priority queue
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
 * Return an integer doubly queue from range
 * @see Deque
 */
fun dequeOf(range: IntRange): Deque<Int> = LinkedList(range.toList())

/**
 * Return a long doubly queue from range
 * @see Deque
 */
fun dequeOf(range: LongRange): Deque<Long> = LinkedList(range.toList())

/**
 * Return an empty doubly queue
 * @see Deque
 */
fun <T> dequeOf(): Deque<T> = LinkedList()

/**
 * Return an array queue from elements
 * @see ArrayDeque
 */
fun <T> arrayDequeOf(vararg elements: T): ArrayDeque<T> =
    if (elements.isNotEmpty()) ArrayDeque(elements.toList()) else ArrayDeque()

/**
 * Return an integer array queue from range
 * @see ArrayDeque
 */
fun arrayDequeOf(range: IntRange): ArrayDeque<Int> = ArrayDeque(range.toList())

/**
 * Return a long array queue from range
 * @see ArrayDeque
 */
fun arrayDequeOf(range: LongRange): ArrayDeque<Long> = ArrayDeque(range.toList())

/**
 * Return an empty array queue
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
 * Return an empty hash table
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

/**
 * Refresh a list with clearing and add items
 * @param items
 * @return array list
 */
fun <T> MutableList<T>.refreshList(items: List<T>): MutableList<T> {
    this.clear()
    this.addAll(items)
    return this
}

/**
 * Refresh a list with clearing and add items
 * @param items
 * @return array list
 */
fun <T> ArrayList<T>.refreshList(items: List<T>): ArrayList<T> {
    this.clear()
    this.addAll(items)
    return this
}

/**
 * Add new items to list
 * @param items
 * @return array list
 */
fun <T> MutableList<T>.addNewItems(items: List<T>): MutableList<T> {
    items.forEach { if (!this.contains(it)) this.add(it) }
    return this
}

/**
 * Add new items to list
 * @param items
 * @return array list
 */
fun <T> ArrayList<T>.addNewItems(items: List<T>): ArrayList<T> {
    items.forEach { if (!this.contains(it)) this.add(it) }
    return this
}