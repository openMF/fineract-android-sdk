package org.mifos.core.models.accounts.savings

import android.os.Parcel
import android.os.Parcelable
import org.mifos.core.apimanager.ApiEndPoints.Companion.RECURRING_ACCOUNTS
import org.mifos.core.apimanager.ApiEndPoints.Companion.SAVINGSACCOUNTS

/**
 * Created by grandolf49 on 28-06-2020
 */
data class DepositType(
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
        val CREATOR: Parcelable.Creator<DepositType?> = object : Parcelable.Creator<DepositType?> {
            override fun createFromParcel(source: Parcel): DepositType? {
                return DepositType(source)
            }

            override fun newArray(size: Int): Array<DepositType?> {
                return arrayOfNulls(size)
            }
        }
    }

    fun isRecurring(): Boolean {
        return ServerTypes.RECURRING.id == this.id
    }

    override fun describeContents(): Int {
        return 0
    }

    override fun writeToParcel(dest: Parcel, flags: Int) {
        dest.writeValue(id)
        dest.writeString(code)
        dest.writeString(value)
    }

    enum class ServerTypes(
        val id: Int,
        val code: String,
        val endpoint: String
    ) {
        SAVINGS(100, "depositAccountType.savingsDeposit", SAVINGSACCOUNTS),
        FIXED(200, "depositAccountType.fixedDeposit", SAVINGSACCOUNTS),
        RECURRING(300, "depositAccountType.recurringDeposit", RECURRING_ACCOUNTS);

        companion object {
            fun fromId(id: Int): ServerTypes {
                for (type in values()) {
                    if (type.id == id) {
                        return type
                    }
                }
                return SAVINGS
            }
        }
    }
}