package org.mifos.core.models.accounts.loan

import android.os.Parcel
import android.os.Parcelable

/**
 * Created by grandolf49 on 28-06-2020
 *
 * Data class to model Loan object with Builder pattern support.
 */
data class LoanAccount(
    var clientId: Long = 0,
    var groupId: Long = 0,
    var centerId: Long = 0,
    var id: Int? = null,
    var accountNo: String? = null,
    var externalId: String? = null,
    var productId: Int? = null,
    var productName: String? = null,
    var status: Status? = null,
    var loanType: LoanType? = null,
    var loanCycle: Int? = null,
    var inArrears: Boolean? = null
) : Parcelable {

    constructor(parcel: Parcel) : this() {
        clientId = parcel.readValue(Long::class.java.classLoader) as Long
        id = parcel.readValue(Int::class.java.classLoader) as Int?
        accountNo = parcel.readString()
        externalId = parcel.readString()
        productId = parcel.readValue(Int::class.java.classLoader) as Int?
        productName = parcel.readString()
        status = parcel.readParcelable(Status::class.java.classLoader)
        loanType = parcel.readParcelable(LoanType::class.java.classLoader)
        loanCycle = parcel.readValue(Int::class.java.classLoader) as Int?
        inArrears = parcel.readValue(Boolean::class.java.classLoader) as Boolean?
    }

    companion object {
        val CREATOR: Parcelable.Creator<LoanAccount?> = object : Parcelable.Creator<LoanAccount?> {
            override fun createFromParcel(source: Parcel): LoanAccount? {
                return LoanAccount(source)
            }

            override fun newArray(size: Int): Array<LoanAccount?>? {
                return arrayOfNulls<LoanAccount?>(size)
            }
        }
    }

    fun withId(id: Int?): LoanAccount? {
        this.id = id
        return this
    }

    fun withAccountNo(accountNo: String?): LoanAccount? {
        this.accountNo = accountNo
        return this
    }

    fun withExternalId(externalId: String?): LoanAccount? {
        this.externalId = externalId
        return this
    }

    fun withProductId(productId: Int?): LoanAccount? {
        this.productId = productId
        return this
    }

    fun withProductName(productName: String?): LoanAccount? {
        this.productName = productName
        return this
    }

    fun withStatus(status: Status?): LoanAccount? {
        this.status = status
        return this
    }

    fun withLoanType(loanType: LoanType?): LoanAccount? {
        this.loanType = loanType
        return this
    }

    override fun describeContents(): Int {
        return 0
    }

    override fun writeToParcel(dest: Parcel, flags: Int) {
        dest.writeValue(clientId)
        dest.writeValue(id)
        dest.writeString(accountNo)
        dest.writeString(externalId)
        dest.writeValue(productId)
        dest.writeString(productName)
        dest.writeParcelable(status, flags)
        dest.writeParcelable(loanType, flags)
        dest.writeValue(loanCycle)
        dest.writeValue(inArrears)
    }
}