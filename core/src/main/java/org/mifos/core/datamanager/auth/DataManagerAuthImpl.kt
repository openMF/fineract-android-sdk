package org.mifos.core.datamanager.auth

import org.apache.fineract.client.models.PostAuthenticationResponse
import org.mifos.core.apimanager.BaseApiManager
import rx.Observable

class DataManagerAuthImpl(private val baseApiManager: BaseApiManager) : DataManagerAuth {

    override fun  login(username: String, password: String): Observable<PostAuthenticationResponse>? {
        baseApiManager.createService(username, password)
        val body = "{ \"username\": \"$username\", \"password\": \"$password\" }"
        return baseApiManager.getAuthApi()?.authenticate(false, body)
    }
}