package kpy.utils

import java.awt.Color
import java.awt.Color.decode

/** convert hex color to AWT color */
inline val String.awtColor: Color?
    get() {
        val r = substring(1, 3).toIntOrNull(16) ?: return null
        val g = substring(3, 5).toIntOrNull(16) ?: return null
        val b = substring(5, 7).toIntOrNull(16) ?: return null
        return Color(r, g, b)
    }

/** convert hex color to RGB */
inline val String.hexToRGB: Triple<String, String, String>
    get() {
        var name = this
        if (!name.startsWith("#")) {
            name = "#$this"
        }
        val color = decode(name)
        val red = color.red
        val green = color.green
        val blue = color.blue

        return Triple(red.toString(), green.toString(), blue.toString())
    }

/** convert color to Hex */
inline val Int.colorToHexString: String
    get() = String.format("#%06X", -0x1 and this).replace("#FF", "#")