package org.mifos.ui

import android.annotation.SuppressLint
import android.content.Context
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

    var homeListener: HomeListener? = null

    lateinit var context: Context

    private var mifosSdk = MifosSdk.getInstance()

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
        username: String, password: String,
        onSuccess: (User) -> Unit,
        onError: (error: Throwable) -> Unit,
        onComplete: () -> Unit
    ) {
        mifosSdk.getAuthApi().login(username, password)?.toObservable()
            ?.observeOn(AndroidSchedulers.mainThread())
            ?.subscribeOn(Schedulers.io())
            ?.subscribe(
                { user -> onSuccess(user) },
                { error -> onError(error) },
                { onComplete() }
            )
        /**
         * Get response in the form of LiveData
         *
         * val response1: LiveData<User>? = mifosSdk.getAuthApi().login("mifos", "password")?.toLiveData()
         * // process response1 further
         */
    }
}