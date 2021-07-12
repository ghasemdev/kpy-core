package kpy.util.extension

import com.google.common.truth.Truth.assertThat
import org.junit.jupiter.api.Test

class MathKtTest {

    @Test
    fun isOdd() {
        assertThat(isOdd(5)).isTrue()
        assertThat(isOdd(0)).isFalse()
    }

    @Test
    fun isEven() {
        assertThat(isEven(5)).isFalse()
        assertThat(isEven(0)).isTrue()
    }
}