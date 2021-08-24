package kpy.utils

/*
* Generic
*
* @author jakode
* @since v2.0.0 08/24/2021
*/

/**
 * ifNull execute when value is null
 * @return value or [Unit]
 */
inline fun <T> T?.ifNull(function: (T?) -> Any): Any {
    if (this == null) {
        return function(this)
    }
    return this
}

/**
 * ifNotNull execute when value isn't null
 * @return value or [Unit]
 */
inline fun <T> T?.ifNotNull(function: (T) -> Any): Any? {
    if (this != null) {
        return function(this)
    }
    return this
}

/** Checking nullability */
fun Any?.isNull() = this == null

/** Checking none nullability */
fun Any?.isNotNull() = this != null

/**
 * when long is null default value is zero
 * @return [Long] value or **Zero**
 */
fun Long?.orZero(): Long = this ?: 0L

/**
 * when float is null default value is zero
 * @return [Float] value or **Zero**
 */
fun Float?.orZero(): Float = this ?: 0F

/**
 * when double is null default value is zero
 * @return [Double] value or **Zero**
 */
fun Double?.orZero(): Double = this ?: 0.0

/**
 * when number is null default value is zero
 * @return [Number] value or **Zero**
 */
fun Number?.orZero(): Number = this ?: 0

/**
 * when variable is null default value maintained
 * @return [T] value or **default**
 */
fun <T> T?.orDefault(default: T): T {
    return this ?: default
}

/* try block without catching */
inline fun tryOrIgnore(block: () -> Unit) {
    try {
        block()
    } catch (e: Exception) {
    }
}