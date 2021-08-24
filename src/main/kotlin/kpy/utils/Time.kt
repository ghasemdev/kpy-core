package kpy.utils

/*
* Time
*
* @author jakode
* @since v1.0.0 08/25/2021
*/

private const val YEAR_IN_MILLIS = 31_557_600_000L
private const val MONTH_IN_MILLIS = 2_629_800_000L
private const val WEEK_IN_MILLIS = 604_800_017L
private const val DAY_IN_MILLIS = 86_400_000L
private const val HOUR_IN_MILLIS = 3_600_000L
private const val MINUTE_IN_MILLIS = 60_000L
private const val SECOND_IN_MILLIS = 1_000L

val FIVE_MIN = 5.minute
val TEN_MIN = 10.minute
val FIFTEEN_MIN = 15.minute
val Half_hour = 30.minute
val Forty_five_MIN = 45.minute

/** Year in millis second */
val Int.year: Long
    get() = this * YEAR_IN_MILLIS

/** Month in millis second */
val Int.month: Long
    get() = this * MONTH_IN_MILLIS

/** Week in millis second */
val Int.week: Long
    get() = this * WEEK_IN_MILLIS

/** Day in millis second */
val Int.day: Long
    get() = this * DAY_IN_MILLIS

/** Hour in millis second */
val Int.hour: Long
    get() = this * HOUR_IN_MILLIS

/** Minute in millis second */
val Int.minute: Long
    get() = this * MINUTE_IN_MILLIS

/** second in millis second */
val Int.second: Long
    get() = this * SECOND_IN_MILLIS

/** Current time in millis */
fun now(): Long = System.currentTimeMillis()

/** Tomorrow at this time in millis */
fun tomorrow(): Long = System.currentTimeMillis() + 1.day

/**
 * Returns time elapsed string for a given timestamp from referenceTime
 * @param referenceTime Time reference based on which ' ago' string is generated.
 * Default value is current time
 * @param lang Language of timeAgo handle with a map. Please fill in the appropriate values for each key
 * @param onDateFormat on date require a format (default is : 'on 25/08/2021')
 */
fun Long.timeAgo(
    referenceTime: Long = now(),
    lang: Map<String, String> = hashMapOf(
        "on_date" to "on",
        "last_month" to "last month",
        "weeks_ago" to "weeks ago",
        "last_week" to "last week",
        "days_ago" to "days ago",
        "yesterday" to "yesterday",
        "hours_ago" to "hours ago",
        "an_hour_ago" to "an hour ago",
        "minutes_ago" to "minutes ago",
        "a_minute_ago" to "a minute ago",
        "just_now" to "just now"
    ),
    onDateFormat: String = "dd/MM/yyyy"
): String {
    val different = referenceTime - this
    return when {
        /* on ... */
        different >= 2 * MONTH_IN_MILLIS -> "${lang["on_date"].orDefault("on")} ${different.asDate.toString(onDateFormat)}"
        /* last month */
        different >= MONTH_IN_MILLIS -> lang["last_month"].orDefault("last month")
        /* 7 weeks ago */
        different >= 2 * WEEK_IN_MILLIS -> "${different / WEEK_IN_MILLIS} ${lang["weeks_ago"].orDefault("weeks ago")}"
        /* last week */
        different >= WEEK_IN_MILLIS -> lang["last_week"].orDefault("last week")
        /* 29 days ago */
        different >= 2 * DAY_IN_MILLIS -> "${different / DAY_IN_MILLIS} ${lang["days_ago"].orDefault("days ago")}"
        /* yesterday */
        different >= DAY_IN_MILLIS -> lang["yesterday"].orDefault("yesterday")
        /* 23 hours ago */
        different >= 2 * HOUR_IN_MILLIS -> "${different / HOUR_IN_MILLIS} ${lang["hours_ago"].orDefault("hours ago")}"
        /* an hour ago */
        different >= HOUR_IN_MILLIS -> lang["an_hour_ago"].orDefault("an hour ago")
        /* 5 minutes ago */
        different >= 2 * MINUTE_IN_MILLIS -> "${different / MINUTE_IN_MILLIS} ${lang["minutes_ago"].orDefault("minutes ago")}"
        /* a minute ago */
        different >= MINUTE_IN_MILLIS -> lang["a_minute_ago"].orDefault("a minute ago")
        else -> lang["just_now"].orDefault("just now")
    }
}