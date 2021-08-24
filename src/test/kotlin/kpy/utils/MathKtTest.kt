package kpy.utils

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

    @Test
    fun degrees() {
        assertThat(0.5.asDegrees.round(2)).isEqualTo(28.65F)
        assertThat(1.asDegrees.round(2)).isEqualTo(57.30F)
        assertThat(2.asDegrees.round(2)).isEqualTo(114.59F)
    }

    @Test
    fun radians() {
        assertThat(45.asRadians.round(2)).isEqualTo(0.79F)
        assertThat(90.asRadians.round(2)).isEqualTo(1.57F)
        assertThat(180.asRadians.round(2)).isEqualTo(3.14F)
    }

    @Test
    fun round() {
        assertThat(1.999.round()).isEqualTo(2.0)
        assertThat(1.856.round(1)).isEqualTo(1.9)
        assertThat(1.856.round(2)).isEqualTo(1.86)

        assertThat(1.999F.round()).isEqualTo(2.0F)
        assertThat(1.856F.round(1)).isEqualTo(1.9F)
        assertThat(1.856f.round(2)).isEqualTo(1.86F)
    }
}