package kpy.utils

import com.google.common.truth.Truth.assertThat
import kpy.log.Log
import org.junit.jupiter.api.Test

class StringsKtTest {

    @Test
    fun appendSpace() {
        assertThat(buildString { appendSpace() }).isEqualTo(buildString { append(" ") })
    }

    @Test
    fun isAlphanumeric() {
        assertThat("123".isAlphanumeric).isTrue()
        assertThat("hello".isAlphanumeric).isTrue()
        assertThat("YES".isAlphanumeric).isTrue()
        assertThat("Hello".isAlphanumeric).isTrue()
        assertThat("Hello1400".isAlphanumeric).isTrue()
        assertThat("۵۰۵".isAlphanumeric).isFalse()
        assertThat("سلام".isAlphanumeric).isFalse()
    }

    @Test
    fun isDigit() {
        assertThat("7865".isDigit).isTrue()
        assertThat("salam".isDigit).isFalse()
        assertThat("hr56".isDigit).isFalse()
        assertThat("الکی".isDigit).isFalse()
    }

    @Test
    fun isPersianDigit() {
        assertThat("۰۹۱۵۲۱۶۵۵۰۵".isPersianDigit).isTrue()
        assertThat("09152165505".isPersianDigit).isFalse()
        assertThat("۵۲s".isPersianDigit).isFalse()
        assertThat("۵۲ض".isPersianDigit).isFalse()
    }

    @Test
    fun containsLatinLetter() {
        assertThat("Hello1400".containsLatinLetter).isTrue()
        assertThat("Hello".containsLatinLetter).isTrue()
        assertThat("hello".containsLatinLetter).isTrue()
        assertThat("Helloسلام".containsLatinLetter).isTrue()
        assertThat("0".containsLatinLetter).isFalse()
        assertThat("ا".containsLatinLetter).isFalse()
    }

    @Test
    fun containsDigit() {
        assertThat("Hello1400".containsDigit).isTrue()
        assertThat("1234".containsDigit).isTrue()
        assertThat("hello".containsDigit).isFalse()
        assertThat("سلام".containsDigit).isFalse()
        assertThat("۱۵۲۱۶۵".containsDigit).isFalse()
    }

    @Test
    fun containsPersianDigit() {
        assertThat("Hello۲۱".containsPersianDigit).isTrue()
        assertThat("۲۱".containsPersianDigit).isTrue()
        assertThat("hello".containsPersianDigit).isFalse()
        assertThat("سلام5".containsPersianDigit).isFalse()
        assertThat("125".containsPersianDigit).isFalse()
    }

    @Test
    fun hasLettersAndDigits() {
        assertThat("Hello55".hasLettersAndDigits).isTrue()
        assertThat("hello".hasLettersAndDigits).isFalse()
        assertThat("125".hasLettersAndDigits).isFalse()
    }

    @Test
    fun isIntegerNumber() {
        assertThat("123".isIntegerNumber).isTrue()
        assertThat("012".isIntegerNumber).isTrue()
        assertThat("12.5".isIntegerNumber).isFalse()
        assertThat("q".isIntegerNumber).isFalse()
    }

    @Test
    fun isDecimalNumber() {
        assertThat("123.56".isDecimalNumber).isTrue()
        assertThat("127".isDecimalNumber).isTrue()
        assertThat("012".isDecimalNumber).isTrue()
        assertThat("012.65".isDecimalNumber).isTrue()
        assertThat("q".isDecimalNumber).isFalse()
    }

    @Test
    fun lastPathComponent() {
        assertThat("https://google.com/chrome/".lastPathComponent).isEqualTo("chrome")
        assertThat("C:\\Windows\\Fonts\\font.ttf".lastPathComponent).isEqualTo("font.ttf")
        assertThat("/dev/null".lastPathComponent).isEqualTo("null")
    }

    @Test
    fun isHttp() {
        assertThat("http://www.jakode.com".isHttp).isTrue()
        assertThat("https://www.jakode.com".isHttp).isTrue()
        assertThat("htt://www//".isHttp).isFalse()
    }

    @Test
    fun `Url encoding`() {
        val originalUrl = "https://www.google.co.nz/?gfe_rd=cr&ei=dzbFV&gws_rd=ssl#q=java"
        val encodingUrl = originalUrl.urlEncode
        Log.i(encodingUrl, "encoding url:")
        assertThat(encodingUrl).isEqualTo("https%3A%2F%2Fwww.google.co.nz%2F%3Fgfe_rd%3Dcr%26ei%3DdzbFV%26gws_rd%3Dssl%23q%3Djava")

        val decodedUrl = originalUrl.urlDecode
        Log.i(decodedUrl, "decoded url:")
        assertThat(decodedUrl).isEqualTo(originalUrl)
    }
}