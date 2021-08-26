package kpy.struct

import com.google.common.truth.Truth.assertThat
import org.junit.jupiter.api.Test

class ResultKtTest {

    @Test
    fun resultState() {
        val fooError = Result.Error(Exception())
        val fooSuccess = Result.Success(Foo("foo"))
        val fooLoading = Result.Loading

        assertThat(getData(fooError)).isEqualTo("Error")
        assertThat(getData(fooSuccess)).isEqualTo("Success")
        assertThat(getData(fooLoading)).isEqualTo("Loading")
    }

    private fun getData(data: Result<Foo>): String {
        return when (data) {
            is Result.Success -> "Success"
            is Result.Error -> "Error"
            is Result.Loading -> "Loading"
        }
    }

    data class Foo(val foo: String)
}