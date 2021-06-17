package org.mifos.core.models.group

import android.os.Parcel
import android.os.Parcelable

/**
 * Created by grandolf49 on 28-06-2020
 */
data class CenterPayload(
    var id: Int = 0,
    var errorMessage: String? = null,
    var dateFormat: String? = null,
    var locale: String? = null,
    private var name: String? = null,
    private var officeId: Int = 0,
    private var active: Boolean = false,
    private var activationDate: String? = null
) : Parcelable {

    constructor(parcel: Parcel) : this() {
        dateFormat = parcel.readString()
        locale = parcel.readString()
        name = parcel.readString()
        officeId = (parcel.readValue(Int::class.java.classLoader) as Int?)!!
        active = (parcel.readValue(Boolean::class.java.classLoader) as Boolean?)!!
        activationDate = parcel.readString()
    }

    companion object {
        val CREATOR: Parcelable.Creator<CenterPayload?> =
            object : Parcelable.Creator<CenterPayload?> {
                override fun createFromParcel(source: Parcel): CenterPayload? {
                    return CenterPayload(source)
                }

                override fun newArray(size: Int): Array<CenterPayload?> {
                    return arrayOfNulls(size)
                }
            }
    }

    override fun describeContents(): Int {
        return 0
    }

    override fun writeToParcel(dest: Parcel, flags: Int) {
        dest.writeString(dateFormat)
        dest.writeString(locale)
        dest.writeString(name)
        dest.writeValue(officeId)
        dest.writeValue(active)
        dest.writeString(activationDate)
    }
}