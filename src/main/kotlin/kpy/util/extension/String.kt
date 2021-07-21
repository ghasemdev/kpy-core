package kpy.util.extension

/*
* Strings Extension
*
* @author jakode
* @since v1.0.0 07/21/2021
*/

/**
 * append space in string builders
 * @see StringBuilder
 */
fun StringBuilder.appendSpace(): StringBuilder = append(" ")

fun isEnglish(word: String) = word.matches(Regex("\\w*"))

fun isNumber(word: String) = word.matches(Regex("\\d*"))

fun isPersianNumber(word: String) = word.matches(Regex("[۰-۹]*"))