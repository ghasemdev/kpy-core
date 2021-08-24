package kpy.utils

import com.google.common.truth.Truth.assertThat
import org.junit.Test

class CurrencyKtTest {

    @Test
    fun centsToDollars() {
        assertThat(4999.centsToDollars).isEqualTo(49.99)
        assertThat(1000.centsToDollars).isEqualTo(10.00)
    }

    @Test
    fun centsToDollarsFormat() {
        assertThat(4999.centsToDollarsFormat).isEqualTo("$49.99")
        assertThat(1000.centsToDollarsFormat).isEqualTo("$10.00")
    }

    @Test
    fun formatPrice() {
        assertThat(123456789.568.formatPrice("€")).isEqualTo("€123,456,789.57")
        assertThat(60.60.formatPrice()).isEqualTo("$60.60")
        assertThat(1.0.formatPrice()).isEqualTo("$1.00")
    }
}