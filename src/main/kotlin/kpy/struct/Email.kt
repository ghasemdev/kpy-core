package kpy.struct

/**
 * Email Struct is a primitive value
 * @author jakode2020
 * @since v1.0.0 7/22/2021
 */
@JvmInline
value class Email(val value: String) : Validation {
    /** check is a valid email*/
    override fun isValid() = value.isNotEmpty() && value.matches(Regex("^[a-zA-Z0-9_!#\$%&’*+/=?`{|}~^.-]+@[a-zA-Z0-9.-]+\$"))
}