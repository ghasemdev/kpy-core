package kpy.utils

import java.text.ParseException
import java.text.SimpleDateFormat
import java.util.*

/*
* Date
*
* @author jakode
* @since v1.0.0 08/24/2021
*/

private val simpleDateFormat = SimpleDateFormat()

/** Convert int to date */
val Int.asDate: Date
    get() = Date(toLong() * 1000L)

fun String.toDate(format: String): Date? {
    return try {
        simpleDateFormat.applyPattern(format)
        simpleDateFormat.parse(this)
    } catch (e: ParseException) {
        null
    }
}

fun Date.toString(format: String): String {
    simpleDateFormat.applyPattern(format)
    return simpleDateFormat.format(this)
}

operator fun Date.plus(other: Date) = Date(time + other.time)

operator fun Date.minus(other: Date) = Date(time - other.time)