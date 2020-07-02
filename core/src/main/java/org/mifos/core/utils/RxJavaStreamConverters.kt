package org.mifos.core.utils

import androidx.lifecycle.LiveData
import androidx.lifecycle.LiveDataReactiveStreams
import io.reactivex.Flowable

/**
 * Created by grandolf49 on 27-06-2020
 */

/**
 * Extension function to convert a Flowable object to LiveData.
 */
fun <T> Flowable<T>.toLiveData(): LiveData<T> {
    return LiveDataReactiveStreams.fromPublisher(this)
}