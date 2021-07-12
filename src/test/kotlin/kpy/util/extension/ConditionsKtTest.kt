package kpy.util.extension

import com.google.common.truth.Truth.assertThat
import org.junit.jupiter.api.Test

class ConditionsKtTest {

    @Test
    fun ifNull() {
        val value: String? = null
        val result = value.ifNull {
            print("$value : is null")
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
}