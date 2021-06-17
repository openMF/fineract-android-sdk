package org.mifos.core.apihelper

import java.lang.Exception

/**
 * This class is used as a data interface between network calls and
 * business logic.
 * @author Danish Jamal - http://github.com/danishjamal104/
 * @see apiRequest
 */
sealed class DataState<out R> {
    data class Success<out T>(val data: T) : DataState<T>()
    data class Error(val exception: Exception) : DataState<Nothing>()
}
