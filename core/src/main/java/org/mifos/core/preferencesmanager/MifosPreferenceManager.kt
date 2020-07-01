package org.mifos.core.preferencesmanager

import android.content.Context
import android.content.SharedPreferences
import androidx.preference.PreferenceManager

/**
 * Created by grandolf49 on 30-06-2020
 *
 * This class manages the interaction with Shared Preferences
 */
class MifosPreferenceManager(var context: Context) {

    /**
     * Preference Keys
     */
    companion object {
        private val KEY_AUTH_TOKEN = "preferences_token"
        private val KEY_INSTANCE_URL = "preferences_instance"
        private val KEY_INSTANCE_DOMAIN = "preferences_domain"
        private val KEY_USER_DETAILS = "user_details"
        private val KEY_USER_STATUS = "user_status"
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
    fun getString(key: String, defaultValue: String): String? {
        return getSharedPreferences()?.getString(key, defaultValue)
    }

    fun putString(key: String, value: String) {
        getSharedPreferences()?.edit()?.putString(key, value)?.apply()
    }

    /**
     * Get and Put Integers in Shared Preferences
     */
    fun getInt(key: String, defaultValue: Int): Int? {
        return getSharedPreferences()?.getInt(key, defaultValue)
    }

    fun putInt(key: String, value: Int) {
        getSharedPreferences()?.edit()?.putInt(key, value)?.apply()
    }

    /**
     * Get and Put Booleans in Shared Preferences
     */
    fun getBoolean(key: String, defaultValue: Boolean): Boolean? {
        return getSharedPreferences()?.getBoolean(key, defaultValue)
    }

    fun putBoolean(key: String, value: Boolean) {
        getSharedPreferences()?.edit()?.putBoolean(key, value)?.apply()
    }
}