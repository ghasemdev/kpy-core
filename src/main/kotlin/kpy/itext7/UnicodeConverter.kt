package kpy.itext7

import kpy.util.extension.appendSpace
import kpy.util.extension.isAlphanumeric
import kpy.util.extension.isDigit
import kpy.util.extension.isPersianDigit

/**
 * # Unicode Converter
 * Convert text to persian unicode
 * @author Jakode
 * @since v1.1.0 07/21/2021
 */
object UnicodeConverter {

    /**
     * This method get a persian text and convert that to arabic script unicode.
     * in **persian** or **arabic** some character have a four shape :
     * * Isolated
     * * Beginning
     * * Middle
     * * End
     * @param text
     * @return unicode text
     */
    fun toPersianUnicode(text: String): String {
        val sentence = text.split(" ")
        return buildString {
            for (word in sentence) {
                if (word.isAlphanumeric) {
                    val reversedWord = word.reversed()
                    if (reversedWord.isDigit) {
                        append(toPersianNumber(reversedWord))
                    } else {
                        append(reversedWord)
                    }
                } else if (word.isPersianDigit) {
                    append(word.reversed())
                } else {
                    append(toUnicode(word))
                }
                appendSpace()
            }
        }.trimEnd().reversed()
    }

    /**
     * covert english number to persian number
     * @param text
     * @return unicode text
     */
    fun toPersianNumber(text: String): String {
        fun toUnicode(character: Char) = when (character) {
            '0' -> "\u06F0"
            '1' -> "\u06F1"
            '2' -> "\u06F2"
            '3' -> "\u06F3"
            '4' -> "\u06F4"
            '5' -> "\u06F5"
            '6' -> "\u06F6"
            '7' -> "\u06F7"
            '8' -> "\u06F8"
            '9' -> "\u06F9"
            else -> ""
        }
        return buildString {
            for (character in text) append(toUnicode(character))
        }
    }

    private fun toUnicode(text: String): String {
        val unicode = mutableListOf<Pair<Character.State, String>>()
        for (index in text.indices) {
            val currentChar = Character(text[index])

            if (!currentChar.isPersianCharacter()) {
                unicode.add(Pair(Character.State.Isolated, reverseCharacter(text[index]).toString()))
            } else {
                if (index == 0) {
                    if (currentChar.numberOfShape() == 2) {
                        unicode.add(Pair(Character.State.Isolated, currentChar.isolated))
                    } else {
                        if (text.length == 1) {
                            unicode.add(Pair(Character.State.Isolated, currentChar.isolated))
                        } else {
                            unicode.add(Pair(Character.State.Beginning, currentChar.beginning))
                        }
                    }
                } else {
                    val previousChar = Character(text[index - 1])

                    if (previousChar.numberOfShape() <= 2) {
                        unicode.add(Pair(Character.State.Isolated, currentChar.isolated))
                    } else if (previousChar.numberOfShape() == 4) {
                        when (unicode.last().first) {
                            Character.State.Isolated -> {
                                unicode[index - 1] = Pair(Character.State.Beginning, previousChar.beginning)
                                unicode.add(Pair(Character.State.End, currentChar.end))
                            }
                            Character.State.Beginning -> {
                                unicode.add(Pair(Character.State.End, currentChar.end))
                            }
                            Character.State.Middle -> Unit
                            Character.State.End -> {
                                unicode[index - 1] = Pair(Character.State.Middle, previousChar.middle)
                                unicode.add(Pair(Character.State.End, currentChar.end))
                            }
                        }
                    }
                }
            }
        }
        return unicode.joinToString("") { it.second }
    }

    private fun reverseCharacter(character: Char): Char {
        return when (character) {
            '(' -> ')'
            ')' -> '('
            '[' -> ']'
            ']' -> '['
            '{' -> '}'
            '}' -> '{'
            '>' -> '<'
            '<' -> '>'
            '»' -> '«'
            '«' -> '»'
            else -> character
        }
    }

    private class Character(character: Char) {

        enum class State { Isolated, Beginning, Middle, End }

        var isolated: String = ""
        var beginning: String = ""
        var middle: String = ""
        var end: String = ""

