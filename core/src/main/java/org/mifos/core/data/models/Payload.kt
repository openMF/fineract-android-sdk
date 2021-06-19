package org.mifos.core.models

/**
 * Created by grandolf49 on 28-06-2020
 *
 * From package api.model
 */
data class Payload(
    private var dateFormat: String = "dd MMMM YYYY",
    private var locale: String = "en",
    private var calendarId: Long = 0,
    private var transactionDate: String? = null
)