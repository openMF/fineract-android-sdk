package org.mifos.core.apimanager

import org.mifos.core.apimanager.BaseUrl.Companion.API_ENDPOINT
import org.mifos.core.apimanager.BaseUrl.Companion.API_PATH
import org.mifos.core.apimanager.BaseUrl.Companion.PROTOCOL_HTTPS
import org.mifos.core.apimanager.MifosOkHttpClient.mifosOkHttpClient
import org.mifos.core.services.AuthService
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.converter.scalars.ScalarsConverterFactory

/**
 * Created by grandolf49 on 06-06-2020
 *
 * A class to provide the Retrofit service to the SDK
 */
class BaseApiManager {

    private var mRetrofit: Retrofit? = null
    private var authApi: AuthService? = null

    init {
        mRetrofit = Retrofit.Builder()
            .baseUrl(getInstanceUrl())
            .addConverterFactory(ScalarsConverterFactory.create())
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .client(mifosOkHttpClient)
            .build()
        init()
    }

    private fun init() {
        authApi = mRetrofit?.create(AuthService::class.java)
    }

    fun getAuthApi(): AuthService? {
        return authApi
    }

    private fun getInstanceUrl(): String {
        return PROTOCOL_HTTPS + API_ENDPOINT + API_PATH
    }
}