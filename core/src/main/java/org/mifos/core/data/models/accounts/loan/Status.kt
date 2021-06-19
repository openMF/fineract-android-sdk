package org.mifos.core.models.accounts.loan

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
    var pendingApproval: Boolean? = null,
    var waitingForDisbursal: Boolean? = null,
    var active: Boolean? = null,
    var closedObligationsMet: Boolean? = null,
    var closedWrittenOff: Boolean? = null,
    var closedRescheduled: Boolean? = null,
    var closed: Boolean? = null,
    var overpaid: Boolean? = null
) : Parcelable {

    constructor(parcel: Parcel) : this() {
        id = parcel.readValue(Int::class.java.classLoader) as Int?
        code = parcel.readString()
        value = parcel.readString()
        pendingApproval = parcel.readValue(Boolean::class.java.classLoader) as Boolean?
        waitingForDisbursal = parcel.readValue(Boolean::class.java.classLoader) as Boolean?
        active = parcel.readValue(Boolean::class.java.classLoader) as Boolean?
        closedObligationsMet = parcel.readValue(Boolean::class.java.classLoader) as Boolean?
        closedWrittenOff = parcel.readValue(Boolean::class.java.classLoader) as Boolean?
        closedRescheduled = parcel.readValue(Boolean::class.java.classLoader) as Boolean?
        closed = parcel.readValue(Boolean::class.java.classLoader) as Boolean?
        overpaid = parcel.readValue(Boolean::class.java.classLoader) as Boolean?
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

    fun withPendingApproval(pendingApproval: Boolean?): Status? {
        this.pendingApproval = pendingApproval
        return this
    }

    fun withWaitingForDisbursal(waitingForDisbursal: Boolean?): Status? {
        this.waitingForDisbursal = waitingForDisbursal
        return this
    }

    fun withActive(active: Boolean?): Status? {
        this.active = active
        return this
    }

    fun withClosedObligationsMet(closedObligationsMet: Boolean?): Status? {
        this.closedObligationsMet = closedObligationsMet
        return this
    }

    fun withClosedWrittenOff(closedWrittenOff: Boolean?): Status? {
        this.closedWrittenOff = closedWrittenOff
        return this
    }

    fun withClosedRescheduled(closedRescheduled: Boolean?): Status? {
        this.closedRescheduled = closedRescheduled
        return this
    }

    fun withClosed(closed: Boolean?): Status? {
        this.closed = closed
        return this
    }

    fun withOverpaid(overpaid: Boolean?): Status? {
        this.overpaid = overpaid
        return this
    }

    override fun describeContents(): Int {
        return 0
    }

    override fun writeToParcel(dest: Parcel, flags: Int) {
        dest.writeValue(id)
        dest.writeString(code)
        dest.writeString(value)
        dest.writeValue(pendingApproval)
        dest.writeValue(waitingForDisbursal)
        dest.writeValue(active)
        dest.writeValue(closedObligationsMet)
        dest.writeValue(closedWrittenOff)
        dest.writeValue(closedRescheduled)
        dest.writeValue(closed)
        dest.writeValue(overpaid)
    }
}