package org.mifos.core.models

import android.os.Parcel
import android.os.Parcelable
import com.google.gson.Gson

/**
 * Created by grandolf49 on 28-06-2020
 *
 * From package api.model
 */
data class BulkRepaymentTransactions(
    var loanId: Int = 0,
    var transactionAmount: Double = 0.0,
    private var accountNumber: String? = null,
    private var bankNumber: String? = null,
    private var checkNumber: String? = null,
    private var paymentTypeId: Int? = null,
    private var receiptNumber: String? = null,
    private var routingCode: String? = null
) : Parcelable {

    constructor(loanId: Int, transactionAmount: Double) : this() {
        this.loanId = loanId
        this.transactionAmount = transactionAmount
    }

    constructor(parcel: Parcel) : this() {
        loanId = parcel.readInt()
        transactionAmount = parcel.readDouble()
        accountNumber = parcel.readString()
        bankNumber = parcel.readString()
        checkNumber = parcel.readString()
        paymentTypeId = parcel.readValue(Int::class.java.classLoader) as Int?
        receiptNumber = parcel.readString()
        routingCode = parcel.readString()
    }

    companion object {
        val CREATOR: Parcelable.Creator<BulkRepaymentTransactions?> =
            object : Parcelable.Creator<BulkRepaymentTransactions?> {
                override fun createFromParcel(source: Parcel): BulkRepaymentTransactions? {
                    return BulkRepaymentTransactions(source)
                }

                override fun newArray(size: Int): Array<BulkRepaymentTransactions?> {
                    return arrayOfNulls(size)
                }
            }
    }

    override fun toString(): String {
        return Gson().toJson(this)
    }

    override fun describeContents(): Int {
        return 0
    }

    override fun writeToParcel(dest: Parcel, flags: Int) {
        dest.writeInt(loanId)
        dest.writeDouble(transactionAmount)
        dest.writeString(accountNumber)
        dest.writeString(bankNumber)
        dest.writeString(checkNumber)
        dest.writeValue(paymentTypeId)
        dest.writeString(receiptNumber)
        dest.writeString(routingCode)
    }
}