package kpy.util.extension

/*
* Converter Method
*
* @author jakode
* @since v1.0.0 07/21/2021
*/

/** byte array to hex*/
fun ByteArray.toHex() = this.joinToString(" ") { "%02X".format(it) }

/** byte array to reversed hex*/
fun ByteArray.toReversedHex() = this.reversedArray().toHex()

/** byte array to decimal*/
fun ByteArray.toDec() = buildString { this@toDec.forEach { append("%02X".format(it).toLong(16)) } }

/** byte array to reversed decimal*/
fun ByteArray.toReversedDec() = this.reversedArray().toDec()