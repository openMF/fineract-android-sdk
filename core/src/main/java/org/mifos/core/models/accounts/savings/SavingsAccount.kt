package org.mifos.core.models.accounts.savings

import android.os.Parcel
import android.os.Parcelable

/**
 * Created by grandolf49 on 28-06-2020
 *
 * Data class to model Savings Account object with Builder pattern support.
 */
data class SavingsAccount(
    var clientId: Long = 0,
    var groupId: Long = 0,
    var centerId: Long = 0,
    var id: Int? = null,
    var accountNo: String? = null,
    var productId: Int? = null,
    var productName: String? = null,
    var status: Status? = null,
    var currency: Currency? = null,
    var accountBalance: Double? = null,
    var depositType: DepositType? = null
) : Parcelable {

    constructor(parcel: Parcel) : this() {
        id = parcel.readValue(Int::class.java.classLoader) as Int?
        accountNo = parcel.readString()
        productId = parcel.readValue(Int::class.java.classLoader) as Int?
        productName = parcel.readString()
        status = parcel.readParcelable(Status::class.java.classLoader)
        currency = parcel.readParcelable(Currency::class.java.classLoader)
        accountBalance = parcel.readValue(Double::class.java.classLoader) as Double?
        depositType = parcel.readParcelable(DepositType::class.java.classLoader)
    }

    companion object {
        val CREATOR: Parcelable.Creator<SavingsAccount?> =
            object : Parcelable.Creator<SavingsAccount?> {
                override fun createFromParcel(source: Parcel): SavingsAccount? {
                    return SavingsAccount(source)
                }

                override fun newArray(size: Int): Array<SavingsAccount?> {
                    return arrayOfNulls(size)
                }
            }
    }

    fun withId(id: Int?): SavingsAccount? {
        this.id = id
        return this
    }

    fun withAccountNo(accountNo: String?): SavingsAccount? {
        this.accountNo = accountNo
        return this
    }

    fun withProductId(productId: Int?): SavingsAccount? {
        this.productId = productId
        return this
    }

    fun withProductName(productName: String?): SavingsAccount? {
        this.productName = productName
        return this
    }

    fun withStatus(status: Status?): SavingsAccount? {
        this.status = status
        return this
    }

    fun withCurrency(currency: Currency?): SavingsAccount? {
        this.currency = currency
        return this
    }

    fun withAccountBalance(accountBalance: Double?): SavingsAccount? {
        this.accountBalance = accountBalance
        return this
    }

    fun isRecurring(): Boolean {
        return depositType != null && depositType!!.isRecurring()
    }

    override fun describeContents(): Int {
        return 0
    }

    override fun writeToParcel(dest: Parcel, flags: Int) {
        dest.writeValue(id)
        dest.writeString(accountNo)
        dest.writeValue(productId)
        dest.writeString(productName)
        dest.writeParcelable(status, flags)
        dest.writeParcelable(currency, flags)
        dest.writeValue(accountBalance)
        dest.writeParcelable(depositType, flags)
    }
}