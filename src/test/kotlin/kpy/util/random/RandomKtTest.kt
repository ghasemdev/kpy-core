package kpy.util.random

import org.hamcrest.MatcherAssert.assertThat
import org.hamcrest.Matchers.*
import org.junit.jupiter.api.Test
import kotlin.random.Random

class RandomKtTest {

    @Test
    fun randInt() {
        val number = Random.randInt(0..100)
        assertThat(number, `in`((0..100).toList()))
    }

    @Test
    fun randLong() {
        val number = Random.randLong(0..100L)
        assertThat(number, `in`((0..100L).toList()))
    }

    @Test
    fun `choice array`() {
        val array = arrayOf(1, 2, 3, 4, 5)
        val number = Random.choice(array)
        assertThat(number, `in`(array))
    }

    @Test
    fun `choice list`() {
        val list = listOf(1, 2, 3, 4, 5)
        val number = Random.choice(list)
        assertThat(number, `in`(list))
    }

    @Test
    fun `choice set`() {
        val set = setOf(1, 2, 3, 4, 5)
        val number = Random.choice(set)
        assertThat(number, `in`(set))
    }

    @Test
    fun `choice map`() {
        val map = mapOf(1 to 1, 2 to 2, 3 to 3, 4 to 4, 5 to 5)
        val number = Random.choice(map)
        assertThat(number.first, `in`(map.keys))
    }
}