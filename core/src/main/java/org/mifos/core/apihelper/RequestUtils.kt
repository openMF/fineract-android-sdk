package org.mifos.core.apihelper

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import org.mifos.core.data.EntityMapper
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.lang.Exception

/**
 * Contains the generic helper function for executing the api request
 * by the FineractClient services
 * @author Danish Jamal - http://github.com/danishjamal104/
 */

/**
 * Queues the call request
 * @param IN the generic data type of Call<T>
 * @param call the call instance of type [Call], which is to be queued
 * @param onResponse lambda function called when response is returned
 * @param onFailure lambda function called when failure occurs
 */
private fun <IN> callRequest(
    call: Call<IN>,
    onResponse: (response: Response<IN>) -> Unit,
    onFailure: (exception: Exception) -> Unit
) {
    call.enqueue(object : Callback<IN> {
        override fun onResponse(call: Call<IN>, response: Response<IN>) {
            if (response.body() != null) {
                onResponse(response)
            } else {
                val exp = Exception(response.errorBody().toString())
                onFailure(exp)
            }
        }

        override fun onFailure(call: Call<IN>, t: Throwable) {
            onFailure(t as Exception)
        }
    })
}

/**
 * Queues the call request and returns the LiveData of [DataState],
 * of generic response form retrofit.
 * For getting specific data type user @see apiRequest<IN, OUT>
 * @param IN the generic data type of object to be returned
 * @param call the call instance of type [Call], which is to be executed
 * @return [LiveData] object of generic type [IN] of [DataState]
 */
fun <IN> apiRequest(call: Call<IN>): LiveData<DataState<IN>> {
    val liveData = MutableLiveData<DataState<IN>>()
    callRequest(call, { response ->
        if (response.body() != null) {
            liveData.postValue(DataState.Success(response.body()!!))
        } else {
            val exp = Exception(response.errorBody().toString())
            liveData.postValue(DataState.Error(exp))
        }
    }, {
        liveData.postValue(DataState.Error(it))
    })
    return liveData
}

/**
 * Queues the call request and returns the LiveData of [DataState],
 * of [OUT] generic type. Here [entityMapper] is used for converting
 * the generic response of retrofit to specific [OUT] type.
 * @param IN the generic data type of object returned by retrofit call
 * @param OUT the generic data type of object to be returned
 * @param call the call instance of type [Call], which is to be executed
 * @param entityMapper use to convert [IN] to [OUT]
 * @return [LiveData] object of generic type [OUT] of [DataState]
 */
fun <IN, OUT> apiRequest(
    call: Call<IN>,
    entityMapper: EntityMapper<IN, OUT>
): LiveData<DataState<OUT>> {
    val liveData = MutableLiveData<DataState<OUT>>()
    callRequest(call, { response ->
        if (response.body() != null) {
            val body = entityMapper.mapFromEntity(response.body()!!)
            liveData.postValue(DataState.Success(body))
        } else {
            val exp = Exception(response.errorBody().toString())
            liveData.postValue(DataState.Error(exp))
        }
    }, {
        liveData.postValue(DataState.Error(it))
    })
    return liveData
}