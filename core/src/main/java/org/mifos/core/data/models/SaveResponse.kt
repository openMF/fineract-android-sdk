package org.mifos.core.models

import com.google.gson.Gson

/**
 * Created by grandolf49 on 28-06-2020
 */
data class SaveResponse(
    var groupId: Int? = null,
    var resourceId: Int? = null,
    var officeId: Int? = null,
    var changes: Changes? = null
) {
    override fun toString(): String {
        return Gson().toJson(this)
    }
}