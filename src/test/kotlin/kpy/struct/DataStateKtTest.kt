package kpy.struct

import com.google.common.truth.Truth.assertThat
import org.junit.jupiter.api.Test

class DataStateKtTest {

    @Test
    fun dataState() {
        val fooError = DataState.Error(Exception())
        val fooSuccess = DataState.Success(Foo("foo"))
        val fooLoading = DataState.Loading

        assertThat(getData(fooError)).isEqualTo("Error")
        assertThat(getData(fooSuccess)).isEqualTo("Success")
        assertThat(getData(fooLoading)).isEqualTo("Loading")
    }

    private fun getData(data: DataState<Foo>): String {
        return when (data) {
            is DataState.Success -> "Success"
            is DataState.Error -> "Error"
            is DataState.Loading -> "Loading"
        }
    }

    data class Foo(val foo: String)
}