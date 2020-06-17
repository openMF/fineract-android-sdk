package org.mifos.models

import org.mifos.core.ApiEndPoint

/**
 * Created by grandolf49 on 17-06-2020
 *
 * A class to store the content of ApiItems to be displayed in the RecyclerView
 */
class ApiItemsContent {

    companion object {

        fun getApiItemsContent(): MutableList<ApiItemModel> {
            val apiList: MutableList<ApiItemModel> = arrayListOf()
            val apiItemModel1 = ApiItemModel(
                "Authentication API",
                "Authenticate user who is not connected to any service",
                "Authenticated successfully or not",
                ApiEndPoint.AUTHENTICATION,
                null
            )
            val apiItemModel2 = ApiItemModel(
                "Client API",
                "Authenticate user who is not connected to any service",
                "Authenticated successfully or not",
                ApiEndPoint.CLIENTS,
                null
            )
            val apiItemModel3 = ApiItemModel(
                "DataTables API",
                "Authenticate user who is not connected to any service",
                "Authenticated successfully or not",
                ApiEndPoint.DATATABLES,
                null
            )
            val apiItemModel4 = ApiItemModel(
                "Savings Account API",
                "Authenticate user who is not connected to any service",
                "Authenticated successfully or not",
                ApiEndPoint.SAVINGSACCOUNTS,
                null
            )
            apiList.add(apiItemModel1)
            apiList.add(apiItemModel2)
            apiList.add(apiItemModel3)
            apiList.add(apiItemModel4)

            return apiList
        }
    }
}