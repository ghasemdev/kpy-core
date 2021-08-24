package kpy.utils

import java.text.DecimalFormat
import kotlin.math.PI

/*
* Math
*
* @author jakode
* @since v2.2.0 08/24/2021
*/

fun isOdd(x: Int) = x % 2 != 0

fun isEven(x: Int) = x % 2 == 0

val Number.asDegrees: Float get() = toFloat() * (180F / PI).toFloat()

val Number.asRadians: Float get() = toFloat() * (PI / 180F).toFloat()

fun round(number: Float, digits: Int = 0): Float {
    return if (digits == 0) {
        kotlin.math.round(number)
    } else {
        DecimalFormat("###.${"#" * digits}").format(number).toFloat()
    }
}

fun round(number: Double, digits: Int = 0): Double {
    return if (digits == 0) {
        kotlin.math.round(number)
    } else {
        DecimalFormat("###.${"#" * digits}").format(number).toDouble()
    }
}

@JvmName("roundEx")
fun Float.round(digits: Int = 0) = round(this, digits)

@JvmName("roundEx")
fun Double.round(digits: Int = 0) = round(this, digits)