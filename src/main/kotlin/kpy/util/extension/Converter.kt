package kpy.util.extension

/*
* Converter Method
*
* @author jakode
* @since v1.1.0 08/22/2021
*/

/** byte array to hex*/
fun ByteArray.toHex() = joinToString(" ") { "%02X".format(it) }

/** byte array to reversed hex*/
fun ByteArray.toReversedHex() = reversedArray().joinToString(" ") { "%02X".format(it) }

/** byte array to decimal*/
fun ByteArray.toDec() = buildString { this@toDec.forEach { append("%02X".format(it).toLong(16)) } }

/** byte array to reversed decimal*/
fun ByteArray.toReversedDec() =
    buildString { this@toReversedDec.reversedArray().forEach { append("%02X".format(it).toLong(16)) } }