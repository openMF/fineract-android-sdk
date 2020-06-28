package org.mifos.core.models.db

import com.google.gson.Gson

/**
 * Created by grandolf49 on 28-06-2020
 */
data class MeetingDate(
    private var year: Int = 0,
    private var month: Int = 0,
    private var day: Int = 0
) {
    override fun toString(): String {
        return Gson().toJson(this)
    }
}