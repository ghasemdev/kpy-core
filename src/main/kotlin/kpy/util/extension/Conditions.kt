package kpy.util.extension

/*
* Conditions lambda method
*
* @author jakode
* @since v1.0.0 07/12/2021
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
inline fun <T> T?.ifNotNull(function: (T?) -> Any): Any? {
    if (this != null) {
        return function(this)
    }
    return this
}