package kpy.util.extension

/*
* Strings Extension Method
*
* @author jakode
* @since v2.0.0 08/23/2021
*/

/**
 * append space in string builders
 * @see StringBuilder
 */
fun StringBuilder.appendSpace(): StringBuilder = append(" ")

val String.isAlphanumeric: Boolean
    get() = matches(Regex("\\w*"))

val String.isDigit: Boolean
    get() = matches(Regex("\\d*"))

val String.isPersianDigit: Boolean
    get() = matches(Regex("[۰-۹]*"))

val String.containsLatinLetter: Boolean
    get() = matches(Regex(".*[A-Za-z].*"))

val String.containsDigit: Boolean
    get() = matches(Regex(".*[0-9].*"))

val String.containsPersianDigit: Boolean
    get() = matches(Regex(".*[۰-۹].*"))

val String.hasLettersAndDigits: Boolean
    get() = containsLatinLetter && containsDigit

val String.isIntegerNumber: Boolean
    get() = toIntOrNull() != null

val String.isDecimalNumber: Boolean
    get() = toDoubleOrNull() != null