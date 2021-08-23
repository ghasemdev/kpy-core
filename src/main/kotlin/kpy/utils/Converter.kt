package kpy.utils

/*
* Converter Method
*
* @author jakode
* @since v2.0.0 08/23/2021
*/

/** byte array to hex*/
val ByteArray.hex: String
    get() = joinToString(" ") { "%02X".format(it) }

/** byte array to reversed hex*/
val ByteArray.reversedHex: String
    get() = reversedArray().joinToString(" ") { "%02X".format(it) }

/** byte array to decimal*/
val ByteArray.dec: String
    get() = buildString { this@dec.forEach { append("%02X".format(it).toLong(16)) } }

/** byte array to reversed decimal*/
val ByteArray.reversedDec: String
    get() = buildString { this@reversedDec.reversedArray().forEach { append("%02X".format(it).toLong(16)) } }