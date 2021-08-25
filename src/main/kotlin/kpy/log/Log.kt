package kpy.log

import kpy.utils.dateTimeFormatter
import kpy.utils.ifNotNull
import java.time.LocalDateTime

/**
 * ## Logging massage in console
 * Each logging function has its own color corresponding to its function, which makes it easier to detect.
 * for debug coroutines set `(-Dkotlinx.coroutines.debug)` to VM Option
 *
 * @author jakode
 * @since v2.0.0 08/25/2021
 */
object Log {
    /** log INFO massage with time, current thread and tag */
    fun i(massage: Any, tag: String? = null) {
        val (now, thread) = logInit()
        println(
            ConsoleColors.CYAN + "[$now] [$thread] INFO${
                tag.ifNotNull { "/$it" }.orEmpty()
            } $massage" + ConsoleColors.RESET
        )
    }

    /** log DEBUG massage with time, current thread and tag */
    fun d(massage: Any, tag: String? = null) {
        val (now, thread) = logInit()
        println(
            ConsoleColors.PURPLE + "[$now] [$thread] DEBUG${
                tag.ifNotNull { "/$it" }.orEmpty()
            } $massage" + ConsoleColors.RESET
        )
    }

    /** log WARN massage with time, current thread and tag */
    fun w(massage: Any, tag: String? = null) {
        val (now, thread) = logInit()
        println(
            ConsoleColors.YELLOW + "[$now] [$thread] WARN${
                tag.ifNotNull { "/$it" }.orEmpty()
            } $massage" + ConsoleColors.RESET
        )
    }

    /** log ERROR massage with time, current thread and tag */
    fun e(error: Throwable, tag: String? = null) {
        val (now, thread) = logInit()
        println(
            ConsoleColors.RED + "[$now] [$thread] ERROR${
                tag.ifNotNull { "/$it" }.orEmpty()
            } $error" + ConsoleColors.RESET
        )
    }

    private fun logInit(): Pair<String, String> {
        val now = LocalDateTime.now().format(dateTimeFormatter)
        val thread = Thread.currentThread().name
        return Pair(now, thread)
    }
}