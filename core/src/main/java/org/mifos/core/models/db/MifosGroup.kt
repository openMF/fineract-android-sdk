package org.mifos.core.models.db

import com.google.gson.Gson

/**
 * Created by grandolf49 on 28-06-2020
 */
data class MifosGroup(
    var staffId: Int = 0,
    var staffName: String? = null,
    var levelId: Int = 0,
    var levelName: String? = null,
    private var groupId: Long = 0,
    private var groupName: String? = null,
    private var centerId: Long = 0,
    private var clients: List<Client?>? = null
) {
    override fun toString(): String {
        return Gson().toJson(this)
    }
}