package org.mifos.core.models.db

import com.google.gson.Gson

/**
 * Created by grandolf49 on 28-06-2020
 */
data class OfflineCenter(
    private var staffId: Int = 0,
    private var staffName: String? = null,
    private var meetingFallCenters: Array<MeetingCenter?>? = null
) {
    override fun toString(): String {
        return Gson().toJson(this)
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as OfflineCenter

        if (staffId != other.staffId) return false
        if (staffName != other.staffName) return false
        if (meetingFallCenters != null) {
            if (other.meetingFallCenters == null) return false
            if (!meetingFallCenters!!.contentEquals(other.meetingFallCenters!!)) return false
        } else if (other.meetingFallCenters != null) return false

        return true
    }

    override fun hashCode(): Int {
        var result = staffId.hashCode()
        result = 31 * result + (staffName?.hashCode() ?: 0)
        result = 31 * result + (meetingFallCenters?.contentHashCode() ?: 0)
        return result
    }
}