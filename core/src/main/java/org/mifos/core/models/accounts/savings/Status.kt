package org.mifos.core.models.accounts.savings

import android.os.Parcel
import android.os.Parcelable

/**
 * Created by grandolf49 on 28-06-2020
 *
 * Data class to model Status object with Builder pattern support.
 */
data class Status(
    var id: Int? = null,
    var code: String? = null,
    var value: String? = null,
    var submittedAndPendingApproval: Boolean? = null,
    var approved: Boolean? = null,
    var rejected: Boolean? = null,
    var withdrawnByApplicant: Boolean? = null,
    var active: Boolean? = null,
    var closed: Boolean? = null
) : Parcelable {

    constructor(parcel: Parcel) : this() {
        id = parcel.readValue(Int::class.java.classLoader) as Int?
        code = parcel.readString()
        value = parcel.readString()
        submittedAndPendingApproval = parcel.readValue(Boolean::class.java.classLoader) as Boolean?
        approved = parcel.readValue(Boolean::class.java.classLoader) as Boolean?
        rejected = parcel.readValue(Boolean::class.java.classLoader) as Boolean?
        withdrawnByApplicant = parcel.readValue(Boolean::class.java.classLoader) as Boolean?
        active = parcel.readValue(Boolean::class.java.classLoader) as Boolean?
        closed = parcel.readValue(Boolean::class.java.classLoader) as Boolean?
    }

    companion object {
        val CREATOR: Parcelable.Creator<Status?> =
            object : Parcelable.Creator<Status?> {
                override fun createFromParcel(source: Parcel): Status? {
                    return Status(source)
                }

                override fun newArray(size: Int): Array<Status?> {
                    return arrayOfNulls(size)
                }
            }
    }

    fun withId(id: Int?): Status? {
        this.id = id
        return this
    }

    fun withCode(code: String?): Status? {
        this.code = code
        return this
    }

    fun withValue(value: String?): Status? {
        this.value = value
        return this
    }

    fun withSubmittedAndPendingApproval(submittedAndPendingApproval: Boolean?): Status? {
        this.submittedAndPendingApproval = submittedAndPendingApproval
        return this
    }

    fun withApproved(approved: Boolean?): Status? {
        this.approved = approved
        return this
    }

    fun withRejected(rejected: Boolean?): Status? {
        this.rejected = rejected
        return this
    }

    fun withWithdrawnByApplicant(withdrawnByApplicant: Boolean?): Status? {
        this.withdrawnByApplicant = withdrawnByApplicant
        return this
    }

    fun withActive(active: Boolean?): Status? {
        this.active = active
        return this
    }

    fun withClosed(closed: Boolean?): Status? {
        this.closed = closed
        return this
    }

    override fun describeContents(): Int {
        return 0
    }

    override fun writeToParcel(dest: Parcel, flags: Int) {
        dest.writeValue(id)
        dest.writeString(code)
        dest.writeString(value)
        dest.writeValue(submittedAndPendingApproval)
        dest.writeValue(approved)
        dest.writeValue(rejected)
        dest.writeValue(withdrawnByApplicant)
        dest.writeValue(active)
        dest.writeValue(closed)
    }
}
