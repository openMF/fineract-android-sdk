package org.mifos.core.local.helper

import androidx.lifecycle.LiveData
import org.mifos.core.models.SaveResponse
import org.mifos.core.models.accounts.CenterAccounts
import org.mifos.core.models.client.Page
import org.mifos.core.models.group.Center
import org.mifos.core.models.group.CenterPayload
import org.mifos.core.models.group.CenterWithAssociations

interface DatabaseHelperCenter {
    /**
     * Saving Centers in Database using DBFlow.
     * save() method save the value reference to primary key if its exist the update if not the
     * insert.
     *
     * @param centerPage
     * @return null
     */
    fun saveAllCenters(centerPage: Page<Center?>): LiveData<Void?>?

    /**
     * Reading All Centers from table of Center and return the CenterList
     *
     * @return List Of Centers
     */
    //TODO Implement LiveData Transaction to load Center List
    fun readAllCenters(): LiveData<Page<Center?>?>?

    fun saveCenterPayload(centerPayload: CenterPayload): LiveData<SaveResponse?>?

    fun readAllCenterPayload(): LiveData<List<CenterPayload?>?>?

    /**
     * This Method Fetch the Groups that are attached to the Center.
     * @param centerId Center Id
     * @return CenterWithAssociations
     */
    fun getCenterAssociateGroups(centerId: Int): LiveData<CenterWithAssociations?>?

    /**
     * This Method Saving the Single Center in the Database
     *
     * @param center
     * @return LiveData.just(Center)
     */
    fun saveCenter(center: Center): LiveData<Center?>?

    /**
     * This Method for deleting the center payload from the Database according to Id and
     * again fetch the center List from the Database CenterPayload_Table
     * @param id is Id of the Center Payload in which reference center was saved into Database
     * @return List<CenterPayload></CenterPayload>>
     */
    fun deleteAndUpdateCenterPayloads(id: Int): LiveData<List<CenterPayload?>?>?

    fun updateDatabaseCenterPayload(
        centerPayload: CenterPayload
    ): LiveData<CenterPayload?>?

    /**
     * This Method  write the CenterAccounts in tho DB. According to Schema Defined in Model
     *
     * @param centerAccounts Model of List of LoanAccount and SavingAccount
     * @param centerId       Center Id
     * @return CenterAccounts
     */
    fun saveCenterAccounts(
        centerAccounts: CenterAccounts,
        centerId: Int
    ): LiveData<CenterAccounts?>?
}