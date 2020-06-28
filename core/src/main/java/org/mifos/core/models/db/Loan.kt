package org.mifos.core.models.db

import com.google.gson.Gson

/**
 * Created by grandolf49 on 28-06-2020
 */
data class Loan(
    var disbursementAmount: Double = 0.0,
    var interestDue: Double = 0.0,
    var interestPaid: Double = 0.0,
    var loanId: Int = 0,
    var chargesDue: Double = 0.0,
    var totalDue: Double = 0.0,
    var principalDue: Double = 0.0,
    var principalPaid: Double = 0.0,
    var accountId: String? = null,
    var accountStatusId: Int = 0,
    var productShortName: String? = null,
    var productId: Int = 0,
    private var currency: Currency? = null,
    private var client: Client? = null,
    private var isPaymentChanged: String? = null
) {

    override fun toString(): String {
        return Gson().toJson(this)
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other == null || javaClass != other.javaClass) return false
        val loan = other as Loan
        return loanId == loan.loanId
    }

    override fun hashCode(): Int {
        return loanId
    }
}