        init {
            when (character) {
                'ا' -> {
                    isolated = "\uFE8D"
                    end = "\uFE8E"
                }
                'ب' -> {
                    isolated = "\uFE8F"
                    beginning = "\uFE91"
                    middle = "\uFE92"
                    end = "\uFE90"
                }
                'پ' -> {
                    isolated = "\uFB56"
                    beginning = "\uFB58"
                    middle = "\uFB59"
                    end = "\uFB57"
                }
                'ت' -> {
                    isolated = "\uFE95"
                    beginning = "\uFE97"
                    middle = "\uFE98"
                    end = "\uFE96"
                }
                'ث' -> {
                    isolated = "\uFE99"
                    beginning = "\uFE9B"
                    middle = "\uFE9C"
                    end = "\uFE9A"
                }
                'ج' -> {
                    isolated = "\uFE9D"
                    beginning = "\uFE9F"
                    middle = "\uFEA0"
                    end = "\uFE9E"
                }
                'چ' -> {
                    isolated = "\uFB7A"
                    beginning = "\uFB7C"
                    middle = "\uFB7D"
                    end = "\uFB7B"
                }
                'ح' -> {
                    isolated = "\uFEA1"
                    beginning = "\uFEA3"
                    middle = "\uFEA4"
                    end = "\uFEA2"
                }
                'خ' -> {
                    isolated = "\uFEA5"
                    beginning = "\uFEA7"
                    middle = "\uFEA8"
                    end = "\uFEA6"
                }
                'د' -> {
                    isolated = "\uFEA9"
                    end = "\uFEAA"
                }
                'ذ' -> {
                    isolated = "\uFEAB"
                    end = "\uFEAC"
                }
                'ر' -> {
                    isolated = "\uFEAD"
                    end = "\uFEAE"
                }
                'ز' -> {
                    isolated = "\uFEAF"
                    end = "\uFEB0"
                }
                'ژ' -> {
                    isolated = "\uFB8A"
                    end = "\uFB8B"
                }
                'س' -> {
                    isolated = "\uFEB1"
                    beginning = "\uFEB3"
                    middle = "\uFEB4"
                    end = "\uFEB2"
                }
                'ش' -> {
                    isolated = "\uFEB5"
                    beginning = "\uFEB7"
                    middle = "\uFEB8"
                    end = "\uFEB6"
                }
                'ص' -> {
                    isolated = "\uFEB9"
                    beginning = "\uFEBB"
                    middle = "\uFEBC"
                    end = "\uFEBA"
                }
                'ض' -> {
                    isolated = "\uFEBD"
                    beginning = "\uFEBF"
                    middle = "\uFEC0"
                    end = "\uFEBE"
                }
                'ط' -> {
                    isolated = "\uFEC1"
                    beginning = "\uFEC3"
                    middle = "\uFEC4"
                    end = "\uFEC2"
                }
                'ظ' -> {
                    isolated = "\uFEC5"
                    beginning = "\uFEC7"
                    middle = "\uFEC8"
                    end = "\uFEC6"
                }
                'ع' -> {
                    isolated = "\uFEC9"
                    beginning = "\uFECB"
                    middle = "\uFECC"
                    end = "\uFECA"
                }
                'غ' -> {
                    isolated = "\uFECD"
                    beginning = "\uFECF"
                    middle = "\uFED0"
                    end = "\uFECE"
                }
                'ف' -> {
                    isolated = "\uFED1"
                    beginning = "\uFED3"
                    middle = "\uFED4"
                    end = "\uFED2"
                }
                'ق' -> {
                    isolated = "\uFED5"
                    beginning = "\uFED7"
                    middle = "\uFED8"
                    end = "\uFED6"
                }
                'ک' -> {
                    isolated = "\uFB8E"
                    beginning = "\uFB90"
                    middle = "\uFB91"
                    end = "\uFB8F"
                }
                'گ' -> {
                    isolated = "\uFB92"
                    beginning = "\uFB94"
                    middle = "\uFB95"
                    end = "\uFB93"
                }
                'ل' -> {
                    isolated = "\uFEDD"
                    beginning = "\uFEDF"
                    middle = "\uFEE0"
                    end = "\uFEDE"
                }
                'م' -> {
                    isolated = "\uFEE1"
                    beginning = "\uFEE3"
                    middle = "\uFEE4"
                    end = "\uFEE2"
                }
                'ن' -> {
                    isolated = "\uFEE5"
                    beginning = "\uFEE7"
                    middle = "\uFEE8"
                    end = "\uFEE6"
                }
                'ه' -> {
                    isolated = "\uFEE9"
                    beginning = "\uFEEB"
                    middle = "\uFEEC"
                    end = "\uFEEA"
                }
                'ة' -> {
                    isolated = "\uFE93"
                    end = "\uFE94"
                }
                'و' -> {
                    isolated = "\uFEED"
                    end = "\uFEEE"
                }
                'ی' -> {
                    isolated = "\uFBFC"
                    beginning = "\uFBFE"
                    middle = "\uFBFF"
                    end = "\uFBFD"
                }
                'ئ' -> {
                    isolated = "\uFE89"
                    beginning = "\uFE8B"
                    middle = "\uFE8C"
                    end = "\uFE8A"
                }
            }
        }

        override fun toString() = "isolated = $isolated, beginning = $beginning, middle = $middle, end = $end"

        fun numberOfShape(): Int {
            var result = 0
            if (isolated.isNotEmpty()) result++
            if (beginning.isNotEmpty()) result++
            if (middle.isNotEmpty()) result++
            if (end.isNotEmpty()) result++
            return result
        }

        fun isPersianCharacter() = numberOfShape() != 0
    }
}