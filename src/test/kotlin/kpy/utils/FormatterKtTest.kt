package kpy.utils

import com.google.common.truth.Truth.assertThat
import org.junit.jupiter.api.Test

class FormatterKtTest {

    @Test
    fun `remove decimal part`() {
        assertThat(12.0F.removeDecimalPart).isEqualTo("12")
        assertThat(12.3F.removeDecimalPart).isEqualTo("12.3")
    }

    @Test
    fun `separate number with pattern`() {
        val number1 = 1000000
        val number2 = 1000000.569
        val number3 = 100000000000000
        val number4 = 12345.369F

        assertThat(number1.separate()).isEqualTo("1,000,000")
        assertThat(number2.separate()).isEqualTo("1,000,000.57")
        assertThat(number3.separate()).isEqualTo("100,000,000,000,000")
        assertThat(number4.separate()).isEqualTo("12,345.37")
    }

    @Test
    fun creditCardFormatted() {
        assertThat("1234567890123456".creditCardFormatted()).isEqualTo("1234 5678 9012 3456")
        assertThat("1234567890123456789".creditCardFormatted()).isEqualTo("1234 5678 9012 3456 789")
        assertThat("12".creditCardFormatted()).isEqualTo("12")

        assertThat("1234567890123456".creditCardFormatted(separator = "-")).isEqualTo("1234-5678-9012-3456")
        assertThat("1234567890123456789".creditCardFormatted(separator = "-")).isEqualTo("1234-5678-9012-3456-789")
        assertThat("12".creditCardFormatted("@", 1)).isEqualTo("1@2")
    }
}