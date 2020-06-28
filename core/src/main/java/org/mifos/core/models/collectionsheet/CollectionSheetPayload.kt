package org.mifos.core.models.collectionsheet

import com.google.gson.Gson
import org.mifos.core.models.BulkRepaymentTransactions

/**
 * Created by grandolf49 on 28-06-2020
 */
data class CollectionSheetPayload(
    var actualDisbursementDate: String? = null,
    var bulkDisbursementTransactions: IntArray? = null,
    var bulkRepaymentTransactions: Array<BulkRepaymentTransactions>,
    var clientsAttendance: Array<String>
) {
    override fun toString(): String {
        return Gson().toJson(this)
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as CollectionSheetPayload

        if (actualDisbursementDate != other.actualDisbursementDate) return false
        if (bulkDisbursementTransactions != null) {
            if (other.bulkDisbursementTransactions == null) return false
            if (!bulkDisbursementTransactions!!.contentEquals(other.bulkDisbursementTransactions!!)) return false
        } else if (other.bulkDisbursementTransactions != null) return false
        if (!bulkRepaymentTransactions.contentEquals(other.bulkRepaymentTransactions)) return false
        if (!clientsAttendance.contentEquals(other.clientsAttendance)) return false

        return true
    }

    override fun hashCode(): Int {
        var result = actualDisbursementDate?.hashCode() ?: 0
        result = 31 * result + (bulkDisbursementTransactions?.contentHashCode() ?: 0)
        result = 31 * result + bulkRepaymentTransactions.contentHashCode()
        result = 31 * result + clientsAttendance.contentHashCode()
        return result
    }
}