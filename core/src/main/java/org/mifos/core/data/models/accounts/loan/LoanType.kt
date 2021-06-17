package org.mifos.core.models.accounts.loan

import android.os.Parcel
import android.os.Parcelable

/**
 * Created by grandolf49 on 28-06-2020
 *
 * Data class to model LoanType object with Builder pattern support.
 */
data class LoanType(
    var id: Int? = null,
    var code: String? = null,
    var value: String? = null
) : Parcelable {

    constructor(parcel: Parcel) : this() {
        id = parcel.readValue(Int::class.java.classLoader) as Int?
        code = parcel.readString()
        value = parcel.readString()
    }

    companion object {
        val CREATOR: Parcelable.Creator<LoanType?> = object : Parcelable.Creator<LoanType?> {
            override fun createFromParcel(source: Parcel): LoanType? {
                return LoanType(source)
            }

            override fun newArray(size: Int): Array<LoanType?> {
                return arrayOfNulls(size)
            }
        }
    }

    fun withId(id: Int?): LoanType? {
        this.id = id
        return this
    }

    fun withCode(code: String?): LoanType? {
        this.code = code
        return this
    }

    fun withValue(value: String?): LoanType? {
        this.value = value
        return this
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