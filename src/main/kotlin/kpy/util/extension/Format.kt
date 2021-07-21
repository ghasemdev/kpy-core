package kpy.util.extension

import java.text.DecimalFormat
import java.time.format.DateTimeFormatter

/*
* Formatter
*
* @author jakode
* @since v1.0.0 07/21/2021
*/

val dateFormatter: DateTimeFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy")
val timeFormatter: DateTimeFormatter = DateTimeFormatter.ofPattern("HH:mm:ss")
val dateTimeFormatter: DateTimeFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy-HH:mm:ss")

/** Remove decimal part when float number has .0 */
fun Float.removeDecimal(): String {
    val numberToInt = this.toInt()
    return if (this == numberToInt.toFloat()) numberToInt.toString() else this.toString()
}

/** Remove decimal part when double number has .0 */
fun Double.removeDecimal(): String {
    val numberToInt = this.toInt()
    return if (this == numberToInt.toDouble()) numberToInt.toString() else this.toString()
}

/**
 * Separate number with pattern
 * @return default pattern is ###,###,###
 */
fun Number.separate(pattern: String = ",###.##"): String {
    return DecimalFormat(pattern).format(this)
}