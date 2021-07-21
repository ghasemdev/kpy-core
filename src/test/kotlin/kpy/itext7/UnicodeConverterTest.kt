package kpy.itext7

import com.google.common.truth.Truth.assertThat
import org.junit.jupiter.api.Test

class UnicodeConverterTest {

    @Test
    fun `toPersianUnicode oneChar`() {
        assertThat("ﺍ").isEqualTo(UnicodeConverter.toPersianUnicode("ا"))
        assertThat("ﺩ").isEqualTo(UnicodeConverter.toPersianUnicode("د"))
        assertThat("ﺫ").isEqualTo(UnicodeConverter.toPersianUnicode("ذ"))
        assertThat("ﺭ").isEqualTo(UnicodeConverter.toPersianUnicode("ر"))
        assertThat("ﺯ").isEqualTo(UnicodeConverter.toPersianUnicode("ز"))
        assertThat("ﮊ").isEqualTo(UnicodeConverter.toPersianUnicode("ژ"))
        assertThat("ﺓ").isEqualTo(UnicodeConverter.toPersianUnicode("ة"))
        assertThat("ﻭ").isEqualTo(UnicodeConverter.toPersianUnicode("و"))

        assertThat("ﺏ").isEqualTo(UnicodeConverter.toPersianUnicode("ب"))
        assertThat("ﺹ").isEqualTo(UnicodeConverter.toPersianUnicode("ص"))
        assertThat("ﻕ").isEqualTo(UnicodeConverter.toPersianUnicode("ق"))
        assertThat("ﮎ").isEqualTo(UnicodeConverter.toPersianUnicode("ک"))
        assertThat("ﻝ").isEqualTo(UnicodeConverter.toPersianUnicode("ل"))
    }

    @Test
    fun `toPersianUnicode twoChar`() {
        assertThat("ﻭﺍ").isEqualTo(UnicodeConverter.toPersianUnicode("او"))
        assertThat("ﻭﺭ").isEqualTo(UnicodeConverter.toPersianUnicode("رو"))

        assertThat("ﺏآ").isEqualTo(UnicodeConverter.toPersianUnicode("آب"))
        assertThat("ﻩﺍ").isEqualTo(UnicodeConverter.toPersianUnicode("اه"))

        assertThat("ﻮﺑ").isEqualTo(UnicodeConverter.toPersianUnicode("بو"))
        assertThat("ﺎﺑ").isEqualTo(UnicodeConverter.toPersianUnicode("با"))

        assertThat("ﻪﻧ").isEqualTo(UnicodeConverter.toPersianUnicode("نه"))
        assertThat("ﯽﮐ").isEqualTo(UnicodeConverter.toPersianUnicode("کی"))
    }

    @Test
    fun `toPersianUnicode threeChar`() {
        assertThat("ﺩﺭﺩ").isEqualTo(UnicodeConverter.toPersianUnicode("درد"))
        assertThat("ﺩﺭﺯ").isEqualTo(UnicodeConverter.toPersianUnicode("زرد"))

        assertThat("ﯽﺑآ").isEqualTo(UnicodeConverter.toPersianUnicode("آبی"))
        assertThat("ﺎﺿﺭ").isEqualTo(UnicodeConverter.toPersianUnicode("رضا"))

        assertThat("ﺮﺒﺑ").isEqualTo(UnicodeConverter.toPersianUnicode("ببر"))
        assertThat("ﺚﺤﺑ").isEqualTo(UnicodeConverter.toPersianUnicode("بحث"))

        assertThat("ﻍﺎﺑ").isEqualTo(UnicodeConverter.toPersianUnicode("باغ"))
        assertThat("ﻝﺎﺳ").isEqualTo(UnicodeConverter.toPersianUnicode("سال"))
    }

    @Test
    fun `toPersianUnicode fourChar`() {
        assertThat("ﮎﺩﺭﺯ").isEqualTo(UnicodeConverter.toPersianUnicode("زردک"))
        assertThat("ﯼﺩﺯﺩ").isEqualTo(UnicodeConverter.toPersianUnicode("دزدی"))

        assertThat("ﯽﻣﺩﺭ").isEqualTo(UnicodeConverter.toPersianUnicode("ردمی"))
        assertThat("ﻮﺷﻭﺭ").isEqualTo(UnicodeConverter.toPersianUnicode("روشو"))

        assertThat("ﺪﻤﺣﺍ").isEqualTo(UnicodeConverter.toPersianUnicode("احمد"))
        assertThat("ﻖﻠﺑﺍ").isEqualTo(UnicodeConverter.toPersianUnicode("ابلق"))

        assertThat("ﻥﺎﻫﺩ").isEqualTo(UnicodeConverter.toPersianUnicode("دهان"))
        assertThat("ﺏﻮﺷآ").isEqualTo(UnicodeConverter.toPersianUnicode("آشوب"))

        assertThat("ﺩﺮﺒﻧ").isEqualTo(UnicodeConverter.toPersianUnicode("نبرد"))
        assertThat("ﯼﺮﺒﺑ").isEqualTo(UnicodeConverter.toPersianUnicode("ببری"))

        assertThat("ﺶﺠﻨﺳ").isEqualTo(UnicodeConverter.toPersianUnicode("سنجش"))
        assertThat("ﺪﻤﺤﻣ").isEqualTo(UnicodeConverter.toPersianUnicode("محمد"))

        assertThat("ﺩﺍﻮﺟ").isEqualTo(UnicodeConverter.toPersianUnicode("جواد"))
        assertThat("ﺝﺭﺎﻟ").isEqualTo(UnicodeConverter.toPersianUnicode("لارج"))

        assertThat("ﺎﺑﺎﺑ").isEqualTo(UnicodeConverter.toPersianUnicode("بابا"))
        assertThat("ﺮﻓﺎﮐ").isEqualTo(UnicodeConverter.toPersianUnicode("کافر"))
    }

    @Test
    fun toPersianNumber() {
        assertThat("۱").isEqualTo(UnicodeConverter.toPersianNumber("1"))
        assertThat("۷۹").isEqualTo(UnicodeConverter.toPersianNumber("79"))
        assertThat("۱۲۵").isEqualTo(UnicodeConverter.toPersianNumber("125"))
        assertThat("۱۴۰۰").isEqualTo(UnicodeConverter.toPersianNumber("1400"))

        assertThat("").isEqualTo(UnicodeConverter.toPersianNumber("۱۴۰۰"))
        assertThat("").isEqualTo(UnicodeConverter.toPersianNumber("سلام"))
        assertThat("").isEqualTo(UnicodeConverter.toPersianNumber("Hello"))
    }

    @Test
    fun toPersianUnicode() {
        assertThat("ﮎﺭﺎﺒﻣ ۱۴۰۰ ﻝﺎﺳ").isEqualTo(UnicodeConverter.toPersianUnicode("سال 1400 مبارک"))
    }
}