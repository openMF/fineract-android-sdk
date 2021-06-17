package org.mifos.core.sharedpreference

import android.content.Context
import android.text.TextUtils
import org.mifos.core.apimanager.BaseUrl
import org.mifos.core.models.user.User

/**
 * Shared preferences concrete class for managing user related data
 * @author Danish Jamal - http://github.com/danishjamal104/
 * @property context the context to which this preference belong/bind to
 * @constructor returns the [UserPreferences] instance for managing user related data
 */
class UserPreferences(context: Context) : BasePreferenceManager(context) {

    /**
     * Authentication
     */

    fun saveUser(value: User) = put(Key.USER_DETAILS, value)

    fun getUser() = get<User>(Key.USER_DETAILS)

    fun saveToken(token: String?) = put(Key.TOKEN, token)

    fun clearToken() = put(Key.TOKEN, "")

    fun getToken() = get<String>(Key.TOKEN)

    fun isAuthenticated() = !TextUtils.isEmpty(getToken())

    fun getUserId() = get<Int>(Key.USER_ID)

    fun setUserId(id: Int) = put(Key.USER_ID, id)

    fun getTenant() = get(Key.TENANT, "default")

    fun setTenant(tenant: String?) {
        if (!TextUtils.isEmpty(tenant)) {
            put(Key.TENANT, tenant)
        }
    }

    fun getInstanceUrl() = get<String>(Key.INSTANCE_URL)

    /**
     * Connection
     */
    fun setInstanceUrl(instanceUrl: String?) = put(Key.INSTANCE_URL, instanceUrl)

    fun getInstanceDomain() = get(Key.INSTANCE_DOMAIN, BaseUrl.API_ENDPOINT)

    fun setInstanceDomain(instanceDomain: String?) = put(Key.INSTANCE_DOMAIN, instanceDomain)

    fun getPort() = get(Key.PORT, BaseUrl.PORT)

    fun setPort(port: String?) {
        if (!TextUtils.isEmpty(port)) {
            put(Key.PORT, port)
        }
    }

    fun getPassCode() = get(Key.PASSCODE, "")

    fun setPassCode(passCode: String?) {
        put(Key.PASSCODE, passCode)
        setPassCodeStatus(true)
    }

    /**
     * Set User Status,
     * If O then user is Online
     * If 1 then User is offline
     */
    fun setUserStatus(statusCode: Int) = put(Key.USER_STATUS, statusCode)

    /**
     * @return the Pref value of User status.
     * default is 0(User is online)
     */
    fun getUserStatus() = get(Key.USER_STATUS, 0)

    /**
     * Set Pass Code Status,
     * If `false` then pass code is not set
     * If `true` then pass code is set
     */
    fun setPassCodeStatus(statusCode: Boolean) = put(Key.PASSCODE_STATUS, statusCode)

    /**
     * @return the Pref value of pass code status.
     * default is false(pass code is not set)
     */
    fun getPassCodeStatus() = get(Key.PASSCODE_STATUS, false)
}