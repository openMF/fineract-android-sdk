package org.mifos.core.repositories

import io.reactivex.Flowable
import org.mifos.core.BaseApiManager
import org.mifos.core.models.user.User

/**
 * Created by grandolf49 on 06-06-2020
 *
 * A Singleton Repository class to provide data retrieval from AuthService
 */
class AuthRepository private constructor() {
    companion object {
        val instance = AuthRepository()
    }

    // This will later be replaced by Dependency Injection
    private var baseApiManager: BaseApiManager = BaseApiManager()

    fun login(username: String, password: String): Flowable<User>? {
        return baseApiManager.getAuthApi()?.authenticate(username, password)
    }
}