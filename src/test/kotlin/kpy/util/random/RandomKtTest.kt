package kpy.util.random

import kpy.util.log.Log
import org.hamcrest.MatcherAssert.assertThat
import org.hamcrest.Matchers.*
import org.junit.jupiter.api.Test
import kotlin.random.Random

class RandomKtTest {

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

    @Test
    fun `choices array`() {
        val randomList = Random.choices(arrayOf(1, 2, 3, 4, 5), weights = listOf(1, 1, 1, 1, 9), length = 20)
        Log.i("1 -> ${randomList.count { it == 1 }}", "CHOICES_ARRAY")
        Log.i("2 -> ${randomList.count { it == 2 }}", "CHOICES_ARRAY")
        Log.i("3 -> ${randomList.count { it == 3 }}", "CHOICES_ARRAY")
        Log.i("4 -> ${randomList.count { it == 4 }}", "CHOICES_ARRAY")
        Log.i("5 -> ${randomList.count { it == 5 }}", "CHOICES_ARRAY")

        assertThat(randomList, everyItem(`is`(`in`((listOf(1, 2, 3, 4, 5))))))
    }

    @Test
    fun `choices list`() {
        val randomList = Random.choices(listOf(1, 2, 3, 4, 5), weights = listOf(1, 1, 1, 1, 1), length = 10)
        Log.i("1 -> ${randomList.count { it == 1 }}", "CHOICES_ARRAY")
        Log.i("2 -> ${randomList.count { it == 2 }}", "CHOICES_ARRAY")
        Log.i("3 -> ${randomList.count { it == 3 }}", "CHOICES_ARRAY")
        Log.i("4 -> ${randomList.count { it == 4 }}", "CHOICES_ARRAY")
        Log.i("5 -> ${randomList.count { it == 5 }}", "CHOICES_ARRAY")

        assertThat(randomList, everyItem(`is`(`in`((listOf(1, 2, 3, 4, 5))))))
    }

    @Test
    fun `choices set`() {
        val randomList = Random.choices(setOf(1, 2, 3, 4, 5), weights = listOf(9, 3, 4, 6, 5), length = 5)
        Log.i("1 -> ${randomList.count { it == 1 }}", "CHOICES_ARRAY")
        Log.i("2 -> ${randomList.count { it == 2 }}", "CHOICES_ARRAY")
        Log.i("3 -> ${randomList.count { it == 3 }}", "CHOICES_ARRAY")
        Log.i("4 -> ${randomList.count { it == 4 }}", "CHOICES_ARRAY")
        Log.i("5 -> ${randomList.count { it == 5 }}", "CHOICES_ARRAY")

        assertThat(randomList, everyItem(`is`(`in`((listOf(1, 2, 3, 4, 5))))))
    }
}