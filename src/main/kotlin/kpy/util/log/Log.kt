package kpy.util.log

import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

/**
 * ## Logging massage in console
 * Each logging function has its own color corresponding to its function, which makes it easier to detect.
 * for debug coroutines set `(-Dkotlinx.coroutines.debug)` to VM Option
 *
 * @author jakode
 * @since v1.0.0 07/17/2021
 */
object Log {
    private val dateFormat = DateTimeFormatter.ofPattern("MM/dd/yyyy-HH:mm:SS")

    /** log INFO massage with time, current thread and tag */
    fun i(massage: String, tag: String? = null) {
        val (now, thread, _tag) = logInit(tag)
        println(ConsoleColors.CYAN + "[$now] [$thread] INFO$_tag $massage" + ConsoleColors.RESET)
    }

    /** log DEBUG massage with time, current thread and tag */
    fun d(massage: String, tag: String? = null) {
        val (now, thread, _tag) = logInit(tag)
        println(ConsoleColors.PURPLE + "[$now] [$thread] DEBUG$_tag $massage" + ConsoleColors.RESET)
    }

    /** log WARN massage with time, current thread and tag */
    fun w(massage: String, tag: String? = null) {
        val (now, thread, _tag) = logInit(tag)
        println(ConsoleColors.YELLOW + "[$now] [$thread] WARN$_tag $massage" + ConsoleColors.RESET)
    }

    /** log ERROR massage with time, current thread and tag */
    fun e(error: Throwable, tag: String? = null) {
        val (now, thread, _tag) = logInit(tag)
        println(ConsoleColors.RED + "[$now] [$thread] ERROR$_tag $error" + ConsoleColors.RESET)
    }

    private fun logInit(tag: String?): Triple<String, String, String> {
        val now = LocalDateTime.now().format(dateFormat)
        val thread = Thread.currentThread().name
        val _tag = tag?.let { "/$it" } ?: ""
        return Triple(now, thread, _tag)
    }
}