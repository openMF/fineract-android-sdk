package org.mifos.core.preferencesmanager

import android.content.Context
import android.content.SharedPreferences
import androidx.preference.PreferenceManager
import com.google.gson.Gson
import org.mifos.core.models.user.User

/**
 * Created by grandolf49 on 30-06-2020
 *
 * This class manages the interaction with Shared Preferences and provides APIs to read and modify
 * Shared Preferences.
 */
class MifosPreferenceManager {

    companion object {
        // Preference Keys
        private const val KEY_AUTH_TOKEN = "preferences_token"
        private const val KEY_INSTANCE_URL = "preferences_instance"
        private const val KEY_INSTANCE_DOMAIN = "preferences_domain"
        private const val KEY_PORT = "preferences_port"

        private const val KEY_USER_DETAILS = "user_details"

        // Default Values
        private const val DEFAULT_STRING_VALUE = "null"
        private const val DEFAULT_INT_VALUE = -1
        private const val DEFAULT_BOOL_VALUE = false

        private var context: Context? = null

        private var gson = Gson()

        fun init(context: Context) {
            this.context = context
        }

        /**
         * Returns an object of Shared Preferences which is used to access all preferences.
         */
        private fun getSharedPreferences(): SharedPreferences? {
            return PreferenceManager.getDefaultSharedPreferences(context)
        }

        /**
         * Get and Put Strings in Shared Preferences
         */
        private fun getString(key: String, defaultValue: String): String? {
            return getSharedPreferences()?.getString(key, defaultValue)
        }

        private fun putString(key: String, value: String) {
            getSharedPreferences()?.edit()?.putString(key, value)?.apply()
        }

        /**
         * Get and Put Integers in Shared Preferences
         */
        private fun getInt(key: String, defaultValue: Int): Int? {
            return getSharedPreferences()?.getInt(key, defaultValue)
        }

        private fun putInt(key: String, value: Int) {
            getSharedPreferences()?.edit()?.putInt(key, value)?.apply()
        }

        /**
         * Get and Put Booleans in Shared Preferences
         */
        private fun getBoolean(key: String, defaultValue: Boolean): Boolean? {
            return getSharedPreferences()?.getBoolean(key, defaultValue)
        }

        private fun putBoolean(key: String, value: Boolean) {
            getSharedPreferences()?.edit()?.putBoolean(key, value)?.apply()
        }

        /**
         * Public Methods and APIs available to the user for interacting with the Shared Preferences
         */

        /**
         * 1. Save and Retrieve currently signed in user
         */
        fun saveUser(user: User) {
            putString(KEY_USER_DETAILS, gson.toJson(user))
        }

        fun getUser(): User? {
            return gson.fromJson(
                getString(KEY_USER_DETAILS, DEFAULT_STRING_VALUE),
                User::class.java
            )
        }

        /**
         * 2. Save and retrieve Auth Token
         */
        fun saveToken(token: String) {
            putString(KEY_AUTH_TOKEN, token)
        }

        fun getToken(): String? {
            return getString(KEY_AUTH_TOKEN, DEFAULT_STRING_VALUE)
        }

        fun isAuthenticated(): Boolean {
            return !getToken().equals(DEFAULT_STRING_VALUE)
        }

        /**
         * 3. Connection
         */
        fun setInstanceUrl(instanceUrl: String) {
            putString(KEY_INSTANCE_URL, instanceUrl)
        }

        fun getInstanceUrl(): String? {
            return getString(KEY_INSTANCE_URL, DEFAULT_STRING_VALUE)
        }

        fun setInstanceDomain(instanceDomain: String) {
            putString(KEY_INSTANCE_DOMAIN, instanceDomain)
        }

        fun getInstanceDomain(): String? {
            return getString(KEY_INSTANCE_DOMAIN, DEFAULT_STRING_VALUE)
        }

        fun setPort(port: String) {
            putString(KEY_PORT, port)
        }

        fun getPort(): String? {
            return getString(KEY_PORT, DEFAULT_STRING_VALUE)
        }

        /**
         * Clear all shared preferences
         */
        fun clearPreferences() {
            getSharedPreferences()?.edit()?.clear()?.apply()
        }

    }
}