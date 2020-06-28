package org.mifos.ui

import android.annotation.SuppressLint
import android.content.Context
import android.view.View.GONE
import android.widget.ProgressBar
import android.widget.TextView
import androidx.lifecycle.ViewModel
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import org.mifos.core.ApiEndPoints
import org.mifos.core.MifosSdk
import org.mifos.core.models.user.User

/**
 * Created by grandolf49 on 16-06-2020
 *
 * ViewModel class for HomeActivity. An example to illustrate how the SDK should be used.
 */
@Suppress("UNCHECKED_CAST")
class HomeViewModel : ViewModel() {

    var homeListener: HomeListener? = null

    var context: Context? = null

    private var mifosSdk: MifosSdk = MifosSdk.Builder().setContext(context).build()

    fun testApi(
        apiEndPoint: String?,
        textViewApiResponse: TextView,
        pbApiResponse: ProgressBar
    ) {
        when (apiEndPoint) {
            ApiEndPoints.AUTHENTICATION -> login(textViewApiResponse, pbApiResponse)
        }
    }

    @SuppressLint("CheckResult")
    private fun login(
        textViewApiResponse: TextView,
        pbApiResponse: ProgressBar
    ) {
        /**
         * Get response in the form of Observable
         */
        val response: Observable<User>? =
            mifosSdk.getAuthApi().login("mifos", "password")?.toObservable()
        response?.observeOn(AndroidSchedulers.mainThread())
            ?.subscribeOn(Schedulers.io())
            ?.subscribe(
                { user ->
                    textViewApiResponse.text = user.toString()
                    homeListener?.onSuccess("Successful")
                },
                { error ->
                    textViewApiResponse.text = error.toString()
                    pbApiResponse.visibility = GONE
                    homeListener?.onFailure(error.toString())
                },
                {
                    pbApiResponse.visibility = GONE
                }
            )

        /**
         * Get response in the form of LiveData
         *
         * val response1: LiveData<User>? = mifosSdk.getAuthApi().login("mifos", "password")?.toLiveData()
         */

    }
}