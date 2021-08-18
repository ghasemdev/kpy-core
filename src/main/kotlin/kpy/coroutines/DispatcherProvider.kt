package kpy.coroutines

import kotlinx.coroutines.CoroutineDispatcher

/**
 * ## DispatcherProvider
 * In coroutines, we need special dispatchers for a scope,
 * and in a large project to manage these dispatchers in the main source and test source,
 * we can use the implementation of this interface.
 *
 * @author jakode
 * @since v1.0.0 08/19/2021
 * @see StandardDispatcher
 * @see TestDispatcher
 */
interface DispatcherProvider {
    val main: CoroutineDispatcher
    val io: CoroutineDispatcher
    val default: CoroutineDispatcher
    val unconfined: CoroutineDispatcher
}