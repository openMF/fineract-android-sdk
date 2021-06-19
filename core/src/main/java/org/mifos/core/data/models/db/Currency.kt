package org.mifos.core.models.db

import com.google.gson.Gson

/**
 * Created by grandolf49 on 28-06-2020
 */
data class Currency(
    private var code: String? = null,
    private var name: String? = null,
    private var decimalPlaces: Int = 0,
    private var inMultiplesOf: Int = 0,
    private var displaySymbol: String? = null,
    private var nameCode: String? = null,
    private var displayLabel: String? = null,
    private var loan: Loan? = null
) {
    override fun toString(): String {
        return Gson().toJson(this)
    }
}