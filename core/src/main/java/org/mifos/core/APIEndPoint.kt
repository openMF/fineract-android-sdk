package org.mifos.core

/**
 * Created by grandolf49 on 06-06-2020
 *
 * This class contains all the Constants for API End Points
 */
class APIEndPoint {

    companion object {
        // Instance URL is temporary. It will be later moved to Shared Preferences.
        const val INSTANCE_URL = "http://demo.openmf.org"
        const val AUTHENTICATION = "authentication"
        const val CHARGES = "charges"
        const val CENTERS = "centers"
        const val CLIENTS = "clients"
        const val LOANS = "loans"
        const val SURVEYS = "surveys"
        const val SEARCH = "search"
        const val CREATESAVINGSACCOUNTS = "savingsaccounts"
        const val CREATESAVINGSPRODUCTS = "savingsproducts"
        const val CREATELOANSACCOUNTS = "loans"
        const val CREATELOANSPRODUCTS = "loanproducts"
        const val DATATABLES = "datatables"
        const val GROUPS = "groups"
        const val DOCUMENTS = "documents"
        const val IDENTIFIERS = "identifiers"
        const val OFFICES = "offices"
        const val STAFF = "staff"
        const val RUNREPORTS = "runreports"
        const val COLLECTIONSHEET = "collectionsheet"

        const val SAVINGSACCOUNTS = "savingsaccounts"
        const val RECURRING_ACCOUNTS = "recurringdepositaccounts"

        const val DISBURSE = "disburse"
        const val NOTES = "notes"
        const val MAKERCHECKER = "makercheckers"
    }
}