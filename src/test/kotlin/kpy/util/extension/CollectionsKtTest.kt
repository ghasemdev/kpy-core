package kpy.util.extension

import com.google.common.truth.Truth.assertThat
import org.junit.jupiter.api.Test

class CollectionsKtTest {

    @Test
    fun `build array from range`() {
        val intArray = arrayOf(1..10)
        assertThat(intArray.size).isEqualTo(10)

        val longArray = arrayOf(1..10L)
        assertThat(longArray.size).isEqualTo(10)
    }

    @Test
    fun `build list from range`() {
        val intList = listOf(1..10)
        assertThat(intList.size).isEqualTo(10)

        val longList = listOf(1..10L)
        assertThat(longList.size).isEqualTo(10)
    }

    @Test
    fun `build mutable list from range`() {
        val intMutableList = mutableListOf(1..10)
        assertThat(intMutableList.size).isEqualTo(10)

        val longMutableList = mutableListOf(1..10L)
        assertThat(longMutableList.size).isEqualTo(10)
    }

    @Test
    fun `build set from range`() {
        val intSet = setOf(1..10)
        assertThat(intSet.size).isEqualTo(10)

        val longSet = setOf(1..10L)
        assertThat(longSet.size).isEqualTo(10)
    }

    @Test
    fun `build mutable set from range`() {
        val intMutableSet = mutableSetOf(1..10)
        assertThat(intMutableSet.size).isEqualTo(10)

        val longMutableSet = mutableSetOf(1..10L)
        assertThat(longMutableSet.size).isEqualTo(10)
    }

    @Test
    fun `build hash set from range`() {
        val intHashSet = hashSetOf(1..10)
        assertThat(intHashSet.size).isEqualTo(10)

        val longHashSet = hashSetOf(1..10L)
        assertThat(longHashSet.size).isEqualTo(10)
    }

    @Test
    fun `build linked set from range`() {
        val intLinkedSet = linkedSetOf(1..10)
        assertThat(intLinkedSet.size).isEqualTo(10)

        val longLinkedSet = linkedSetOf(1..10L)
        assertThat(longLinkedSet.size).isEqualTo(10)
    }

    @Test
    fun `build sorted set from range`() {
        val intSortedSet = sortedSetOf(1..10)
        assertThat(intSortedSet.size).isEqualTo(10)

        val longSortedSet = sortedSetOf(1..10L)
        assertThat(longSortedSet.size).isEqualTo(10)
    }

    @Test
    fun `build array list from range`() {
        val intArrayList = arrayListOf(1..10)
        assertThat(intArrayList.size).isEqualTo(10)

        val longArrayList = arrayListOf(1..10L)
        assertThat(longArrayList.size).isEqualTo(10)
    }

    @Test
    fun testLinkedListOf() {
        val linklist = linkedListOf(1, 2, 3, 4, 5, 6)
        assertThat(linklist.size).isEqualTo(6)
        assertThat(linklist).isEqualTo(listOf(1, 2, 3, 4, 5, 6))
        assertThat(linklist.pop()).isEqualTo(1)
        assertThat(linklist.peek()).isEqualTo(2)
        linklist.push(4)
        assertThat(linklist.peek()).isEqualTo(4)
        assertThat(linklist.poll()).isEqualTo(4)
        assertThat(linklist[0]).isEqualTo(2)
        linklist.add(2, 20)
        assertThat(linklist[2]).isEqualTo(20)
        assertThat(linklist[0]).isEqualTo(2)
    }

    @Test
    fun `build linked list from range`() {
        val intLinkedList = linkedListOf(1..10)
        assertThat(intLinkedList.size).isEqualTo(10)

        val longLinkedList = linkedListOf(1..10L)
        assertThat(longLinkedList.size).isEqualTo(10)
    }

    @Test
    fun testVectorOf() {
        val vector = vectorOf(1, 2, 3, 4, 5, 6)
        assertThat(vector.size).isEqualTo(6)
        assertThat(vector.toList()).isEqualTo(listOf(1, 2, 3, 4, 5, 6))
        assertThat(vector[0]).isEqualTo(1)
        vector.add(10)
        assertThat(vector.last()).isEqualTo(10)
    }

