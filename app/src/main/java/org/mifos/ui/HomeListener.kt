package org.mifos.ui

/**
 * Created by grandolf49 on 16-06-2020
 */
interface HomeListener {

    fun onSuccess(response: String)

    fun onFailure(message: String)

}