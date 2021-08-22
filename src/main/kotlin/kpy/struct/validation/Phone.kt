package kpy.struct.validation

import kotlinx.serialization.Serializable

/**
 * Phone Struct is a primitive value
 * @author jakode2020
 * @since v1.1.0 08/22/2021
 */
@JvmInline
@Serializable
value class Phone(val value: String) : Validation {
    /** check is a phone number*/
    override fun isValid() = value.matches(Regex("""09\d{9}|\+989\d{9}"""))
}