    @Test
    fun `build vector from range`() {
        val intVector = vectorOf(1..10)
        assertThat(intVector.size).isEqualTo(10)

        val longVector = vectorOf(1..10L)
        assertThat(longVector.size).isEqualTo(10)
    }

    @Test
    fun testStackOf() {
        val stack = stackOf(1, 2, 3, 4, 5, 6)
        assertThat(stack.size).isEqualTo(6)
        assertThat(stack.toList()).isEqualTo(listOf(1, 2, 3, 4, 5, 6))
        assertThat(stack.pop()).isEqualTo(6)
        assertThat(stack.peek()).isEqualTo(5)
        stack.push(4)
        assertThat(stack.peek()).isEqualTo(4)
    }

    @Test
    fun `build stack from range`() {
        val intStack = stackOf(1..10)
        assertThat(intStack.size).isEqualTo(10)

        val longStack = stackOf(1..10L)
        assertThat(longStack.size).isEqualTo(10)
    }

    @Test
    fun testQueueOf() {
        val queue = queueOf(1, 2, 3, 4, 5, 6)
        assertThat(queue.size).isEqualTo(6)
        assertThat(queue.toList()).isEqualTo(listOf(1, 2, 3, 4, 5, 6))
        assertThat(queue.poll()).isEqualTo(1)
        assertThat(queue.peek()).isEqualTo(2)
        queue.add(4)
        assertThat(queue.peek()).isEqualTo(2)
        assertThat(queue.poll()).isEqualTo(2)
    }

    @Test
    fun `build queue from range`() {
        val intQueue = queueOf(1..10)
        assertThat(intQueue.size).isEqualTo(10)

        val longQueue = queueOf(1..10L)
        assertThat(longQueue.size).isEqualTo(10)
    }

    @Test
    fun testPriorityQueueOf() {
        val pQueue = priorityQueueOf(2, 3, 6, 5, 9, 8, 4, 7)
        assertThat(pQueue.size).isEqualTo(8)
        assertThat(pQueue.toList()).isEqualTo(listOf(2, 3, 4, 5, 9, 8, 6, 7))
        assertThat(pQueue.poll()).isEqualTo(2)
        assertThat(pQueue.peek()).isEqualTo(3)
        pQueue.add(4)
        assertThat(pQueue.peek()).isEqualTo(3)
        assertThat(pQueue.poll()).isEqualTo(3)
    }

    @Test
    fun `build priority queue from range`() {
        val intPriorityQueue = priorityQueueOf(1..10)
        assertThat(intPriorityQueue.size).isEqualTo(10)

        val longPriorityQueue = priorityQueueOf(1..10L)
        assertThat(longPriorityQueue.size).isEqualTo(10)
    }

    @Test
    fun testDequeOf() {
        val deque = dequeOf(1, 2, 3, 4, 5, 6)
        assertThat(deque.size).isEqualTo(6)
        assertThat(deque).isEqualTo(listOf(1, 2, 3, 4, 5, 6))
        assertThat(deque.pop()).isEqualTo(1)
        assertThat(deque.peek()).isEqualTo(2)
        deque.push(4)
        assertThat(deque.peek()).isEqualTo(4)
        assertThat(deque.poll()).isEqualTo(4)
        assertThat(deque.first).isEqualTo(2)
        assertThat(deque.last).isEqualTo(6)
        assertThat(deque.removeFirst()).isEqualTo(2)
        assertThat(deque.removeLast()).isEqualTo(6)
        deque.addFirst(14)
        deque.addLast(14)
        assertThat(deque.first).isEqualTo(14)
        assertThat(deque.last).isEqualTo(14)
    }

    @Test
    fun `build deque from range`() {
        val intDeque = dequeOf(1..10)
        assertThat(intDeque.size).isEqualTo(10)

        val longDeque = dequeOf(1..10L)
        assertThat(longDeque.size).isEqualTo(10)
    }

