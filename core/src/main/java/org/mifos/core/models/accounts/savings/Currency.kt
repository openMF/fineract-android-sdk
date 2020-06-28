package org.mifos.core.models.accounts.savings

import android.os.Parcel
import android.os.Parcelable

/**
 * Created by grandolf49 on 28-06-2020
 */
data class Currency(
    var code: String? = null,
    var name: String? = null,
    var decimalPlaces: Int? = null,
    var inMultiplesOf: Int? = null,
    var displaySymbol: String? = null,
    var nameCode: String? = null,
    var displayLabel: String? = null
) : Parcelable {

    constructor(parcel: Parcel) : this() {
        code = parcel.readString()
        name = parcel.readString()
        decimalPlaces = parcel.readValue(Int::class.java.classLoader) as Int?
        inMultiplesOf = parcel.readValue(Int::class.java.classLoader) as Int?
        displaySymbol = parcel.readString()
        nameCode = parcel.readString()
        displayLabel = parcel.readString()
    }

    companion object {
        val CREATOR: Parcelable.Creator<Currency?> = object : Parcelable.Creator<Currency?> {
            override fun createFromParcel(source: Parcel): Currency? {
                return Currency(source)
            }

            override fun newArray(size: Int): Array<Currency?> {
                return arrayOfNulls(size)
            }
        }
    }

    override fun describeContents(): Int {
        return 0
    }

    override fun writeToParcel(dest: Parcel, flags: Int) {
        dest.writeString(code)
        dest.writeString(name)
        dest.writeValue(decimalPlaces)
        dest.writeValue(inMultiplesOf)
        dest.writeString(displaySymbol)
        dest.writeString(nameCode)
        dest.writeString(displayLabel)
    }

}