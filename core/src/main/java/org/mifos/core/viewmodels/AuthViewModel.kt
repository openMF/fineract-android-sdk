package org.mifos.core.viewmodels

import io.reactivex.Flowable
import org.mifos.core.models.user.User
import org.mifos.core.repositories.AuthRepository

/**
 * Created by grandolf49 on 27-06-2020
 *
 * ViewModel class for Authentication to provide LiveData and Observable as response types.
 */
class AuthViewModel {

    private val authRepository = AuthRepository.instance

    fun login(username: String, password: String): Flowable<User>? {
        return authRepository.login(username, password)
    }
}