    @Test
    fun testArrayDequeOf() {
        val arrayDeque = arrayDequeOf(1, 2, 3, 4, 5, 6)
        assertThat(arrayDeque.size).isEqualTo(6)
        assertThat(arrayDeque).isEqualTo(listOf(1, 2, 3, 4, 5, 6))
        assertThat(arrayDeque[0]).isEqualTo(1)
        arrayDeque.removeFirst()
        assertThat(arrayDeque.first()).isEqualTo(2)
        assertThat(arrayDeque.last()).isEqualTo(6)
        assertThat(arrayDeque.removeFirst()).isEqualTo(2)
        assertThat(arrayDeque.removeLast()).isEqualTo(6)
        arrayDeque.addFirst(14)
        arrayDeque.addLast(14)
        assertThat(arrayDeque.first()).isEqualTo(14)
        assertThat(arrayDeque.last()).isEqualTo(14)
    }

    @Test
    fun `build array deque from range`() {
        val intArrayDequeOf = arrayDequeOf(1..10)
        assertThat(intArrayDequeOf.size).isEqualTo(10)

        val longArrayDequeOf = arrayDequeOf(1..10L)
        assertThat(longArrayDequeOf.size).isEqualTo(10)
    }

    @Test
    fun testHashTableOf() {
        val hashTable = hashTableOf(1 to 1, 2 to 2, 3 to 3, 4 to 4, 5 to 5, 6 to 6)
        assertThat(hashTable.size).isEqualTo(6)
        assertThat(hashTable.toList()).isEqualTo(listOf(1 to 1, 2 to 2, 3 to 3, 4 to 4, 5 to 5, 6 to 6).reversed())
        assertThat(hashTable[5]).isEqualTo(5)
        hashTable[7] = 9
        assertThat(hashTable[7]).isEqualTo(9)
    }

    @Test
    fun testHead() {
        val list = listOf(1, 2, 3, 4, 5, 6, 7, 8, 9)
        assertThat(list.head(6)).isEqualTo(listOf(1, 2, 3, 4, 5, 6))

        val array = arrayOf(1, 2, 3, 4, 5, 6, 7, 8, 9)
        assertThat(array.head(6)).isEqualTo(listOf(1, 2, 3, 4, 5, 6))

        val set = setOf(1, 2, 3, 4, 5, 6, 7, 8, 9)
        assertThat(set.head(6)).isEqualTo(listOf(1, 2, 3, 4, 5, 6))
    }

    @Test
    fun testTail() {
        val list = listOf(1, 2, 3, 4, 5, 6, 7, 8, 9)
        assertThat(list.tail(6)).isEqualTo(listOf(4, 5, 6, 7, 8, 9))

        val array = arrayOf(1, 2, 3, 4, 5, 6, 7, 8, 9)
        assertThat(array.tail(6)).isEqualTo(listOf(4, 5, 6, 7, 8, 9))

        val set = setOf(1, 2, 3, 4, 5, 6, 7, 8, 9)
        assertThat(set.tail(6)).isEqualTo(listOf(4, 5, 6, 7, 8, 9))
    }

    @Test
    fun `find pair of sum int`() {
        val numbers1 = listOf(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)
        val pair1 = numbers1.findPairOfSum(10)
        pair1?.let { (x, y) -> assertThat(x + y).isEqualTo(10) }

        val numbers2 = arrayOf(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)
        val pair2 = numbers2.findPairOfSum(10)
        pair2?.let { (x, y) -> assertThat(x + y).isEqualTo(10) }
    }

    @Test
    fun `find pair of sum long`() {
        val numbers1 = listOf(1L, 2L, 3L, 4L, 5L, 6L, 7L, 8L, 9L, 10L)
        val pair1 = numbers1.findPairOfSum(10L)
        pair1?.let { (x, y) -> assertThat(x + y).isEqualTo(10L) }

        val numbers2 = listOf(1L, 2L, 3L, 4L, 5L, 6L, 7L, 8L, 9L, 10L)
        val pair2 = numbers2.findPairOfSum(10L)
        pair2?.let { (x, y) -> assertThat(x + y).isEqualTo(10L) }
    }

    @Test
    fun `find pair of sum float`() {
        val numbers1 = listOf(1F, 2F, 3F, 4.7F, 5F, 6F, 7F, 8F, 9F, 10F)
        val pair1 = numbers1.findPairOfSum(10.7F)
        pair1?.let { (x, y) -> assertThat(x + y).isEqualTo(10.7F) }

        val numbers2 = listOf(1F, 2F, 3F, 4.7F, 5F, 6F, 7F, 8F, 9F, 10F)
        val pair2 = numbers2.findPairOfSum(10.7F)
        pair2?.let { (x, y) -> assertThat(x + y).isEqualTo(10.7F) }
    }

