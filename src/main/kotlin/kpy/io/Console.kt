package kpy.io

import java.util.*

/**
 * ## Console file include this methods :
 * - print
 * - read lines
 * - environments and properties
 *
 * @author jakode
 * @since v1.0.0 07/17/2021
 */

/**
 * Prints the given messages to the standard output stream,
 * also you can define separator and end escape
 * @param message one,...,or more
 * @param separator default value is " "
 * @param end default value is "\n" (new line)
 */
fun <T> print(vararg message: T?, separator: String = " ", end: String = "\n") {
    kotlin.io.print(buildString {
        for (index in message.indices) {
            append(message[index])
            // The last element doesn't need separator
            if (index != message.size - 1) append(separator)
        }
        append(end)
    })
}

// readLines -------------------------------------------------------------------------------

private val INPUT = System.`in`
private val OUTPUT = System.out
private const val _BUFFER_SIZE = 1 shl 16
private val _buffer = ByteArray(_BUFFER_SIZE)
private var _bufferPt = 0
private var _bytesRead = 0

/** read only one character */
tailrec fun readChar(): Char {
    if (_bufferPt == _bytesRead) {
        _bufferPt = 0
        _bytesRead = INPUT.read(_buffer, 0, _BUFFER_SIZE)
    }
    return if (_bytesRead < 0) Char.MIN_VALUE
    else {
        val c = _buffer[_bufferPt++].toInt().toChar()
        if (c == '\r') readChar() else c
    }
}

/**
 * read n characters
 * @return CharArray
 * @param n number of characters to read
 * @param skipNext Whether to skip the next character (usually whitespace), defaults to true
 */
fun readCharArray(n: Int, skipNext: Boolean = true): CharArray {
    val res = CharArray(n) { readChar() }
    if (skipNext) readChar()
    return res
}

/** read a word not more than one, separate word with space (' ')*/
fun read() = buildString {
    var c = readChar()
    while (c <= ' ') {
        if (c == Char.MIN_VALUE) return@buildString
        c = readChar()
    }
    do {
        append(c)
        c = readChar()
    } while (c > ' ')
}

/** reads a Line */
fun readLine(): String? {
    var c = readChar()
    return if (c == Char.MIN_VALUE) null
    else buildString {
        while (c != '\n' && c != Char.MIN_VALUE) {
            append(c)
            c = readChar()
        }
    }
}

/** reads a line if you are sure it is not null*/
fun readLn() = readLine()!!

/**
 * read a [Int] number
 * @throws NumberFormatException if the string is not a valid representation of a number.
 */
fun readInt() = read().toInt()

/**
 * read a [Double] number
 * @throws NumberFormatException if the string is not a valid representation of a number.
 */
fun readDouble() = read().toDouble()

/**
 * read a [Long] number
 * @throws NumberFormatException if the string is not a valid representation of a number.
 */
fun readLong() = read().toLong()

/**
 * read strings, separate word with space (' ')
 * @param n number of worlds to read
 */
fun readStrings(n: Int) = List(n) { read() }

/**
 * read lines
 * @param n number of lines to read
 */
fun readLines(n: Int) = List(n) { readLn() }

/**
 * read [Int] numbers
 * @param n counter of numbers to read
 */
fun readInts(n: Int) = List(n) { read().toInt() }

/**
 * read [Int] numbers
 * @param n counter of numbers to read
 */
fun readIntArray(n: Int) = IntArray(n) { read().toInt() }

/**
 * read [Double] numbers
 * @param n counter of numbers to read
 */
fun readDoubles(n: Int) = List(n) { read().toDouble() }

/**
 * read [Double] numbers
 * @param n counter of numbers to read
 */
fun readDoubleArray(n: Int) = DoubleArray(n) { read().toDouble() }

/**
 * read [Long] numbers
 * @param n counter of numbers to read
 */
fun readLongs(n: Int) = List(n) { read().toLong() }

/**
 * read [Long] numbers
 * @param n counter of numbers to read
 */
fun readLongArray(n: Int) = LongArray(n) { read().toLong() }

// properties and environments --------------------------------------------------------------

/**
 * Gets the system property indicated by the specified key and default value.
 * @see System.getProperty
 * @see properties
 */
fun property(key: String, default: String? = null): String = System.getProperty(key, default)

/**
 * Determines the current system properties. First, if there is a security manager,
 * its checkPropertiesAccess method is called with no arguments. This may result in a security exception.
 * @see System.getProperties
 * @see property
 */
fun properties(): Properties = System.getProperties()

/**
 * Gets the value of the specified environment variable, When the key is invalid return null. An
 * environment variable is a system-dependent external named
 * value.
 * @see System.getenv
 * @see environments
 */
fun environment(name: String): String = System.getenv(name)

/**
 * Returns an unmodifiable string map view of the current system environment.
 * The environment is a system-dependent mapping from names to
 * values which is passed from parent to child processes.
 * @see System.getenv
 * @see environment
 */
fun environments(): MutableMap<String, String> = System.getenv()