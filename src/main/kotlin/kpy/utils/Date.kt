package kpy.utils

import java.text.ParseException
import java.text.SimpleDateFormat
import java.util.*

/*
* Date
*
* @author jakode
* @since v2.1.0 08/26/2021
*/

internal val simpleDateFormat = SimpleDateFormat()

/** Convert int to date */
inline val Int.asDate: Date get() = Date(toLong())

/** Convert long to date */
inline val Long.asDate: Date get() = Date(this)

/** Convert [Date] to [Calendar] */
inline val Date.asCalendar: Calendar
    get() {
        val calendar = Calendar.getInstance()
        calendar.time = this
        return calendar
    }

inline val Date.tomorrow: Date get() = Date(time + 1.day)

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

fun Date.isSameDay(date: Date): Boolean {
    val day1 = asCalendar.get(Calendar.DAY_OF_YEAR)
    val day2 = date.asCalendar.get(Calendar.DAY_OF_YEAR)
    return day1 == day2
}

operator fun Date.plus(other: Date) = Date(time + other.time)

operator fun Date.minus(other: Date) = Date(time - other.time)