    @Test
    fun `find pair of sum double`() {
        val numbers1 = listOf(1.0, 2.0, 3.0, 4.7, 5.0, 6.0, 7.0, 8.0, 9.0, 10.0)
        val pair1 = numbers1.findPairOfSum(10.7)
        pair1?.let { (x, y) -> assertThat(x + y).isEqualTo(10.7) }

        val numbers2 = listOf(1.0, 2.0, 3.0, 4.7, 5.0, 6.0, 7.0, 8.0, 9.0, 10.0)
        val pair2 = numbers2.findPairOfSum(10.7)
        pair2?.let { (x, y) -> assertThat(x + y).isEqualTo(10.7) }
    }

    @Test
    fun `find triple of sum int`() {
        val numbers1 = listOf(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)
        val triple1 = numbers1.findTripleOfSum(10)
        triple1?.let { (x, y, z) -> assertThat(x + y + z).isEqualTo(10) }

        val numbers2 = arrayOf(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)
        val triple2 = numbers2.findTripleOfSum(10)
        triple2?.let { (x, y, z) -> assertThat(x + y + z).isEqualTo(10) }
    }

    @Test
    fun `find triple of sum long`() {
        val numbers1 = listOf(1L, 2L, 3L, 4L, 5L, 6L, 7L, 8L, 9L, 10L)
        val triple1 = numbers1.findTripleOfSum(10L)
        triple1?.let { (x, y, z) -> assertThat(x + y + z).isEqualTo(10L) }

        val numbers2 = listOf(1L, 2L, 3L, 4L, 5L, 6L, 7L, 8L, 9L, 10L)
        val triple2 = numbers2.findTripleOfSum(10L)
        triple2?.let { (x, y, z) -> assertThat(x + y + z).isEqualTo(10L) }
    }

    @Test
    fun `find triple of sum float`() {
        val numbers1 = listOf(1F, 2F, 3F, 4.7F, 5F, 6F, 7F, 8F, 9F, 10F)
        val triple1 = numbers1.findTripleOfSum(10.7F)
        triple1?.let { (x, y, z) -> assertThat(x + y + z).isEqualTo(10.7F) }

        val numbers2 = listOf(1F, 2F, 3F, 4.7F, 5F, 6F, 7F, 8F, 9F, 10F)
        val triple2 = numbers2.findTripleOfSum(10.7F)
        triple2?.let { (x, y, z) -> assertThat(x + y + z).isEqualTo(10.7F) }
    }

    @Test
    fun `find triple of sum double`() {
        val numbers1 = listOf(1.0, 2.0, 3.0, 4.7, 5.0, 6.0, 7.0, 8.0, 9.0, 10.0)
        val triple1 = numbers1.findTripleOfSum(10.7)
        triple1?.let { (x, y, z) -> assertThat(x + y + z).isEqualTo(10.7) }

        val numbers2 = listOf(1.0, 2.0, 3.0, 4.7, 5.0, 6.0, 7.0, 8.0, 9.0, 10.0)
        val triple2 = numbers2.findTripleOfSum(10.7)
        triple2?.let { (x, y, z) -> assertThat(x + y + z).isEqualTo(10.7) }
    }

    @Test
    fun `refresh list`() {
        val arrayList = arrayListOf(1..10)
        assertThat(arrayList.refreshList(listOf(20..30))).isEqualTo(listOf(20..30))

        val mutableList = mutableListOf(1..10)
        assertThat(mutableList.refreshList(listOf(20..30))).isEqualTo(listOf(20..30))
    }

    @Test
    fun `add new items`() {
        val arrayList = arrayListOf(1..10)
        assertThat(arrayList.addNewItems(listOf(11..30))).isEqualTo(listOf(1..30))

        val mutableList = mutableListOf(1..10)
        assertThat(mutableList.addNewItems(listOf(11..30))).isEqualTo(listOf(1..30))
    }
}