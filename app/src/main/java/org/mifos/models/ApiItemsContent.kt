package org.mifos.models

import org.mifos.core.ApiEndPoints

/**
 * Created by grandolf49 on 17-06-2020
 *
 * A class to store the content of ApiItems to be displayed in the RecyclerView
 */
class ApiItemsContent {

    companion object {

        fun getApiItemsContent(): MutableList<ApiItemModel> {
            val apiList: MutableList<ApiItemModel> = arrayListOf()

            apiList.add(
                ApiItemModel(
                    "Authentication API",
                    "Authenticate user who is not connected to any service",
                    "Authenticated successfully or not",
                    ApiEndPoints.AUTHENTICATION,
                    null
                )
            )
            apiList.add(
                ApiItemModel(
                    "Client API",
                    "Retrieve a client",
                    "Client exists or not",
                    ApiEndPoints.CLIENTS,
                    null
                )
            )
            apiList.add(
                ApiItemModel(
                    "Loan Accounts API",
                    "Retrieve loan account of a user",
                    "Loan account exists or not",
                    ApiEndPoints.DATATABLES,
                    null
                )
            )
            apiList.add(
                ApiItemModel(
                    "Savings Account API",
                    "Retrieve savings account of a user",
                    "Savings account exists or not",
                    ApiEndPoints.SAVINGSACCOUNTS,
                    null
                )
            )
            apiList.add(
                ApiItemModel(
                    "Authentication API",
                    "Authenticate user who is not connected to any service",
                    "Authenticated successfully or not",
                    ApiEndPoints.AUTHENTICATION,
                    null
                )
            )
            apiList.add(
                ApiItemModel(
                    "Client API",
                    "Retrieve a client",
                    "Client exists or not",
                    ApiEndPoints.CLIENTS,
                    null
                )
            )
            apiList.add(
                ApiItemModel(
                    "Loan Accounts API",
                    "Retrieve loan account of a user",
                    "Loan account exists or not",
                    ApiEndPoints.DATATABLES,
                    null
                )
            )
            apiList.add(
                ApiItemModel(
                    "Savings Account API",
                    "Retrieve savings account of a user",
                    "Savings account exists or not",
                    ApiEndPoints.SAVINGSACCOUNTS,
                    null
                )
            )
            apiList.add(
                ApiItemModel(
                    "Authentication API",
                    "Authenticate user who is not connected to any service",
                    "Authenticated successfully or not",
                    ApiEndPoints.AUTHENTICATION,
                    null
                )
            )
            apiList.add(
                ApiItemModel(
                    "Client API",
                    "Retrieve a client",
                    "Client exists or not",
                    ApiEndPoints.CLIENTS,
                    null
                )
            )
            apiList.add(
                ApiItemModel(
                    "Loan Accounts API",
                    "Retrieve loan account of a user",
                    "Loan account exists or not",
                    ApiEndPoints.DATATABLES,
                    null
                )
            )
            apiList.add(
                ApiItemModel(
                    "Savings Account API",
                    "Retrieve savings account of a user",
                    "Savings account exists or not",
                    ApiEndPoints.SAVINGSACCOUNTS,
                    null
                )
            )
            apiList.add(
                ApiItemModel(
                    "Authentication API",
                    "Authenticate user who is not connected to any service",
                    "Authenticated successfully or not",
                    ApiEndPoints.AUTHENTICATION,
                    null
                )
            )
            apiList.add(
                ApiItemModel(
                    "Client API",
                    "Retrieve a client",
                    "Client exists or not",
                    ApiEndPoints.CLIENTS,
                    null
                )
            )
            apiList.add(
                ApiItemModel(
                    "Loan Accounts API",
                    "Retrieve loan account of a user",
                    "Loan account exists or not",
                    ApiEndPoints.DATATABLES,
                    null
                )
            )
            apiList.add(
                ApiItemModel(
                    "Savings Account API",
                    "Retrieve savings account of a user",
                    "Savings account exists or not",
                    ApiEndPoints.SAVINGSACCOUNTS,
                    null
                )
            )

            return apiList
        }
    }
}