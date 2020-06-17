package org.mifos.models

import org.json.JSONObject

/**
 * Created by grandolf49 on 17-06-2020
 *
 * A class to store details of API
 */
data class ApiItemModel(
    val apiName: String? = null,
    val apiDescription: String? = null,
    val apiResponse: String? = null,
    val apiEndPoint: String? = null,
    val apiParams: HashMap<String, String>? = null
) {
    override fun toString(): String {
        val apiJson: JSONObject? = null
        apiJson?.put("name", apiName)
        apiJson?.put("description", apiDescription)
        apiJson?.put("response", apiResponse)
        apiJson?.put("endpoint", apiEndPoint)
        apiJson?.put("params", apiParams)

        return apiJson.toString()
    }
}