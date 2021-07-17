package kpy.util.log

import com.google.common.truth.Truth.assertThat
import org.junit.jupiter.api.AfterAll
import org.junit.jupiter.api.BeforeAll
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.TestInstance
import java.io.ByteArrayOutputStream
import java.io.PrintStream

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class LogTest {
    private val outContent = ByteArrayOutputStream()
    private val originalOut = System.out

    private val errContent = ByteArrayOutputStream()
    private val originalErr = System.err

    @BeforeAll
    fun setUpStreams() {
        System.setOut(PrintStream(outContent))
        System.setErr(PrintStream(errContent))
    }

    @AfterAll
    fun restoreStreams() {
        System.setOut(originalOut)
        System.setErr(originalErr)
    }

    @Test
    fun `log INFO`() {
        Log.i("This is a test")
        assertThat(outContent.toString()).contains("This is a test")
    }

    @Test
    fun `log DEBUG`() {
        Log.d("This is a test")
        assertThat(outContent.toString()).contains("This is a test")
    }

    @Test
    fun `log WARN`() {
        Log.w("This is a test")
        assertThat(outContent.toString()).contains("This is a test")
    }

    @Test
    fun `log ERROR`() {
        Log.e(Exception("This is a test"))
        assertThat(outContent.toString()).contains("This is a test")
    }

    @Test
    fun `log INFO with tag`() {
        Log.i("This is a test", tag = "someTag")
        assertThat(outContent.toString()).contains("someTag")
    }

    @Test
    fun `log DEBUG with tag`() {
        Log.d("This is a test", tag = "someTag")
        assertThat(outContent.toString()).contains("someTag")
    }

    @Test
    fun `log WARN with tag`() {
        Log.w("This is a test", tag = "someTag")
        assertThat(outContent.toString()).contains("someTag")
    }

    @Test
    fun `log ERROR with tag`() {
        Log.e(Exception("This is a test"), tag = "someTag")
        assertThat(outContent.toString()).contains("someTag")
    }
}