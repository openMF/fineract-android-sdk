package org.mifos.core.repositories

import org.mifos.core.BaseApiManager
import org.mifos.core.models.user.User
import rx.Observable

/**
 * Created by grandolf49 on 06-06-2020
 */
class AuthRepository {

    // This will later be replaced by Dependency Injection
    private var baseApiManager: BaseApiManager = BaseApiManager()

    fun login(username: String, password: String): Observable<User>? {
        return baseApiManager.getAuthApi()?.authenticate(username, password)
    }
}