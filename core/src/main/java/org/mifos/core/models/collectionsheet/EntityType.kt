package org.mifos.core.models.collectionsheet

import android.os.Parcel
import android.os.Parcelable

/**
 * Created by grandolf49 on 28-06-2020
 */
data class EntityType(
    private var id: Int? = null,
    private var code: String? = null,
    private var value: String? = null
) : Parcelable {

    constructor(parcel: Parcel) : this() {
        id = parcel.readValue(Int::class.java.classLoader) as Int?
        code = parcel.readString()
        value = parcel.readString()
    }

    companion object {
        val CREATOR: Parcelable.Creator<EntityType?> = object : Parcelable.Creator<EntityType?> {
            override fun createFromParcel(source: Parcel): EntityType? {
                return EntityType(source)
            }

            override fun newArray(size: Int): Array<EntityType?> {
                return arrayOfNulls(size)
            }
        }
    }

    override fun describeContents(): Int {
        return 0
    }

    override fun writeToParcel(dest: Parcel, flags: Int) {
        dest.writeValue(id)
        dest.writeString(code)
        dest.writeString(value)
    }
}