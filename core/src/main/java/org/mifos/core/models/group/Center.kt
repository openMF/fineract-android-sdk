package org.mifos.core.models.group

import android.os.Parcel
import android.os.Parcelable
import org.mifos.core.models.Timeline
import org.mifos.core.models.client.Status
import java.util.*

/**
 * Created by grandolf49 on 28-06-2020
 */
data class Center(
    var id: Int? = 0,
    var sync: Boolean? = false,
    var accountNo: String? = "",
    var name: String? = "",
    var officeId: Int? = 0,
    var officeName: String? = "",
    var staffId: Int? = 0,
    var staffName: String? = "",
    var hierarchy: String? = "",
    var status: Status? = null,
    var active: Boolean? = false,
    var centerDate: CenterDate? = null,
    var activationDate: List<Int?> = ArrayList(),
    var timeline: Timeline? = null,
    var externalId: String? = ""
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
    }

    companion object {
        val CREATOR: Parcelable.Creator<Center?> = object : Parcelable.Creator<Center?> {
            override fun createFromParcel(source: Parcel): Center? {
                return Center(source)
            }

            override fun newArray(size: Int): Array<Center?> {
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
    }
}