package kpy.struct

import kotlinx.serialization.Serializable
import kotlin.properties.Delegates

/**
 * Check password validation
 *
 * Example :
 * ```
 * val password = password {
 *   isValidLength(5) { println("isValidLength $it") }
 *   includeDigit { println("includeDigit $it") }
 *   includeLowerCase { println("includeLowerCase $it") }
 *   includeUpperCase { println("includeUpperCase $it") }
 *   includeSpecialChar { println("includeSpecialChar $it") }
 *   excludeWhitespace { println("excludeWhitespace $it") }
 * }
 * password.value = "password"
 * ```
 * @author jakode2020
 * @since v1.0.0 7/22/2021
 */
@Serializable
open class Password {
    private lateinit var lengthValidation: (Boolean) -> Unit
    private lateinit var digitValidation: (Boolean) -> Unit
    private lateinit var lowercaseValidation: (Boolean) -> Unit
    private lateinit var uppercaseValidation: (Boolean) -> Unit
    private lateinit var specialCharValidation: (Boolean) -> Unit
    private lateinit var whitespaceValidation: (Boolean) -> Unit
    private var length by Delegates.notNull<Int>()

    var value: String by Delegates.observable("") { _, _, new ->
        if (::lengthValidation.isInitialized) lengthValidation(checkLength(new, length))
        if (::digitValidation.isInitialized) digitValidation(checkDigit(new))
        if (::lowercaseValidation.isInitialized) lowercaseValidation(checkLowerCase(new))
        if (::uppercaseValidation.isInitialized) uppercaseValidation(checkUpperCase(new))
        if (::specialCharValidation.isInitialized) specialCharValidation(checkSpecialChar(new))
        if (::whitespaceValidation.isInitialized) whitespaceValidation(checkWhitespace(new))
    }

    private fun checkLength(password: String, length: Int): Boolean = password.length >= length
    protected open fun checkDigit(password: String): Boolean = password.contains(Regex("(?=.*[0-9])"))
    protected open fun checkLowerCase(password: String): Boolean = password.contains(Regex("(?=.*[a-z])"))
    protected open fun checkUpperCase(password: String): Boolean = password.contains(Regex("(?=.*[A-Z])"))
    protected open fun checkSpecialChar(password: String): Boolean = password.contains(Regex("(?=.*[@#\$%^&+=])"))
    protected open fun checkWhitespace(password: String): Boolean = !password.contains(Regex("(?=\\s+)"))

    class Builder(initialize: Builder.() -> Unit) {
        private lateinit var lengthHolder: (Boolean) -> Unit
        private lateinit var digitHolder: (Boolean) -> Unit
        private lateinit var lowercaseHolder: (Boolean) -> Unit
        private lateinit var uppercaseHolder: (Boolean) -> Unit
        private lateinit var specialCharHolder: (Boolean) -> Unit
        private lateinit var whitespaceHolder: (Boolean) -> Unit
        private var passwordLength = 8

        init {
            initialize()
        }

        fun isValidLength(length: Int = passwordLength, initialize: (Boolean) -> Unit) {
            passwordLength = length
            lengthHolder = initialize
        }

        fun includeDigit(initialize: (Boolean) -> Unit) {
            digitHolder = initialize
        }

        fun includeLowerCase(initialize: (Boolean) -> Unit) {
            lowercaseHolder = initialize
        }

        fun includeUpperCase(initialize: (Boolean) -> Unit) {
            uppercaseHolder = initialize
        }

        fun includeSpecialChar(initialize: (Boolean) -> Unit) {
            specialCharHolder = initialize
        }

        fun excludeWhitespace(initialize: (Boolean) -> Unit) {
            whitespaceHolder = initialize
        }

        fun build(): Password {
            return Password().apply {
                if (::lengthHolder.isInitialized) lengthValidation = lengthHolder
                if (::digitHolder.isInitialized) digitValidation = digitHolder
                if (::lowercaseHolder.isInitialized) lowercaseValidation = lowercaseHolder
                if (::uppercaseHolder.isInitialized) uppercaseValidation = uppercaseHolder
                if (::specialCharHolder.isInitialized) specialCharValidation = specialCharHolder
                if (::whitespaceHolder.isInitialized) whitespaceValidation = whitespaceHolder
                length = passwordLength
            }
        }
    }
}

/** password builder create Password Struct for validation*/
fun password(init: Password.Builder.() -> Unit): Password {
    return Password.Builder(init).build()
}