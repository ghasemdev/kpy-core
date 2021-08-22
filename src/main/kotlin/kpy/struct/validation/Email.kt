package kpy.struct.validation

import kotlinx.serialization.Serializable

/**
 * Email Struct is a primitive value
 * @author jakode2020
 * @since v1.1.0 08/22/2021
 */
@JvmInline
@Serializable
value class Email(val value: String) : Validation {
    /** check is a valid email*/
    override fun isValid() = value.matches(Regex("""^[a-zA-Z0-9_!#$%&’*+/=?`{|}~^.-]+@[a-zA-Z0-9.-]+$"""))
}