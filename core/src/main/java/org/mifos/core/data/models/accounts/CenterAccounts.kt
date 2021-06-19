package org.mifos.core.models.accounts

import android.os.Parcel
import android.os.Parcelable
import org.mifos.core.models.accounts.loan.LoanAccount
import org.mifos.core.models.accounts.savings.SavingsAccount
import java.util.*

/**
 * Created by grandolf49 on 28-06-2020
 *
 * Data class to model Center Accounts object with Builder pattern support.
 */
data class CenterAccounts(
    private var loanAccounts: List<LoanAccount>? = ArrayList(),
    private var savingsAccounts: List<SavingsAccount>? = ArrayList(),
    private var memberLoanAccounts: List<LoanAccount>? = ArrayList()
) : Parcelable {

    constructor(parcel: Parcel) : this() {
        loanAccounts = parcel.createTypedArrayList<LoanAccount>(LoanAccount.CREATOR)
        savingsAccounts = parcel.createTypedArrayList<SavingsAccount>(SavingsAccount.CREATOR)
        memberLoanAccounts = parcel.createTypedArrayList<LoanAccount>(LoanAccount.CREATOR)
    }

    companion object {
        val CREATOR: Parcelable.Creator<CenterAccounts?> =
            object : Parcelable.Creator<CenterAccounts?> {
                override fun createFromParcel(source: Parcel): CenterAccounts? {
                    return CenterAccounts(source)
                }

                override fun newArray(size: Int): Array<CenterAccounts?> {
                    return arrayOfNulls(size)
                }
            }
    }

    fun withLoanAccounts(loanAccounts: List<LoanAccount>?): CenterAccounts? {
        this.loanAccounts = loanAccounts
        return this
    }

    fun withSavingsAccounts(savingsAccounts: List<SavingsAccount>?): CenterAccounts? {
        this.savingsAccounts = savingsAccounts
        return this
    }

    private fun getSavingsAccounts(wantRecurring: Boolean): List<SavingsAccount?>? {
        val result: MutableList<SavingsAccount?> = ArrayList()
        if (savingsAccounts != null) {
            for (account in savingsAccounts!!) {
                if (account.isRecurring() == wantRecurring) {
                    result.add(account)
                }
            }
        }
        return result
    }

    override fun describeContents(): Int {
        return 0
    }

    override fun writeToParcel(dest: Parcel, flags: Int) {
        dest.writeTypedList(loanAccounts)
        dest.writeTypedList(savingsAccounts)
        dest.writeTypedList(memberLoanAccounts)
    }
}