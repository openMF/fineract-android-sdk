package org.mifos.core.objects.user

import org.mifos.core.objects.client.Role


/**
 * Created by grandolf49 on 06-06-2020
 */
object User {
    const val AUTHENTICATION_KEY = "authenticationKey"

    private var username: String? = null
    private var userId = 0
    private var base64EncodedAuthenticationKey: String? = null
    private var authenticated = false
    private var officeId = 0
    private var officeName: String? = null
    private var roles: List<Role> = ArrayList()
    private var permissions: List<String> = ArrayList()

    fun getUsername(): String? {
        return username
    }

    fun setUsername(username: String?) {
        User.username = username
    }

    fun getUserId(): Int {
        return userId
    }

    fun setUserId(userId: Int) {
        User.userId = userId
    }

    fun isAuthenticated(): Boolean {
        return authenticated
    }

    fun setAuthenticated(authenticated: Boolean) {
        User.authenticated = authenticated
    }

    fun getOfficeId(): Int {
        return officeId
    }

    fun setOfficeId(officeId: Int) {
        User.officeId = officeId
    }

    fun getOfficeName(): String? {
        return officeName
    }

    fun setOfficeName(officeName: String?) {
        User.officeName = officeName
    }

    fun getRoles(): List<Role>? {
        return roles
    }

    fun setRoles(roles: List<Role>) {
        User.roles = roles
    }

    fun getBase64EncodedAuthenticationKey(): String? {
        return base64EncodedAuthenticationKey
    }

    fun setBase64EncodedAuthenticationKey(base64EncodedAuthenticationKey: String?) {
        User.base64EncodedAuthenticationKey = base64EncodedAuthenticationKey
    }

    fun getPermissions(): List<String>? {
        return permissions
    }

    fun setPermissions(permissions: List<String>) {
        User.permissions = permissions
    }

    override fun toString(): String {
        return "User{" +
                "username='" + username + '\'' +
                ", userId=" + userId +
                ", base64EncodedAuthenticationKey='" + base64EncodedAuthenticationKey + '\'' +
                ", authenticated=" + authenticated +
                ", officeId=" + officeId +
                ", officeName='" + officeName + '\'' +
                ", roles=" + roles +
                ", permissions=" + permissions +
                '}'
    }
}