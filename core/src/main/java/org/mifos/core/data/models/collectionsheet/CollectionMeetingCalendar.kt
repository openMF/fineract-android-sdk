package org.mifos.core.models.collectionsheet

import android.os.Parcel
import android.os.Parcelable
import java.util.*

/**
 * Created by grandolf49 on 28-06-2020
 */
data class CollectionMeetingCalendar(
    private var id: Int? = null,
    private var calendarInstanceId: Int? = null,
    private var entityId: Int? = null,
    private var entityType: EntityType? = null,
    private var title: String? = null,
    private var startDate: List<Int?> = ArrayList(),
    private var duration: Int? = null,
    private var type: EntityType? = null,
    private var repeating: Boolean? = null,
    private var recurrence: String? = null,
    private var frequency: EntityType? = null,
    private var interval: Int? = null,
    private var repeatsOnDay: EntityType? = null,
    private var firstReminder: Int? = null,
    private var secondReminder: Int? = null,
    private var recurringDates: List<List<Int>?> = ArrayList(),
    private var nextTenRecurringDates: List<List<Int>?> = ArrayList(),
    private var humanReadable: String? = null,
    private var recentEligibleMeetingDate: List<Int?> = ArrayList(),
    private var createdDate: List<Int?> = ArrayList(),
    private var lastUpdatedDate: List<Int?> = ArrayList(),
    private var createdByUserId: Int? = null,
    private var createdByUsername: String? = null,
    private var lastUpdatedByUserId: Int? = null,
    private var lastUpdatedByUsername: String? = null
) : Parcelable {

    constructor(parcel: Parcel) : this() {
        id = parcel.readValue(Int::class.java.classLoader) as Int?
        calendarInstanceId = parcel.readValue(Int::class.java.classLoader) as Int?
        entityId = parcel.readValue(Int::class.java.classLoader) as Int?
        entityType = parcel.readParcelable(EntityType::class.java.classLoader)
        title = parcel.readString()
        startDate = ArrayList()
        parcel.readList(startDate, Int::class.java.classLoader)
        duration = parcel.readValue(Int::class.java.classLoader) as Int?
        type = parcel.readParcelable(EntityType::class.java.classLoader)
        repeating = parcel.readValue(Boolean::class.java.classLoader) as Boolean?
        recurrence = parcel.readString()
        frequency = parcel.readParcelable(EntityType::class.java.classLoader)
        interval = parcel.readValue(Int::class.java.classLoader) as Int?
        repeatsOnDay = parcel.readParcelable(EntityType::class.java.classLoader)
        firstReminder = parcel.readValue(Int::class.java.classLoader) as Int?
        secondReminder = parcel.readValue(Int::class.java.classLoader) as Int?
        recurringDates = ArrayList()
        nextTenRecurringDates = ArrayList()
        humanReadable = parcel.readString()
        recentEligibleMeetingDate = ArrayList()
        parcel.readList(recentEligibleMeetingDate, Int::class.java.classLoader)
        createdDate = ArrayList()
        parcel.readList(createdDate, Int::class.java.classLoader)
        lastUpdatedDate = ArrayList()
        parcel.readList(lastUpdatedDate, Int::class.java.classLoader)
        createdByUserId = parcel.readValue(Int::class.java.classLoader) as Int?
        createdByUsername = parcel.readString()
        lastUpdatedByUserId = parcel.readValue(Int::class.java.classLoader) as Int?
        lastUpdatedByUsername = parcel.readString()
    }

    companion object {
        val CREATOR: Parcelable.Creator<CollectionMeetingCalendar?> =
            object : Parcelable.Creator<CollectionMeetingCalendar?> {
                override fun createFromParcel(source: Parcel): CollectionMeetingCalendar? {
                    return CollectionMeetingCalendar(source)
                }

                override fun newArray(size: Int): Array<CollectionMeetingCalendar?> {
                    return arrayOfNulls(size)
                }
            }
    }

    override fun describeContents(): Int {
        return 0
    }

    override fun writeToParcel(dest: Parcel, flags: Int) {
        dest.writeValue(id)
        dest.writeValue(calendarInstanceId)
        dest.writeValue(entityId)
        dest.writeParcelable(entityType, flags)
        dest.writeString(title)
        dest.writeList(startDate)
        dest.writeValue(duration)
        dest.writeParcelable(type, flags)
        dest.writeValue(repeating)
        dest.writeString(recurrence)
        dest.writeParcelable(frequency, flags)
        dest.writeValue(interval)
        dest.writeParcelable(repeatsOnDay, flags)
        dest.writeValue(firstReminder)
        dest.writeValue(secondReminder)
        dest.writeList(recurringDates)
        dest.writeList(nextTenRecurringDates)
        dest.writeString(humanReadable)
        dest.writeList(recentEligibleMeetingDate)
        dest.writeList(createdDate)
        dest.writeList(lastUpdatedDate)
        dest.writeValue(createdByUserId)
        dest.writeString(createdByUsername)
        dest.writeValue(lastUpdatedByUserId)
        dest.writeString(lastUpdatedByUsername)
    }
}