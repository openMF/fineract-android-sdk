package org.mifos.core.datamanager.auth

import org.apache.fineract.client.models.PostAuthenticationResponse
import org.mifos.core.apimanager.BaseApiManager
import rx.Observable

interface DataManagerAuth {

    companion object {
        fun getInstance(baseApiManager: BaseApiManager): DataManagerAuth {
            return DataManagerAuthImpl(baseApiManager)
        }
    }

    /**
     * @param username Username
     * @param password Password
     * @return Basic OAuth
     */
    fun  login(username: String, password: String): Observable<PostAuthenticationResponse>?
}