package org.mifos

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import org.mifos.core.MifosSdk
import org.mifos.core.datamanager.DataManagerAuth

/**
 * An exmaple to illustrate how the API from the SDK will be exposed to the developers.
 * */
class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Additional parameters will be added to this object later
        val mifosSdk: MifosSdk = MifosSdk.Builder()
            .setContext(this)
            .build()

        mifosSdk.getAuthApi().login("username", "password")
    }
}
