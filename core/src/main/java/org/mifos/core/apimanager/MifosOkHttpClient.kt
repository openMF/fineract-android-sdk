package org.mifos.core.apimanager

import android.annotation.SuppressLint
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import java.security.SecureRandom
import java.security.cert.CertificateException
import java.security.cert.X509Certificate
import java.util.concurrent.TimeUnit
import javax.net.ssl.*


/**
 * Created by grandolf49 on 18-06-2020
 *
 * OkHttpClient to disable SSL certificate validation in Retrofit
 */
object MifosOkHttpClient {

    val mifosOkHttpClient: OkHttpClient
        get() = try {
            val trustAllCerts = arrayOf<TrustManager>(object : X509TrustManager {
                @SuppressLint("TrustAllX509TrustManager")
                @Throws(CertificateException::class)
                override fun checkClientTrusted(chain: Array<X509Certificate>, authType: String) {
                }

                @SuppressLint("TrustAllX509TrustManager")
                @Throws(CertificateException::class)
                override fun checkServerTrusted(chain: Array<X509Certificate>, authType: String) {
                }

                override fun getAcceptedIssuers(): Array<X509Certificate> {
                    return arrayOf()
                }
            })
            val sslContext = SSLContext.getInstance("SSL")
            sslContext.init(null, trustAllCerts, SecureRandom())
            val builder = OkHttpClient.Builder()

            builder.sslSocketFactory(sslContext.socketFactory,trustAllCerts[0] as X509TrustManager)
            builder.hostnameVerifier(HostnameVerifier { _, _ -> true })

            //Enable Full Body Logging
            val logger = HttpLoggingInterceptor()
            logger.setLevel(HttpLoggingInterceptor.Level.BODY)

            //Setting Timeout 30 Seconds
            builder.connectTimeout(60, TimeUnit.SECONDS)
            builder.readTimeout(60, TimeUnit.SECONDS)

            //Interceptor :> Full Body Logger and ApiRequest Header
            builder.addInterceptor(logger)
            builder.build()
        } catch (e: Exception) {
            throw RuntimeException(e)
        }
}