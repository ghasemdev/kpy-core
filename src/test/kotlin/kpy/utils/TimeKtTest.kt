package kpy.utils

import com.google.common.truth.Truth.assertThat
import org.junit.Test
import kotlin.time.ExperimentalTime
import kotlin.time.minutes

class TimeKtTest {

    @Test
    fun timeAgo() {
        assertThat(now().timeAgo()).isEqualTo("just now")
        assertThat(now().timeAgo(lang = mapOf("just_now" to "هم اکنون"))).isEqualTo("هم اکنون")
        assertThat(now().timeAgo(lang = mapOf())).isEqualTo("just now")

        assertThat((now() - 5.minute).timeAgo()).isEqualTo("5 minutes ago")
        assertThat((now() - 5.minute).timeAgo(lang = mapOf("minutes_ago" to "دقیقه قبل"))).isEqualTo("5 دقیقه قبل")
    }
}