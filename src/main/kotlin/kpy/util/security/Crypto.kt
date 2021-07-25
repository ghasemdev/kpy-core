package kpy.util.security

import java.security.SecureRandom
import java.util.*
import javax.crypto.Cipher
import javax.crypto.SecretKeyFactory
import javax.crypto.spec.IvParameterSpec
import javax.crypto.spec.PBEKeySpec
import javax.crypto.spec.SecretKeySpec

/**
 * # Crypto
 * ### Application cryptographic services include
 * * Content hashing
 * * Encryption & Deception
 * * OTP Generate
 * * Password Generate
 * * Url Encoding
 * @author jakode2020
 * @since v3.2.0 07/21/2021
 */
class Crypto(private val hashSalt: String, private val secretKey: String) {

    private val random = SecureRandom()
    private val encoder = Base64.getEncoder()
    private val decoder = Base64.getDecoder()

    companion object {
        private const val capitalChars = "ABCDEFGHIJKLMNOPQRSTUVWXYZ"
        private const val smallChars = "abcdefghijklmnopqrstuvwxyz"
        private const val numbers = "0123456789"
        private const val symbols = "!@#$%^&*_=+-/.?<>)"

        const val PASSWORD_HASH_ALGORITHM_PBKDF2_HMAC_SHA512 = "PBKDF2WithHmacSHA512"
        const val PASSWORD_HASH_ITERATIONS = 65536
        const val PASSWORD_HASH_KEY_SIZE = 128
    }

    /** Hash Content with given salt*/
    fun hashContent(content: String, salt: String = hashSalt): ByteArray {
        val pbeKeySpec = PBEKeySpec(
            content.toCharArray(),
            salt.toByteArray(),
            PASSWORD_HASH_ITERATIONS,
            PASSWORD_HASH_KEY_SIZE
        )
        val secretKeyFactory = SecretKeyFactory.getInstance(PASSWORD_HASH_ALGORITHM_PBKDF2_HMAC_SHA512)
        return secretKeyFactory.generateSecret(pbeKeySpec).encoded
    }

    /**Encrypt text with key*/
    fun encrypt(text: String, key: String = secretKey): String {
        val encrypted = cipher(Cipher.ENCRYPT_MODE, key).doFinal(text.toByteArray(Charsets.UTF_8))
        return String(encoder.encode(encrypted))
    }

    /** decrypt text with key*/
    fun decrypt(text: String, key: String = secretKey): String {
        val byteStr = decoder.decode(text.toByteArray(Charsets.UTF_8))
        return String(cipher(Cipher.DECRYPT_MODE, key).doFinal(byteStr))
    }

    @Throws(IllegalArgumentException::class)
    private fun cipher(mode: Int, secretKey: String): Cipher {
        require(secretKey.length == 32) { "SecretKey length is not 32 chars" }

        val cipher = Cipher.getInstance("AES/CBC/PKCS5PADDING")
        val secretKeySpec = SecretKeySpec(secretKey.toByteArray(Charsets.UTF_8), "AES")
        val iv = IvParameterSpec(secretKey.substring(0, 16).toByteArray(Charsets.UTF_8))
        return cipher.apply { init(mode, secretKeySpec, iv) }
    }

    /** Generate one time permission */
    fun generateOtp(length: Int = 5, isCharacterEnabled: Boolean = false): String {
        val values = if (isCharacterEnabled) capitalChars + smallChars + numbers else numbers
        return generate(length, values)
    }

    /** Generate Password */
    fun generatePassword(length: Int = 8, isSymbolsEnabled: Boolean = true): String {
        var values = "$capitalChars$smallChars$numbers"
        if (isSymbolsEnabled) values += symbols
        return (generate(length, values))
    }

    private fun generate(length: Int, values: String) = buildString {
        repeat(length) { append(values[random.nextInt(values.length)]) }
    }

    /** Convert URL to encoded URL */
    fun urlEncoding(originalUrl: String): String = Base64.getUrlEncoder().encodeToString(originalUrl.toByteArray())

    /** Convert encoded URL to URL */
    fun urlDecoding(encodedUrl: String): String = String(Base64.getUrlDecoder().decode(encodedUrl))
}