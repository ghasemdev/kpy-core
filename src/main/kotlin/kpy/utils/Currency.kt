package kpy.utils

import java.util.Locale

/*
* Currency
*
* @author jakode
* @since v1.0.0 08/24/2021
*/

val Int.centsToDollars: Double
    get() = toDouble() / 100.0

val Int.centsToDollarsFormat: String
    get() {
        val dollars = this / 100
        val cents = this % 100
        return String.format(Locale.US, "$%d.%02d", dollars, cents)
    }

fun Double.formatPrice(currency: String = "$"): String {
    decimalFormat.applyPattern("#,###.00")
    decimalFormat.groupingSize = 3
    return currency + decimalFormat.format(this)
}