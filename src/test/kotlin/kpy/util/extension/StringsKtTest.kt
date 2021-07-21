package kpy.util.extension

import com.google.common.truth.Truth.assertThat
import org.junit.jupiter.api.Test

class StringsKtTest {

    @Test
    fun appendSpace() {
        assertThat(buildString { appendSpace() }).isEqualTo(buildString { append(" ") })
    }

    @Test
    fun isEnglish() {
        assertThat("123".isEnglish()).isTrue()
        assertThat("hello".isEnglish()).isTrue()
        assertThat("YES".isEnglish()).isTrue()
        assertThat("Hello".isEnglish()).isTrue()
        assertThat("Hello1400".isEnglish()).isTrue()

        assertThat("۵۰۵".isEnglish()).isFalse()
        assertThat("سلام".isEnglish()).isFalse()
    }

    @Test
    fun isNumber() {
        assertThat("7865".isNumber()).isTrue()
        assertThat("salam".isNumber()).isFalse()
        assertThat("الکی".isNumber()).isFalse()
    }

    @Test
    fun isPersianNumber() {
        assertThat("۰۹۱۵۲۱۶۵۵۰۵".isPersianNumber()).isTrue()
        assertThat("09152165505".isPersianNumber()).isFalse()
    }
}