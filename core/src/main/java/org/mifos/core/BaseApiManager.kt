package org.mifos.core

import org.mifos.core.APIEndPoint.Companion.INSTANCE_URL
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
            .baseUrl(INSTANCE_URL)
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
}