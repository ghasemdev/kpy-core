package kpy.utils

import com.google.common.truth.Truth.assertThat
import org.junit.jupiter.api.Test
import java.util.*

class GenericsKtTest {

    @Test
    fun ifNull() {
        val value: String? = null
        val result = value.ifNull {
            print("$it : is null")
        }
        assertThat(result).isEqualTo(Unit)

        val value2 = "hello"
        val result2 = value2.ifNull {
            print("this is never print")
        }
        assertThat(result2).isEqualTo(value2)
    }

    @Test
    fun `ifNull with returns value`() {
        val value: String? = null
        val result = value.ifNull {
            print("$value : is null")
            "i am not null"
        }
        assertThat(result).isEqualTo("i am not null")

        val value2 = "hello"
        val result2 = value2.ifNull {
            print("this is never print")
            "i am not null"
        }
        assertThat(result2).isEqualTo(value2)
    }

    @Test
    fun ifNotNull() {
        val value: String? = null
        val result = value.ifNotNull {
            print("this is never print")
        }
        assertThat(result).isEqualTo(null)

        val value2 = "hello"
        val result2 = value2.ifNotNull {
            print("value is $value2")
        }
        assertThat(result2).isEqualTo(Unit)
    }

    @Test
    fun `ifNotNull with returns value`() {
        val value: String? = null
        val result = value.ifNotNull {
            print("this is never print")
            "i am not null"
        }
        assertThat(result).isEqualTo(null)

        val value2 = "hello"
        val result2 = value2.ifNotNull {
            print("value is $value2")
            "i am not null"
        }
        assertThat(result2).isEqualTo("i am not null")
    }

    @Test
    fun isNull() {
        val text: String? = null
        assertThat(text.isNull()).isTrue()

        val text2 = "hi"
        assertThat(text2.isNull()).isFalse()
    }

    @Test
    fun isNotNull() {
        val text: String? = null
        assertThat(text.isNotNull()).isFalse()

        val text2 = "hi"
        assertThat(text2.isNotNull()).isTrue()
    }

    @Test
    fun orZero() {
        val num = 5
        assertThat(num.orZero()).isEqualTo(5)

        val long: Long? = null
        assertThat(long.orZero()).isEqualTo(0L)

        val float: Float? = null
        assertThat(float.orZero()).isEqualTo(0F)

        val double: Double? = null
        assertThat(double.orZero()).isEqualTo(0.0)
    }

    @Test
    fun orDefault() {
        val date: Date? = null
        val now = Date()
        assertThat(date.orDefault(now)).isEqualTo(now)
    }

    @Test
    fun tryOrIgnore() {
        var num = 0
        tryOrIgnore {
            num = 22
            Exception("throw")
        }
        assertThat(num).isEqualTo(22)
    }
}