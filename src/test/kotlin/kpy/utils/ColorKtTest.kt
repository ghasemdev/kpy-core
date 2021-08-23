package kpy.utils

import com.google.common.truth.Truth.assertThat
import org.junit.jupiter.api.Test
import java.awt.Color

class ColorKtTest {

    @Test
    fun awtColor() {
        assertThat("#010203".awtColor).isEqualTo(Color(1, 2, 3))
    }

    @Test
    fun hexToRGB() {
        assertThat("#010203".hexToRGB).isEqualTo(Triple("1", "2", "3"))
    }

    @Test
    fun colorToHexString() {
        assertThat(74.colorToHexString).isEqualTo("#00004A")
    }
}
