package kpy.utils

/*
* Converter Method
*
* @author jakode
* @since v2.1.0 08/24/2021
*/

/** byte array to hex*/
inline val ByteArray.asHex: String
    get() = joinToString(" ") { "%02X".format(it) }

/** byte array to reversed hex*/
inline val ByteArray.asReversedHex: String
    get() = reversedArray().joinToString(" ") { "%02X".format(it) }

/** byte array to decimal*/
inline val ByteArray.asDec: String
    get() = buildString { this@asDec.forEach { append("%02X".format(it).toLong(16)) } }

/** byte array to reversed decimal*/
inline val ByteArray.asReversedDec: String
    get() = buildString { this@asReversedDec.reversedArray().forEach { append("%02X".format(it).toLong(16)) } }