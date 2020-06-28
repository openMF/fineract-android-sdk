package org.mifos.core.models.client

import java.util.*

/**
 * Created by grandolf49 on 27-06-2020
 */
data class Page<T>(
    var totalFilteredRecords: Int = 0,
    var pageItems: List<T> = ArrayList()
)
