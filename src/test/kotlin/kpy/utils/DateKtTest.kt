package kpy.utils

import com.google.common.truth.Truth.assertThat
import org.junit.Test
import java.util.*

class DateKtTest {

    @Test
    fun asDate() {
        assertThat(1598435781.asDate).isEqualTo(Date(1598435781L * 1000))
    }

    @Test
    fun convertDate() {
        val format = "yyyy-MM-dd HH:mm:ss"
        val date = Date()
        val stringDate = date.toString(format)
        val formatDate = stringDate.toDate(format)

        assertThat(stringDate).isEqualTo(formatDate?.toString(format))
        assertThat(formatDate).isEqualTo(stringDate.toDate(format))
    }

    @Test
    fun plusDate() {
        val date = Date()
        assertThat((date + date).time).isEqualTo(date.time * 2)
    }

    @Test
    fun minusDate() {
        val date = Date()
        assertThat((date - date).time).isEqualTo(0)
    }
}