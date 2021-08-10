package org.mifos.ui

import android.os.Build
import android.os.Bundle
import android.util.Log
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import org.apache.fineract.client.models.*
import org.mifos.R
import org.mifos.core.apimanager.BaseApiManager
import rx.Subscriber
import rx.android.schedulers.AndroidSchedulers
import rx.schedulers.Schedulers
import java.util.*

class HomeActivity : AppCompatActivity(){

    val base_url = "https://10.0.2.2:8443/fineract-provider/api/v1/"
    val tenant = "default"
    lateinit var baseApiManager: BaseApiManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)


        baseApiManager = BaseApiManager.getInstance()
        baseApiManager.createService("mifos", "password", base_url, tenant, false)

        val body = "{\"username\": \"mifos\", \"password\": \"password\"}"

        val req = PostAuthenticationRequest();
        req.username = "mifos"
        req.password = "password"

        baseApiManager.getAuthApi().authenticate(req, true)
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
                    getClientTemplate()
                }

            })
    }


    fun setText(text: String) {
        findViewById<TextView>(R.id.text).text = text
    }

    fun getClient(clientId: Long) {
        baseApiManager.getClientsApi().retrieveOne11(clientId, false)
            .observeOn(AndroidSchedulers.mainThread())
            .subscribeOn(Schedulers.io())
            .subscribe(object : Subscriber<GetClientsClientIdResponse>() {
                override fun onCompleted() {
                    Log.i("subscriber", "completed")
                    setText("completed")
                }

                override fun onError(e: Throwable?) {
                    Log.i("subscriber", "error: ${e?.localizedMessage}")
                    setText("error: ${e?.localizedMessage}")
                }

                override fun onNext(t: GetClientsClientIdResponse?) {
                    Log.i("subscriber", "next: ${t.toString()}")
                    setText("next: ${t.toString()}")
                }

            })
    }

    fun getClientAccounts(clientId: Long) {
        baseApiManager.getClientsApi().retrieveAssociatedAccounts(clientId)
            .observeOn(AndroidSchedulers.mainThread())
            .subscribeOn(Schedulers.io())
            .subscribe(object : Subscriber<GetClientsClientIdAccountsResponse>() {
                override fun onCompleted() {
                    Log.i("subscriber", "completed")
                    setText("completed")
                }

                override fun onError(e: Throwable?) {
                    Log.i("subscriber", "error: ${e?.localizedMessage}")
                    setText("error: ${e?.localizedMessage}")
                }

                override fun onNext(t: GetClientsClientIdAccountsResponse?) {
                    Log.i("subscriber", "next: ${t.toString()}")
                    setText("next: ${t.toString()}")
                }

            })
    }

    fun getClientTemplate() {
        baseApiManager.getClientsApi().retrieveTemplate5(null, null, null)
            .observeOn(AndroidSchedulers.mainThread())
            .subscribeOn(Schedulers.io())
            .subscribe(object: Subscriber< GetClientsTemplateResponse>() {
                override fun onCompleted() {
                    Log.i("subscriber", "completed")
                    setText("completed")
                }

                override fun onError(e: Throwable?) {
                    Log.i("subscriber", "error: ${e?.localizedMessage}")
                    setText("error: ${e?.localizedMessage}")
                }

                override fun onNext(t: GetClientsTemplateResponse?) {
                    Log.i("subscriber", "next: ${t.toString()}")
                    setText("next: ${t.toString()}")
                }

            })
    }

}