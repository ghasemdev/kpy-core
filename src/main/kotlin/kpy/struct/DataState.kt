package kpy.struct

/**
 * DataState has three mode
 * + Success : return data
 * + Error   : throw exception
 * + Loading : loading and not coming
 * @author jakode2020
 * @since v2.0.1 7/25/2021
 */
sealed interface DataState<out R> {

    data class Success<T>(val data: T) : DataState<T>

    data class Error(val exception: Exception) : DataState<Nothing>

    object Loading : DataState<Nothing>
}