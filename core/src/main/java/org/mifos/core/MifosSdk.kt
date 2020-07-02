package org.mifos.core

import android.content.Context
import android.util.Log
import org.mifos.core.apimanager.ApiEndPoints
import org.mifos.core.preferencesmanager.MifosPreferenceManager
import org.mifos.core.viewmodels.AuthViewModel

/**
 * Created by grandolf49 on 06-06-2020
 *
 * Access point to the sdk. All the services provided by the sdk will be accessed by calling the
 * getInstance() method. The sdk talks to the Data Manager layer to fetch the appropriate service
 * and return the response.
 */
class MifosSdk private constructor() {

    companion object {

        private var instance: MifosSdk? = null

        private var context: Context? = null

        fun initialize(context: Context) {
            this.context = context
            MifosPreferenceManager.init(context)
            MifosPreferenceManager.setInstanceUrl(ApiEndPoints.DEFAULT_INSTANCE_URL)
            Log.d("MifosSdk", "initialize: ")
        }

        fun getInstance(): MifosSdk {
            if (instance != null) {
                return instance!!
            }
            return MifosSdk()
        }
    }

    /**
     * Return APIs
     */
    fun getAuthApi(): AuthViewModel {
        return AuthViewModel()
    }
}