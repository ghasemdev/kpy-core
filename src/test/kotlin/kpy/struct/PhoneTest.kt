package kpy.struct

import com.google.common.truth.Truth.assertThat
import org.junit.jupiter.api.Test

class PhoneTest {

    @Test
    fun `phone validation`() {
        assertThat(Phone("09150000000").isValid()).isTrue()
        assertThat(Phone("09123456789").isValid()).isTrue()
        assertThat(Phone("+989150000000").isValid()).isTrue()

        assertThat(Phone("0123456789").isValid()).isFalse()
        assertThat(Phone("0515216480").isValid()).isFalse()
        assertThat(Phone("+169150000000").isValid()).isFalse()
    }
}