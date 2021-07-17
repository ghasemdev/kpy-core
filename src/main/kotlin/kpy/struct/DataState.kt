package kpy.struct

/**
 * DataState has three mode
 * + Success : return data and status
 * + Error   : throw exception
 * + Loading : loading and not coming
 *
 * @author jakode2020
 * @since v1.0.0 7/13/2021
 */
sealed interface DataState<out M, out N> {

    data class Success<T, K>(val data: T, val status: K) : DataState<T, K>

    data class Error(val exception: Exception) : DataState<Nothing, Nothing>

    object Loading : DataState<Nothing, Nothing>
}