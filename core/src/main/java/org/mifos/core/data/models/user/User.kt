package org.mifos.core.models.user

import org.mifos.core.models.client.Role


/**
 * Created by grandolf49 on 06-06-2020
 */
data class User(
    val username: String? = null,
    val userId: Int = 0,
    val base64EncodedAuthenticationKey: String? = null,
    val authenticated: Boolean = false,
    val officeId: Int = 0,
    val officeName: String? = null,
    val staffId: Int = 0,
    val staffDisplayName: String? = null,
    val roles: List<Role> = ArrayList(),
    val permissions: List<String> = ArrayList()
) {
    companion object {
        val AUTHENTICATION_KEY = "authenticationKey"
    }
}