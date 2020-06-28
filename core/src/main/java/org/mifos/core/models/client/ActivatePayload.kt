package org.mifos.core.models.client

import android.os.Parcel
import android.os.Parcelable

/**
 * Created by grandolf49 on 28-06-2020
 */
data class ActivatePayload(
    var activationDate: String? = null,
    var dateFormat: String? = "dd MMMM YYYY",
    var locale: String? = "en"
) : Parcelable {

    constructor(parcel: Parcel) : this() {
        activationDate = parcel.readString()
        dateFormat = parcel.readString()
        locale = parcel.readString()
    }

    constructor(activationDate: String?) : this() {
        this.activationDate = activationDate
    }

    companion object {
        val CREATOR: Parcelable.Creator<ActivatePayload?> =
            object : Parcelable.Creator<ActivatePayload?> {
                override fun createFromParcel(source: Parcel): ActivatePayload? {
                    return ActivatePayload(source)
                }

                override fun newArray(size: Int): Array<ActivatePayload?> {
                    return arrayOfNulls(size)
                }
            }
    }

    override fun describeContents(): Int {
        return 0
    }

    override fun writeToParcel(dest: Parcel, flags: Int) {
        dest.writeString(activationDate)
        dest.writeString(dateFormat)
        dest.writeString(locale)
    }
}