package org.mifos.core.models.db

import com.google.gson.Gson

/**
 * Created by grandolf49 on 28-06-2020
 */
data class CollectionSheet(
    var dueDate: IntArray? = null,
    var groups: List<MifosGroup?>? = null
) {
    override fun toString(): String {
        return Gson().toJson(this)
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as CollectionSheet

        if (dueDate != null) {
            if (other.dueDate == null) return false
            if (!dueDate!!.contentEquals(other.dueDate!!)) return false
        } else if (other.dueDate != null) return false
        if (groups != other.groups) return false

        return true
    }

    override fun hashCode(): Int {
        var result = dueDate?.contentHashCode() ?: 0
        result = 31 * result + (groups?.hashCode() ?: 0)
        return result
    }
}