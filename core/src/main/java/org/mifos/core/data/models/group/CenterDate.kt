package org.mifos.core.models.group

import android.os.Parcel
import android.os.Parcelable

/**
 * Created by grandolf49 on 28-06-2020
 */
data class CenterDate(
    var centerId: Long = 0,
    var chargeId: Long = 0,
    var day: Int = 0,
    var month: Int = 0,
    var year: Int = 0
) : Parcelable {

    constructor(parcel: Parcel) : this() {
        centerId = parcel.readLong()
        day = parcel.readInt()
        month = parcel.readInt()
        year = parcel.readInt()
    }

    companion object {
        val CREATOR: Parcelable.Creator<CenterDate?> = object : Parcelable.Creator<CenterDate?> {
            override fun createFromParcel(source: Parcel): CenterDate? {
                return CenterDate(source)
            }

            override fun newArray(size: Int): Array<CenterDate?> {
                return arrayOfNulls(size)
            }
        }
    }

    override fun describeContents(): Int {
        return 0
    }

    override fun writeToParcel(
        dest: Parcel,
        flags: Int
    ) {
        dest.writeLong(centerId)
        dest.writeInt(day)
        dest.writeInt(month)
        dest.writeInt(year)
    }
}