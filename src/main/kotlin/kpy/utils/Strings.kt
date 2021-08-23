package kpy.utils

/*
* Strings Extension Method
*
* @author jakode
* @since v3.0.0 08/23/2021
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

val String.lastPathComponent: String
    get() {
        var path = this
        if (path.endsWith("/"))
            path = path.substring(0, path.length - 1)
        var index = path.lastIndexOf('/')
        if (index < 0) {
            if (path.endsWith("\\"))
                path = path.substring(0, path.length - 1)
            index = path.lastIndexOf('\\')
            if (index < 0)
                return path
        }
        return path.substring(index + 1)
    }