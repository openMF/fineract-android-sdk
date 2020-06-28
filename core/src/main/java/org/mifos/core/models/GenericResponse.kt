package org.mifos.core.models

import java.util.*

/**
 * Created by grandolf49 on 28-06-2020
 */
data class GenericResponse(
    private var responseFields: HashMap<String, Any>? = null
)