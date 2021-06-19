package org.mifos.core.datamanager

import androidx.lifecycle.LiveData
import org.apache.fineract.client.models.PostAuthenticationResponse
import org.mifos.core.apihelper.DataState
import org.mifos.core.apihelper.apiRequest
import org.mifos.core.apimanager.BaseApiManager

class DataManagerAuth(private val baseApiManager: BaseApiManager) {

    /**
     * @param username Username
     * @param password Password
     * @return Basic OAuth
     */
    fun  login(username: String, password: String): LiveData<DataState<PostAuthenticationResponse>> {
        baseApiManager.createService(username, password)
        return apiRequest(baseApiManager.getAuthApi()?.authenticate(false, ""))
    }
}