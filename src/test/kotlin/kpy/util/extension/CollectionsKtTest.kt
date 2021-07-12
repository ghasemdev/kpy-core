package kpy.util.extension

import com.google.common.truth.Truth.assertThat
import org.junit.jupiter.api.Test

class CollectionsKtTest {

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
    fun testVectorOf() {
        val vector = vectorOf(1, 2, 3, 4, 5, 6)
        assertThat(vector.size).isEqualTo(6)
        assertThat(vector.toList()).isEqualTo(listOf(1, 2, 3, 4, 5, 6))
        assertThat(vector[0]).isEqualTo(1)
        vector.add(10)
        assertThat(vector.last()).isEqualTo(10)
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
}