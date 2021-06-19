package org.mifos.core.models.db

import com.google.gson.Gson
import java.util.*

/**
 * Created by grandolf49 on 28-06-2020
 */
data class CollectionMeetingCalendar(
    private var calendarInstanceId: Int = 0,
    private var calendarId: Long = 0,
    private var entityId: Int = 0,
    private var entityType: EntityType? = null,
    private var title: String? = null,
    private var description: String? = null,
    private var location: String? = null,
    private var meetingCalendarDate: MeetingDate? = null,
    private var repeating: Boolean = false,
    private var recurrence: String? = null,
    private var startDate: List<Int> = ArrayList()
) {
    override fun toString(): String {
        return Gson().toJson(this)
    }
}