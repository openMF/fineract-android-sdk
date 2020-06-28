package org.mifos.core.models.db

import com.google.gson.Gson

/**
 * Created by grandolf49 on 28-06-2020
 */
data class Client(
    private var clientId: Int = 0,
    private var clientName: String? = null,
    private var attendanceType: AttendanceType? = null,
    private var mifosGroup: MifosGroup? = null,
    private val loans: List<Loan?>? = null
) {
    override fun toString(): String {
        return Gson().toJson(this)
    }
}