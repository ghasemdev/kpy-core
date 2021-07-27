package kpy.struct.validation

import com.google.common.truth.Truth.assertThat
import org.junit.jupiter.api.Test

class EmailTest {

    @Test
    fun `email validation`() {
        assertThat(Email("jakode@gmail.com").isValid()).isTrue()
        assertThat(Email("jakode.2020@gmail.com").isValid()).isTrue()

        assertThat(Email("jakode@@gmail.com").isValid()).isFalse()
        assertThat(Email("jakode@").isValid()).isFalse()
    }
}