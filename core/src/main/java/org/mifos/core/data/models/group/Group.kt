package org.mifos.core.models.group

import android.os.Parcel
import android.os.Parcelable
import org.mifos.core.models.Timeline
import org.mifos.core.models.client.Status
import java.util.*

/**
 * Created by grandolf49 on 28-06-2020
 */
data class Group(
    var id: Int? = null,
    var accountNo: String? = null,
    var sync: Boolean = false,
    var name: String? = null,
    var status: Status? = null,
    var active: Boolean? = null,
    var groupDate: GroupDate? = null,
    var activationDate: List<Int?> = ArrayList(),
    var officeId: Int? = null,
    var officeName: String? = null,
    var centerId: Int = 0,
    var centerName: String? = null,
    var staffId: Int? = null,
    var staffName: String? = null,
    var hierarchy: String? = null,
    var groupLevel: Int = 0,
    var timeline: Timeline? = null,
    var externalId: String? = null
) : Parcelable {

    constructor(parcel: Parcel) : this() {
        activationDate = ArrayList()
        parcel.readList(activationDate, Int::class.java.classLoader)
        active = parcel.readValue(Boolean::class.java.classLoader) as Boolean?
        hierarchy = parcel.readString()
        id = parcel.readValue(Int::class.java.classLoader) as Int?
        accountNo = parcel.readString()
        groupLevel = parcel.readInt()
        name = parcel.readString()
        officeId = parcel.readValue(Int::class.java.classLoader) as Int?
        officeName = parcel.readString()
        externalId = parcel.readString()
        staffId = parcel.readValue(Int::class.java.classLoader) as Int?
        staffName = parcel.readString()
        status = parcel.readParcelable(Status::class.java.classLoader)
        timeline = parcel.readParcelable(Timeline::class.java.classLoader)
    }

    companion object {
        val CREATOR: Parcelable.Creator<Group?> = object : Parcelable.Creator<Group?> {
            override fun createFromParcel(source: Parcel): Group? {
                return Group(source)
            }

            override fun newArray(size: Int): Array<Group?> {
                return arrayOfNulls(size)
            }
        }
    }


    override fun describeContents(): Int {
        return 0
    }

    override fun writeToParcel(dest: Parcel, flags: Int) {
        dest.writeList(activationDate)
        dest.writeValue(active)
        dest.writeString(hierarchy)
        dest.writeValue(id)
        dest.writeString(accountNo)
        dest.writeInt(groupLevel)
        dest.writeString(name)
        dest.writeValue(officeId)
        dest.writeString(officeName)
        dest.writeString(externalId)
        dest.writeValue(staffId)
        dest.writeString(staffName)
        dest.writeParcelable(status, flags)
        dest.writeParcelable(timeline, flags)
    }
}