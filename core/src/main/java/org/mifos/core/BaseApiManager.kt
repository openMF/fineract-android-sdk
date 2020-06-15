package org.mifos.core

import org.mifos.core.BaseUrl.Companion.API_ENDPOINT
import org.mifos.core.BaseUrl.Companion.API_PATH
import org.mifos.core.BaseUrl.Companion.PROTOCOL_HTTPS
import org.mifos.core.services.AuthService
import retrofit2.Retrofit
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.converter.scalars.ScalarsConverterFactory

/**
 * Created by grandolf49 on 06-06-2020
 */
class BaseApiManager {

    private var mRetrofit: Retrofit? = null
    private var authApi: AuthService? = null

    init {
        mRetrofit = Retrofit.Builder()
            .baseUrl(getInstanceUrl())
            .addConverterFactory(ScalarsConverterFactory.create())
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
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