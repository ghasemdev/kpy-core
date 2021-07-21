package kpy.util.extension

import com.google.common.truth.Truth.assertThat
import org.junit.jupiter.api.Test

class StringKtTest {

    @Test
    fun appendSpace() {
        assertThat(buildString { appendSpace() }).isEqualTo(buildString { append(" ") })
    }

    @Test
    fun isEnglish() {
        assertThat(isEnglish("123")).isTrue()
        assertThat(isEnglish("hello")).isTrue()
        assertThat(isEnglish("YES")).isTrue()
        assertThat(isEnglish("Hello")).isTrue()
        assertThat(isEnglish("Hello1400")).isTrue()

        assertThat(isEnglish("۵۰۵")).isFalse()
        assertThat(isEnglish("سلام")).isFalse()
    }

    @Test
    fun isNumber() {
        assertThat(isNumber("7865")).isTrue()
        assertThat(isNumber("salam")).isFalse()
        assertThat(isNumber("الکی")).isFalse()
    }

    @Test
    fun isPersianNumber() {
        assertThat(isPersianNumber("۰۹۱۵۲۱۶۵۵۰۵")).isTrue()
        assertThat(isPersianNumber("09152165505")).isFalse()
    }
}