package kpy.util.extension

/*
* Strings Extension Method
*
* @author jakode
* @since v1.0.0 07/21/2021
*/

/**
 * append space in string builders
 * @see StringBuilder
 */
fun StringBuilder.appendSpace(): StringBuilder = append(" ")

/** check is a english string*/
fun String.isEnglish() = this.matches(Regex("\\w*"))

/** check is a number*/
fun String.isNumber() = this.matches(Regex("\\d*"))

/** check is a persian number*/
fun String.isPersianNumber() = this.matches(Regex("[۰-۹]*"))