package org.mifos.ui

import android.os.Build
import android.os.Bundle
import android.util.Log
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import org.apache.fineract.client.models.PostAuthenticationResponse
import org.mifos.R
import org.mifos.core.apimanager.BaseApiManager
import rx.Subscriber
import rx.android.schedulers.AndroidSchedulers
import rx.schedulers.Schedulers
import java.util.*

class HomeActivity : AppCompatActivity(){

    val base_url = "https://demo.fineract.dev/fineract-provider/api/v1/"
    val tenant = "default"
    lateinit var baseApiManager: BaseApiManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)


        baseApiManager = BaseApiManager.getInstance()
        baseApiManager.createService("mifos", "password", base_url, tenant)

        val body = "{\"username\": \"mifos\", \"password\": \"password\"}"

        baseApiManager.getAuthApi().authenticate(true, body)
            .observeOn(AndroidSchedulers.mainThread())
            .subscribeOn(Schedulers.io())
            .subscribe(object : Subscriber<PostAuthenticationResponse>() {
                override fun onCompleted() {
                    Log.i("subscriber", "completed")
                    setText("completed")
                }

                override fun onError(e: Throwable?) {
                    Log.i("subscriber", "error: ${e?.localizedMessage}")
                    setText("error: ${e?.localizedMessage}")
                }

                override fun onNext(t: PostAuthenticationResponse?) {
                    Log.i("subscriber", "next: ${t.toString()}")
                    setText("next: ${t.toString()}")
                }

            })
    }


    fun setText(text: String) {
        findViewById<TextView>(R.id.text).text = text
    }

}