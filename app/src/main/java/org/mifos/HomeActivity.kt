package org.mifos

import android.os.Bundle
import android.widget.Toast
import android.widget.Toast.LENGTH_SHORT
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_home.*
import org.mifos.core.MifosSdk
import org.mifos.core.models.user.User
import rx.android.schedulers.AndroidSchedulers
import rx.schedulers.Schedulers

/**
 * An exmaple to illustrate how the API from the SDK will be exposed to the developers.
 * */
class HomeActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        // Additional parameters will be added to this object later
        val mifosSdk: MifosSdk = MifosSdk.Builder()
            .setContext(this)
            .build()

        mifosSdk.getAuthApi().login("mifos", "password")
            ?.observeOn(AndroidSchedulers.mainThread())
            ?.subscribeOn(Schedulers.io())
            ?.subscribe(
                { user ->
                    updateUI(user)
                },
                { error ->
                    Toast.makeText(applicationContext, error.message, LENGTH_SHORT).show()
                }
            )
    }

    private fun updateUI(user: User?) {
        if (user != null) {
            tv_resp.text = user.toString()
        } else
            Toast.makeText(this, "Error: User is not defined", LENGTH_SHORT).show()
    }
}