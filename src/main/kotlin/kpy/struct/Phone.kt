package kpy.struct

/**
 * Phone Struct is a primitive value
 * @author jakode2020
 * @since v1.0.0 7/22/2021
 */
@JvmInline
value class Phone(val value: String) : Validation {
    /** check is a phone number*/
    override fun isValid() = value.isNotEmpty() && value.matches(Regex("09\\d{9}|\\+989\\d{9}"))
}