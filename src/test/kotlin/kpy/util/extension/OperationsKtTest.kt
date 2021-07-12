package kpy.util.extension

import com.google.common.truth.Truth.assertThat
import org.junit.jupiter.api.Test

class OperationsKtTest {

    @Test
    fun nor() {
        assertThat(0 nor 0).isEqualTo(1)
        assertThat(0 nor 1).isEqualTo(0)
        assertThat(1 nor 0).isEqualTo(0)
        assertThat(1 nor 1).isEqualTo(0)
    }

    @Test
    fun nand() {
        assertThat(0 nand 0).isEqualTo(1)
        assertThat(0 nand 1).isEqualTo(1)
        assertThat(1 nand 0).isEqualTo(1)
        assertThat(1 nand 1).isEqualTo(0)
    }

    @Test
    fun xnor() {
        assertThat(0 xnor 0).isEqualTo(1)
        assertThat(0 xnor 1).isEqualTo(0)
        assertThat(1 xnor 0).isEqualTo(0)
        assertThat(1 xnor 1).isEqualTo(1)
    }

    @Test
    fun not() {
        assertThat(not(0)).isEqualTo(1)
        assertThat(not(1)).isEqualTo(0)
    }

    @Test
    fun `boolean nor`() {
        assertThat(false nor false).isTrue()
        assertThat(false nor true).isFalse()
        assertThat(true nor false).isFalse()
        assertThat(true nor true).isFalse()
    }

    @Test
    fun `boolean nand`() {
        assertThat(false nand false).isTrue()
        assertThat(false nand true).isTrue()
        assertThat(true nand false).isTrue()
        assertThat(true nand true).isFalse()
    }

    @Test
    fun `boolean xnor`() {
        assertThat(false xnor false).isTrue()
        assertThat(false xnor true).isFalse()
        assertThat(true xnor false).isFalse()
        assertThat(true xnor true).isTrue()
    }
}