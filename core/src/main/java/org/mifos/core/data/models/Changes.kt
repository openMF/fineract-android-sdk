package org.mifos.core.models

import com.google.gson.Gson

/**
 * Created by grandolf49 on 28-06-2020
 *
 * From package api.model
 */
data class Changes(
    var locale: String? = null,
    var dateFormat: String? = null
) {
    override fun toString(): String {
        return Gson().toJson(this)
    }
}