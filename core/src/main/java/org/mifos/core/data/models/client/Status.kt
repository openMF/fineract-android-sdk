package org.mifos.core.models.client

import android.os.Parcel
import android.os.Parcelable

/**
 * Created by grandolf49 on 28-06-2020
 */
data class Status(
    var id: Int = 0,
    var code: String? = null,
    var value: String? = null
) : Parcelable {

    private val STATUS_ACTIVE = "Active"

    constructor(parcel: Parcel) : this() {
        id = parcel.readInt()
        code = parcel.readString()
        value = parcel.readString()
    }

    companion object {
        val CREATOR: Parcelable.Creator<Status?> = object : Parcelable.Creator<Status?> {
            override fun createFromParcel(source: Parcel): Status? {
                return Status(source)
            }

            override fun newArray(size: Int): Array<Status?> {
                return arrayOfNulls(size)
            }
        }
    }

    /**
     * Helper method to check if status is Active
     */
    fun isActive(value: String): Boolean {
        return value.equals(STATUS_ACTIVE, ignoreCase = true)
    }

    override fun describeContents(): Int {
        return 0
    }

    override fun writeToParcel(dest: Parcel, flags: Int) {
        dest.writeInt(id)
        dest.writeString(code)
        dest.writeString(value)
    }
}