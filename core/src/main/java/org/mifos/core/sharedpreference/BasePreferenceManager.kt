package org.mifos.core.sharedpreference

import android.content.Context
import android.content.SharedPreferences
import androidx.preference.PreferenceManager
import com.google.gson.Gson

/**
 * The base class for managing all the shared preference related task
 * @author Danish Jamal - http://github.com/danishjamal104/
 * @property context the context to which this preference belong/bind to
 */
abstract class BasePreferenceManager(val context: Context) {

    private val _preference: SharedPreferences =
        PreferenceManager.getDefaultSharedPreferences(context)
    val preference get() = _preference
    private val editor: SharedPreferences.Editor get() = preference.edit()
    val gson = Gson()

    fun clear() = editor.clear().apply()

    /**
     * The generic method for putting data into shared preference
     * @param T The generic type of data
     * @param key The key of the data to be put in, of type [Key]
     * @param value The actual value of data of type [T]
     */
    fun <T> put(key: Key, value: T?) {
        when (value) {
            is String -> editor.putString(key.value, value).apply()
            is Boolean -> editor.putBoolean(key.value, value).apply()
            is Int -> editor.putInt(key.value, value).apply()
            is Long -> editor.putLong(key.value, value).apply()
            is Float -> editor.putFloat(key.value, value).apply()
            is MutableSet<*> -> editor.putStringSet(key.value, value as MutableSet<String>).apply()
            else -> editor.putString(key.value, value.objectToJson()).apply()
        }
    }

    /**
     * The generic method for getting data from shared preference
     * @param T The type of data to be fetched
     * @param key The key of the data to be fetched, of type [Key]
     * @return the value fetched from preference of type [T]
     */
    inline fun <reified T> get(key: Key, default: T? = null): T? {
        return when (T::class) {
            String::class -> {
                preference.getString(key.value, default?.let { it as String } ?: "") as T
            }
            Boolean::class -> {
                preference.getBoolean(key.value, default?.let { it as Boolean } ?: false) as T
            }
            Int::class -> {
                preference.getInt(key.value, default?.let { it as Int } ?: -1) as T
            }
            Long::class -> {
                preference.getLong(key.value, default?.let { it as Long } ?: -1L) as T
            }
            Float::class -> {
                preference.getFloat(key.value, default?.let { it as Float } ?: -1F) as T
            }
            MutableSet::class -> {
                preference.getStringSet(
                    key.value,
                    default?.let { it as MutableSet<String> } ?: mutableSetOf()) as T
            }
            else -> {
                preference.getString(key.value, default?.let { it as String } ?: "null")
                    ?.jsonToObject<T>()
            }
        }
    }

    /**
     * Extension function for converting any data of type [T] to string using [gson]
     * @param T The generic type of data which is to per converted
     * @return The JSON string of [T]
     */
    private fun <T> T.objectToJson() = gson.toJson(this)

    /**
     * Extension function for converting json string to object of type [T]
     * @param T The generic type of object to which json is to be converted
     * @return The concrete object of type [T]
     */
    inline fun <reified T> String.jsonToObject(): T {
        return gson.fromJson(this, T::class.java)
    }
}

/**
 * Contains all the supported keys, these keys are to be used for fetching and putting the data in
 * shared preferences.
 * @see BasePreferenceManager.get
 * @see BasePreferenceManager.put
 * @see <a href="https://github.com/openMF/android-client/blob/master/mifosng-android/src/main/java/com/mifos/utils/PrefManager.java">openMF/android-client-PrefManager.java</a>
 */
enum class Key(val value: String) {
    USER_ID("preferences_user_id"), TOKEN("preferences_token"),
    TENANT("preferences_tenant"),
    INSTANCE_URL("preferences_instance"),
    INSTANCE_DOMAIN("preferences_domain"),
    PORT("preferences_port"),
    USER_STATUS("user_status"),
    USER_DETAILS("user_details"),
    PASSCODE("passcode"),
    PASSCODE_STATUS("passcode_status")
}