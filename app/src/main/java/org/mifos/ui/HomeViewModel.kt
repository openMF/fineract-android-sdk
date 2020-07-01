package org.mifos.ui

import android.annotation.SuppressLint
import android.content.Context
import android.util.Log
import androidx.lifecycle.ViewModel
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import org.mifos.core.MifosSdk
import org.mifos.core.apimanager.ApiEndPoints
import org.mifos.core.models.user.User

/**
 * Created by grandolf49 on 16-06-2020
 *
 * ViewModel class for HomeActivity. An example to illustrate how the SDK should be used.
 */
class HomeViewModel : ViewModel() {

    private val TAG = HomeViewModel::class.java.name

    var homeListener: HomeListener? = null

    var context: Context? = null

    private var mifosSdk: MifosSdk = MifosSdk.Builder().setContext(context).build()

    fun testApi(
        apiEndpoint: String,
        onSuccess: (Any) -> Unit,
        onError: (error: Throwable) -> Unit,
        onComplete: () -> Unit
    ) {
        when (apiEndpoint) {
            ApiEndPoints.AUTHENTICATION -> {
                login(
                    "mifos",
                    "password",
                    onSuccess,
                    onError,
                    onComplete
                )
            }
        }
    }

    @SuppressLint("CheckResult")
    private fun login(
        username: String,
        password: String,
        onSuccess: (User) -> Unit,
        onError: (error: Throwable) -> Unit,
        onComplete: () -> Unit
    ) {
        mifosSdk.getAuthApi().login(username, password)?.toObservable()
            ?.observeOn(AndroidSchedulers.mainThread())
            ?.subscribeOn(Schedulers.io())
            ?.subscribe(
                { user ->
                    Log.d(TAG, "login successful: $user")
                    onSuccess(user)
                },
                { error ->
                    Log.d(TAG, "error: ${error.message}")
                    onError(error)
                },
                {
                    Log.d(TAG, "login: complete")
                    onComplete()
                })
        /**
         * Get response in the form of LiveData
         *
         * val response1: LiveData<User>? = mifosSdk.getAuthApi().login("mifos", "password")?.toLiveData()
         * // process response1 further
         */
    }
}