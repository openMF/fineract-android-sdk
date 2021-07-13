package org.mifos.core.apimanager

import com.google.gson.Gson
import org.apache.fineract.client.services.*
import org.apache.fineract.client.util.FineractClient
import org.mifos.core.apimanager.MifosOkHttpClient.mifosOkHttpClient
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.converter.scalars.ScalarsConverterFactory

/**
 * Created by grandolf49 on 06-06-2020
 *
 * A class to provide the Retrofit service to the SDK
 */
class BaseApiManagerImpl : BaseApiManager {

    private lateinit var client: FineractClient

    override fun createService(username: String, password: String, baseUrl: String, tenant: String) {
        val builder = FineractClient.builder()
            .baseURL(baseUrl)
            .basicAuth(username, password)
            .tenant(tenant)

        builder.retrofitBuilder.addConverterFactory(ScalarsConverterFactory.create())
            .addConverterFactory(ScalarsConverterFactory.create())
            .addConverterFactory(GsonConverterFactory.create(Gson()))
            .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
            .client(mifosOkHttpClient)

        client = builder.build()
    }

    override fun getClient(): FineractClient {
        return client
    }

    override fun getAuthApi(): AuthenticationHttpBasicApi = client.authentication

    override fun getCenterApi(): CentersApi = client.centers

    override fun getClientsApi(): ClientApi = client.clients

    override fun getDataTableApi(): DataTablesApi = client.dataTables

    override fun getLoanApi(): LoansApi = client.loans

    override fun getSavingsApi(): SavingsAccountApi = client.savingsAccounts

    override fun getSearchApi(): SearchApiApi = client.search

    override fun getGroupApi(): GroupsApi = client.groups

    override fun getDocumentApi(): DocumentsApiFixed = client.documents

    override fun getOfficeApi(): OfficesApi = client.offices

    override fun getStaffApi(): StaffApi = client.staff

    override fun getSurveyApi(): SpmSurveysApi = client.surveys

    override fun getChargeApi(): ChargesApi = client.charges

    override fun getRunReportsService(): RunReportsApi = client.reportsRun

    override fun getNoteApi(): NotesApi = client.notes

    override fun getCollectionSheetApi(): CentersApi = client.centers

    override fun getCheckerInboxApi(): AuditsApi = client.audits

    override fun getRescheduleLoansApi(): LoanReschedulingApi = client.loanSchedules
}