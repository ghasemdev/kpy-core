package kpy.security

import com.google.common.truth.Truth.assertThat
import kpy.log.Log
import kpy.utils.*
import org.junit.jupiter.api.MethodOrderer
import org.junit.jupiter.api.Order
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.TestMethodOrder

@TestMethodOrder(MethodOrderer.OrderAnnotation::class)
class CryptoTest {

    private val crypto =
        Crypto(hashSalt = "b;raT/\$.ZQ+U8bm6;7]sncEh2;H9Jp97", secretKey = "rTz]~YfW95HhH;BB'txtVgy%aR%&P'a{")

    @Test
    @Order(1)
    fun `generate otp without character`() {
        val otp = crypto.generateOtp()

        assertThat(otp.isDigit).isTrue()
        assertThat(otp.length).isEqualTo(5)
        Log.i(otp, "generate otp with out character:")
    }

    @Test
    @Order(2)
    fun `generate otp`() {
        val otp = crypto.generateOtp(length = 6, isCharacterEnabled = true)

        assertThat(otp.isAlphanumeric).isTrue()
        assertThat(otp.length).isEqualTo(6)
        Log.i(otp, "generate otp:")
    }

    @Test
    @Order(3)
    fun `generate password without symbols`() {
        val otp = crypto.generatePassword(isSymbolsEnabled = false)

        assertThat(otp.isAlphanumeric).isTrue()
        assertThat(otp.length).isEqualTo(8)
        Log.i(otp, "generate password with out symbols:")
    }

    @Test
    @Order(4)
    fun `generate password`() {
        val otp = crypto.generatePassword()

        assertThat(otp.length).isEqualTo(8)
        Log.i(otp, "generate password:")
    }

    @Test
    @Order(5)
    fun `hash password`() {
        val hash = crypto.hashContent("1234")

        assertThat(hash.asHex).isEqualTo("DA 4C 79 A8 FF E0 95 24 E8 E6 C3 1B C6 A1 AE 9B")
        Log.i(hash.asHex, "hash password toHex:")

        assertThat(hash.asReversedHex).isEqualTo("9B AE A1 C6 1B C3 E6 E8 24 95 E0 FF A8 79 4C DA")
        Log.i(hash.asReversedHex, "hash password toReversedHex:")

        assertThat(hash.asDec).isEqualTo("218761211682552241493623223019527198161174155")
        Log.i(hash.asDec, "hash password toDec:")

        assertThat(hash.asReversedDec).isEqualTo("155174161198271952302323614922425516812176218")
        Log.i(hash.asReversedDec, "hash password toReversedDec:")
    }

    @Test
    @Order(6)
    fun cryptography() {
        val text = "hi my name is jakode"
        Log.i(text, "cryptography text:")

        val encrypt = crypto.encrypt(text)
        Log.i(encrypt, "cryptography encrypt:")

        val decrypt = crypto.decrypt(encrypt)
        assertThat(decrypt).isEqualTo(text)
    }

    @Test
    @Order(7)
    fun `length hashes and encrypted content`() {
        val hashedPhone = crypto.hashContent("09152165050").asHex
        val hashedEmail = crypto.hashContent("shirdelghasem79@gmail.com").asHex
        Log.i(hashedPhone.length, "hashedPhone length:")
        Log.i(hashedEmail.length, "hashedEmail length:")

        assertThat(hashedPhone.length).isEqualTo(47)
        assertThat(hashedEmail.length).isEqualTo(47)

        val phoneEncrypt = crypto.encrypt("09309275920")
        val emailEncrypt = crypto.encrypt("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa@gmail.com")
        Log.i(phoneEncrypt.length, "phoneEncrypt length:")
        Log.i(emailEncrypt.length, "emailEncrypt length:")

        assertThat(phoneEncrypt.length).isEqualTo(24)
        assertThat(emailEncrypt.length).isEqualTo(88)
    }

    @Test
    @Order(8)
    fun `Url encoding`() {
        val originalUrl = "https://www.google.co.nz/?gfe_rd=cr&ei=dzbFV&gws_rd=ssl#q=java"
        val encodingUrl = crypto.urlEncode(originalUrl)
        Log.i(encodingUrl, "encoding url:")
        assertThat(encodingUrl).isEqualTo("aHR0cHM6Ly93d3cuZ29vZ2xlLmNvLm56Lz9nZmVfcmQ9Y3ImZWk9ZHpiRlYmZ3dzX3JkPXNzbCNxPWphdmE=")

        val decodedUrl = crypto.urlDecode(encodingUrl)
        Log.i(decodedUrl, "decoded url:")
        assertThat(decodedUrl).isEqualTo(originalUrl)
    }
}