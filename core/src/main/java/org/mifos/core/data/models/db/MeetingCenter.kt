package org.mifos.core.models.db

import com.google.gson.Gson

/**
 * Created by grandolf49 on 28-06-2020
 */
data class MeetingCenter(
    private var name: String? = null,
    private var externalId: String? = null,
    private var officeId: Int = 0,
    private var staffId: Int = 0,
    private var staffName: String? = null,
    private var status: Status? = null,
    private var active: Boolean = false,
    private var meetingDate: MeetingDate? = null,
    private var collectionMeetingCalendar: CollectionMeetingCalendar? = null,
    private var isSynced: Int = 0,
    private var centerId: Long = 0,
    private var activationDate: List<Int?>? = null
) {
    override fun toString(): String {
        return Gson().toJson(this)
    }
}