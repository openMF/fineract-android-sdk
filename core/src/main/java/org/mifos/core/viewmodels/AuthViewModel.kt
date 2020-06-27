package org.mifos.core.viewmodels

import org.mifos.core.MifosSdk.Companion.RESPONSE_TYPE_LIVEDATA
import org.mifos.core.MifosSdk.Companion.RESPONSE_TYPE_OBSERVABLE
import org.mifos.core.repositories.AuthRepository
import org.mifos.core.toLiveData

/**
 * Created by grandolf49 on 27-06-2020
 */
class AuthViewModel {

    private val authRepository = AuthRepository()

    private var responseType: String = RESPONSE_TYPE_OBSERVABLE

    fun login(username: String, password: String): Any? {
        if (responseType == RESPONSE_TYPE_LIVEDATA) {
            return authRepository.login(username, password)?.toLiveData()
        }
        return authRepository.login(username, password)?.toObservable()
    }

    fun setResponseType(responseType: String): AuthViewModel {
        this.responseType = responseType
        return this
    }
}