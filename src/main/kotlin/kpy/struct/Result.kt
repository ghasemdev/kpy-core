package kpy.struct

/**
 * Result has three mode
 * + Success : return data
 * + Error   : throw exception
 * + Loading : loading and not coming
 * @author jakode2020
 * @since v2.0.1 7/25/2021
 */
sealed interface Result<out R> {

    data class Success<T>(val data: T) : Result<T>

    data class Error(val exception: Exception) : Result<Nothing>

    object Loading : Result<Nothing>
}