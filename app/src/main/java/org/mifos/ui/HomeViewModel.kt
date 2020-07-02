package org.mifos.ui

import android.content.Context
import androidx.lifecycle.ViewModel
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers
import org.mifos.core.MifosSdk
import org.mifos.core.apimanager.ApiEndPoints
import org.mifos.core.models.client.Page
import org.mifos.core.models.group.Center
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
            ApiEndPoints.CENTERS -> {
                getCenters(
                    false, 0, 0,
                    onSuccess,
                    onError,
                    onComplete
                )
            }
        }
    }

    /**
     * Login Api
     */
    private fun login(
        username: String, password: String,
        onSuccess: (User) -> Unit,
        onError: (error: Throwable) -> Unit,
        onComplete: () -> Unit
    ): Disposable? {
        return mifosSdk.getAuthApi().login(username, password)?.toObservable()
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

    /**
     * Center Api
     */
    private fun getCenters(
        paged: Boolean = false, offset: Int = 0, limit: Int = 0,
        onSuccess: (Page<Center?>) -> Unit,
        onError: (error: Throwable) -> Unit,
        onComplete: () -> Unit
    ): Disposable? {
        return mifosSdk.getCenterApi().getCenters(paged, offset, limit)?.toObservable()
            ?.observeOn(AndroidSchedulers.mainThread())
            ?.subscribeOn(Schedulers.io())
            ?.subscribe(
                { centers ->
                    onSuccess(centers!!)
                },
                { error ->
                    onError(error)
                }, { onComplete() }
            )
    }
}