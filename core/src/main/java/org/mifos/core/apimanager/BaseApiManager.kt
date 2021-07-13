package org.mifos.core.apimanager

import org.apache.fineract.client.services.*
import org.apache.fineract.client.util.FineractClient

interface BaseApiManager {

    companion object {
        fun getInstance(): BaseApiManager {
            return BaseApiManagerImpl()
        }
    }

    fun createService(username: String, password: String, baseUrl: String, tenant: String)

    fun getClient(): FineractClient

    fun getAuthApi(): AuthenticationHttpBasicApi

    fun getCenterApi(): CentersApi

    fun getClientsApi(): ClientApi

    fun getDataTableApi(): DataTablesApi

    fun getLoanApi(): LoansApi

    fun getSavingsApi(): SavingsAccountApi

    fun getSearchApi(): SearchApiApi

    fun getGroupApi(): GroupsApi

    fun getDocumentApi(): DocumentsApiFixed

    fun getOfficeApi(): OfficesApi

    fun getStaffApi(): StaffApi

    fun getSurveyApi(): SpmSurveysApi

    fun getChargeApi(): ChargesApi

    fun getRunReportsService(): RunReportsApi

    fun getNoteApi(): NotesApi

    fun getCollectionSheetApi(): CentersApi

    fun getCheckerInboxApi(): AuditsApi

    fun getRescheduleLoansApi(): LoanReschedulingApi
}