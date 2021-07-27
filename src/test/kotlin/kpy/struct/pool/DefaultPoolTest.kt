package kpy.struct.pool

import com.google.common.truth.Truth.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class DefaultPoolTest {

    @Test
    fun pool() {
        assertThat(DefaultPool.poolSize).isEqualTo(0)
        assertThrows<IllegalArgumentException> { DefaultPool.getObject() }

        DefaultPool.putObject("one", 1)
        assertThat(DefaultPool.poolSize).isEqualTo(1)
        assertThat(DefaultPool.getObject()).isEqualTo(1)

        DefaultPool.putObject("two", 2)
        assertThat(DefaultPool.poolSize).isEqualTo(2)
        assertThat(DefaultPool.getObject("two")).isEqualTo(2)
    }
}