package org.mifos.core.models.group

import android.os.Parcel
import android.os.Parcelable

/**
 * Created by grandolf49 on 28-06-2020
 */

data class GroupDate(
    var groupId: Long = 0,
    var chargeId: Long = 0,
    var day: Int = 0,
    var month: Int = 0,
    var year: Int = 0
) : Parcelable {

    override fun describeContents(): Int {
        return 0
    }

    override fun writeToParcel(dest: Parcel, flags: Int) {
        dest.writeLong(groupId)
        dest.writeLong(chargeId)
        dest.writeInt(day)
        dest.writeInt(month)
        dest.writeInt(year)
    }

    constructor(parcel: Parcel) : this() {
        groupId = parcel.readLong()
        chargeId = parcel.readLong()
        day = parcel.readInt()
        month = parcel.readInt()
        year = parcel.readInt()
    }

    companion object {
        val CREATOR: Parcelable.Creator<GroupDate?> = object : Parcelable.Creator<GroupDate?> {
            override fun createFromParcel(source: Parcel): GroupDate? {
                return GroupDate(source)
            }

            override fun newArray(size: Int): Array<GroupDate?> {
                return arrayOfNulls(size)
            }
        }
    }
}