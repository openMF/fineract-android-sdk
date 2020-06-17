package org.mifos.ui

import android.content.Context
import android.widget.TextView
import androidx.lifecycle.ViewModel
import org.mifos.core.ApiEndPoint
import org.mifos.core.MifosSdk
import rx.android.schedulers.AndroidSchedulers
import rx.schedulers.Schedulers

/**
 * Created by grandolf49 on 16-06-2020
 *
 * ViewModel class for HomeActivity. An example to illustrate how the SDK should be used.
 */
class HomeViewModel : ViewModel() {

    var homeListener: HomeListener? = null

    var context: Context? = null

    private var mifosSdk: MifosSdk = MifosSdk.Builder().setContext(context).build()

    fun testApi(apiEndPoint: String?, textViewApiResponse: TextView) {
        when (apiEndPoint) {
            ApiEndPoint.AUTHENTICATION -> login(textViewApiResponse)
        }
    }

    private fun login(textViewApiResponse: TextView) {
        mifosSdk.getAuthApi().login("mifos", "password")
            ?.observeOn(AndroidSchedulers.mainThread())
            ?.subscribeOn(Schedulers.io())
            ?.subscribe(
                { user ->
                    textViewApiResponse.text = user.toString()
                },
                { error ->
                    textViewApiResponse.text = error.toString()
                }
            )
    }
}