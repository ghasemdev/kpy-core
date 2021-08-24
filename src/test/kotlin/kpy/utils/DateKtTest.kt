package kpy.utils

import com.google.common.truth.Truth.assertThat
import org.junit.Test
import java.util.*

class DateKtTest {

    @Test
    fun asDate() {
        assertThat(1598435781.asDate).isEqualTo(Date(1598435781L))
        assertThat(999999999999999999L.asDate).isEqualTo(Date(999999999999999999L))
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

    @Test
    fun asCalender() {
        assertThat(Date().asCalendar).isInstanceOf(Calendar::class.java)
    }

    @Test
    fun tomorrow() {
        val date = Date()
        assertThat(date.tomorrow).isEqualTo(Date(date.time + 1.day))
    }

    @Test
    fun isSameDay() {
        val date = Date()
        val date2 = Date()
        assertThat(date.isSameDay(date2)).isTrue()
    }
}