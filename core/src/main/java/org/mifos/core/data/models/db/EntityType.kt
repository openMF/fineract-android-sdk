package org.mifos.core.models.db

import com.google.gson.Gson

/**
 * Created by grandolf49 on 28-06-2020
 */
data class EntityType(
    private var code: String? = null,
    private var value: String? = null
) {
    override fun toString(): String {
        return Gson().toJson(this)
    }
}