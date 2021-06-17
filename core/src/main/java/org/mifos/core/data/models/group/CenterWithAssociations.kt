package org.mifos.core.models.group

import android.os.Parcel
import android.os.Parcelable
import org.mifos.core.models.Timeline
import org.mifos.core.models.client.Status
import org.mifos.core.models.collectionsheet.CollectionMeetingCalendar
import java.util.*

/**
 * Created by grandolf49 on 28-06-2020
 */
data class CenterWithAssociations(
    private var id: Int? = null,
    private var accountNo: String? = null,
    private var name: String? = null,
    private var externalId: String? = null,
    private var officeId: Int? = null,
    private var officeName: String? = null,
    private var staffId: Int? = null,
    private var staffName: String? = null,
    private var hierarchy: String? = null,
    private var status: Status? = null,
    private var active: Boolean? = null,
    private var activationDate: List<Int?> = ArrayList(),
    private var timeline: Timeline? = null,
    private var groupMembers: List<Group>? = ArrayList(),
    private var collectionMeetingCalendar: CollectionMeetingCalendar? = CollectionMeetingCalendar()
) : Parcelable {

    constructor(parcel: Parcel) : this() {
        id = parcel.readValue(Int::class.java.classLoader) as Int?
        accountNo = parcel.readString()
        name = parcel.readString()
        externalId = parcel.readString()
        officeId = parcel.readValue(Int::class.java.classLoader) as Int?
        officeName = parcel.readString()
        staffId = parcel.readValue(Int::class.java.classLoader) as Int?
        staffName = parcel.readString()
        hierarchy = parcel.readString()
        status = parcel.readParcelable(Status::class.java.classLoader)
        active = parcel.readValue(Boolean::class.java.classLoader) as Boolean?
        activationDate = ArrayList()
        parcel.readList(activationDate, Int::class.java.classLoader)
        timeline = parcel.readParcelable(Timeline::class.java.classLoader)
        groupMembers = parcel.createTypedArrayList<Group>(Group.CREATOR)
        collectionMeetingCalendar =
            parcel.readParcelable(CollectionMeetingCalendar::class.java.classLoader)
    }

    companion object {
        val CREATOR: Parcelable.Creator<CenterWithAssociations?> =
            object : Parcelable.Creator<CenterWithAssociations?> {
                override fun createFromParcel(source: Parcel): CenterWithAssociations? {
                    return CenterWithAssociations(source)
                }

                override fun newArray(size: Int): Array<CenterWithAssociations?> {
                    return arrayOfNulls(size)
                }
            }
    }

    override fun describeContents(): Int {
        return 0
    }

    override fun writeToParcel(dest: Parcel, flags: Int) {
        dest.writeValue(id)
        dest.writeString(accountNo)
        dest.writeString(name)
        dest.writeString(externalId)
        dest.writeValue(officeId)
        dest.writeString(officeName)
        dest.writeValue(staffId)
        dest.writeString(staffName)
        dest.writeString(hierarchy)
        dest.writeParcelable(status, flags)
        dest.writeValue(active)
        dest.writeList(activationDate)
        dest.writeParcelable(timeline, flags)
        dest.writeTypedList(groupMembers)
        dest.writeParcelable(collectionMeetingCalendar, flags)
    }
}