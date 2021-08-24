package kpy.utils

import java.net.URLDecoder
import java.net.URLEncoder

/*
* Strings Extension Method
*
* @author jakode
* @since v4.0.0 08/24/2021
*/

inline val String.isAlphanumeric: Boolean
    get() = matches(Regex("\\w*"))

inline val String.isDigit: Boolean
    get() = matches(Regex("\\d*"))

inline val String.isPersianDigit: Boolean
    get() = matches(Regex("[۰-۹]*"))

inline val String.containsLatinLetter: Boolean
    get() = matches(Regex(".*[A-Za-z].*"))

inline val String.containsDigit: Boolean
    get() = matches(Regex(".*[0-9].*"))

inline val String.containsPersianDigit: Boolean
    get() = matches(Regex(".*[۰-۹].*"))

inline val String.hasLettersAndDigits: Boolean
    get() = containsLatinLetter && containsDigit

inline val String.isIntegerNumber: Boolean
    get() = toIntOrNull() != null

inline val String.isDecimalNumber: Boolean
    get() = toDoubleOrNull() != null

inline val String.lastPathComponent: String
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

/** If the string is a HTTP URL (ie. Starts with http:// or https://) */
inline val String.isHttp: Boolean
    get() = matches(Regex("(http|https)://[^\\s]*"))

/** Translates a string into application/x-www-form-urlencoded format using a specific encoding scheme. */
inline val String.urlEncode: String get() = URLEncoder.encode(this, "UTF-8")

/** Decodes an application/x-www-form-urlencoded string using a specific encoding scheme. */
inline val String.urlDecode: String get() = URLDecoder.decode(this, "UTF-8")

/** Translates a string into application/x-www-form-urlencoded format using a specific encoding scheme. */
fun String.encodeToUrl(charSet: String = "UTF-8"): String = URLEncoder.encode(this, charSet)

/** Decodes an application/x-www-form-urlencoded string using a specific encoding scheme. */
fun String.decodeToUrl(charSet: String = "UTF-8"): String = URLDecoder.decode(this, charSet)

/**
 * append space in string builders
 * @see StringBuilder
 */
fun StringBuilder.appendSpace(): StringBuilder = append(" ")