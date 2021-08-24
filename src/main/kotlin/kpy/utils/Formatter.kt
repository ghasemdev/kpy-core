package kpy.utils

import java.text.DecimalFormat
import java.time.format.DateTimeFormatter

/*
* Formatter
*
* @author jakode
* @since v2.0.0 08/23/2021
*/

val dateFormatter: DateTimeFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy")
val timeFormatter: DateTimeFormatter = DateTimeFormatter.ofPattern("HH:mm:ss")
val dateTimeFormatter: DateTimeFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy-HH:mm:ss")

/** Remove decimal part when float number has .0 */
inline val Float.removeDecimalPart: String
    get() {
        val numberToInt = toInt()
        return if (this == numberToInt.toFloat()) numberToInt.toString() else toString()
    }

/** Remove decimal part when double number has .0 */
inline val Double.removeDecimalPart: String
    get() {
        val numberToInt = toInt()
        return if (this == numberToInt.toDouble()) numberToInt.toString() else toString()
    }

internal val decimalFormat = DecimalFormat()

/**
 * Number separator with pattern
 * @return default pattern is ,###.##
 */
fun Number.separate(pattern: String = "#,###.##"): String {
    decimalFormat.applyPattern(pattern)
    return decimalFormat.format(this)
}

/** Format string as credit card number */
fun String.formatCreditCard(separator: String = " ", separatorDigit: Int = 4): String {
    val preparedString = replace(" ", "").trim()
    return buildString {
        for (i in preparedString.indices) {
            if (i % separatorDigit == 0 && i != 0) {
                append(separator)
            }
            append(preparedString[i])
        }
    }
}