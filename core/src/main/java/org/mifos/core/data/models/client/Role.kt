package org.mifos.core.models.client

/**
 * Created by grandolf49 on 06-06-2020
 */
data class Role(
    var id: Int = 0,
    var name: String = "",
    var description: String = "",
    var disabled: Boolean = false
)