package org.mifos.core.apimanager

import com.google.gson.GsonBuilder
import org.apache.fineract.client.util.FineractClient
import org.mifos.core.apimanager.MifosOkHttpClient.mifosOkHttpClient
import org.mifos.core.sharedpreference.UserPreferences
import org.mifos.core.utils.JsonDateSerializer
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.converter.scalars.ScalarsConverterFactory
import java.util.*

/**
 * Created by grandolf49 on 06-06-2020
 *
 * A class to provide the Retrofit service to the SDK
 */
class BaseApiManagerImpl(private val userPreferences: UserPreferences) : BaseApiManager {

    private var client: FineractClient? = null

    override fun createService(username: String, password: String) {
        val builder = FineractClient.builder()
            .baseURL(userPreferences.getInstanceUrl())
            .basicAuth(username, password)
            .tenant(userPreferences.getTenant())

        builder.retrofitBuilder.addConverterFactory(ScalarsConverterFactory.create())
            .addConverterFactory(
                GsonConverterFactory.create(
                    GsonBuilder().registerTypeAdapter(
                        Date::class.java,
                        JsonDateSerializer()
                    ).create()
                )
            ).addCallAdapterFactory(RxJava2CallAdapterFactory.create()).client(mifosOkHttpClient)

        client = builder.build()
    }

    override fun getClient(): FineractClient {
        return client!!
    }

    override fun getAuthApi() = client?.authentication

    override fun getCenterApi() = client?.centers

    override fun getClientsApi() = client?.clients

    override fun getDataTableApi() = client?.dataTables

    override fun getLoanApi() = client?.loans

    override fun getSavingsApi() = client?.savingsAccounts

    override fun getSearchApi() = client?.search

    override fun getGroupApi() = client?.groups

    override fun getDocumentApi() = client?.documents

    override fun getOfficeApi() = client?.offices

    override fun getStaffApi() = client?.staff

    override fun getSurveyApi() = client?.surveys

    override fun getChargeApi() = client?.charges

    override fun getRunReportsService() = client?.reportsRun

    override fun getNoteApi() = client?.notes

    override fun getCollectionSheetApi() = client?.centers

    override fun getCheckerInboxApi() = client?.audits

    override fun getRescheduleLoansApi() = client?.loanSchedules
}