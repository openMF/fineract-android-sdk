package org.mifos.core.models

import android.os.Parcel
import android.os.Parcelable
import java.util.*

/**
 * Created by grandolf49 on 28-06-2020
 */
data class Timeline(
    private var submittedOnDate: List<Int?> = ArrayList(),
    private var submittedByUsername: String? = null,
    private var submittedByFirstname: String? = null,
    private var submittedByLastname: String? = null,
    private var activatedOnDate: List<Int?> = ArrayList(),
    private var activatedByUsername: String? = null,
    private var activatedByFirstname: String? = null,
    private var activatedByLastname: String? = null,
    private var closedOnDate: List<Int?> = ArrayList(),
    private var closedByUsername: String? = null,
    private var closedByFirstname: String? = null,
    private var closedByLastname: String? = null
) : Parcelable {

    constructor(parcel: Parcel) : this() {
        submittedOnDate = ArrayList()
        parcel.readList(submittedOnDate, Int::class.java.classLoader)
        submittedByUsername = parcel.readString()
        submittedByFirstname = parcel.readString()
        submittedByLastname = parcel.readString()
        activatedOnDate = ArrayList()
        parcel.readList(activatedOnDate, Int::class.java.classLoader)
        activatedByUsername = parcel.readString()
        activatedByFirstname = parcel.readString()
        activatedByLastname = parcel.readString()
        closedOnDate = ArrayList()
        parcel.readList(closedOnDate, Int::class.java.classLoader)
        closedByUsername = parcel.readString()
        closedByFirstname = parcel.readString()
        closedByLastname = parcel.readString()
    }

    companion object {
        val CREATOR: Parcelable.Creator<Timeline?> = object : Parcelable.Creator<Timeline?> {
            override fun createFromParcel(source: Parcel): Timeline? {
                return Timeline(source)
            }

            override fun newArray(size: Int): Array<Timeline?> {
                return arrayOfNulls(size)
            }
        }
    }

    override fun describeContents(): Int {
        return 0
    }

    override fun writeToParcel(dest: Parcel, flags: Int) {
        dest.writeList(submittedOnDate)
        dest.writeString(submittedByUsername)
        dest.writeString(submittedByFirstname)
        dest.writeString(submittedByLastname)
        dest.writeList(activatedOnDate)
        dest.writeString(activatedByUsername)
        dest.writeString(activatedByFirstname)
        dest.writeString(activatedByLastname)
        dest.writeList(closedOnDate)
        dest.writeString(closedByUsername)
        dest.writeString(closedByFirstname)
        dest.writeString(closedByLastname)
    }
}