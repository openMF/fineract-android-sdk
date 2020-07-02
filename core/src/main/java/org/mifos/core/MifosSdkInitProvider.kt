package org.mifos.core

import android.content.ContentProvider
import android.content.ContentValues
import android.database.Cursor
import android.net.Uri

/**
 * Created by grandolf49 on 02-07-2020
 *
 * A class to facilitate implicit initialization of the SDK. This class makes it possible for the
 * SDK to hold a static reference to Application Context.
 */
class MifosSdkInitProvider : ContentProvider() {

    /**
     * Initialize the library here.
     */
    override fun onCreate(): Boolean {
        MifosSdk.initialize(this.context!!)
        return true
    }

    override fun insert(uri: Uri, values: ContentValues?): Uri? {
        return null
    }

    override fun query(
        uri: Uri,
        projection: Array<out String>?,
        selection: String?,
        selectionArgs: Array<out String>?,
        sortOrder: String?
    ): Cursor? {
        return null
    }

    override fun update(
        uri: Uri,
        values: ContentValues?,
        selection: String?,
        selectionArgs: Array<out String>?
    ): Int {
        throw Exception("Not Implemented")
    }

    override fun delete(uri: Uri, selection: String?, selectionArgs: Array<out String>?): Int {
        throw Exception("Not Implemented")
    }

    override fun getType(uri: Uri): String? {
        return null
    }
}