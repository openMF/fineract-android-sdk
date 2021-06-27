package org.mifos.core.datamanager.center

import androidx.lifecycle.LiveData
import org.apache.fineract.client.models.GetCentersResponse
import org.apache.fineract.client.models.Office
import org.mifos.core.apihelper.DataState
import org.mifos.core.apimanager.BaseApiManager
import org.mifos.core.local.helper.DatabaseHelperCenter
import org.mifos.core.models.GenericResponse
import org.mifos.core.models.SaveResponse
import org.mifos.core.models.accounts.CenterAccounts
import org.mifos.core.models.client.ActivatePayload
import org.mifos.core.models.client.Page
import org.mifos.core.models.group.Center
import org.mifos.core.models.group.CenterPayload
import org.mifos.core.models.group.CenterWithAssociations

interface DataManagerCenter {

    /**
     * This Method sending the Request to REST API if UserStatus is 0 and
     * get list of the centers. The response will pass Presenter to show in the view
     *
     *
     * If the offset is zero and UserStatus is 1 then fetch all Center list from Database and show
     * on the view.
     *
     * else if offset is not zero and UserStatus is 1 then return default empty response to
     * presenter
     *
     * @param paged  True Enable the Pagination of the center list REST API
     * @param offset Value give from which position Fetch CentersList
     * @param limit  Maximum Number of centers will come in response
     * @return Centers List page from offset to max Limit
     */
    fun getCenters(paged: Boolean, offset: Int, limit: Int): LiveData<DataState<GetCentersResponse>>

    /**
     * This method save the single Center in Database.
     *
     * @param center Center
     * @return Center
     */
    fun syncCenterInDatabase(center: Center?): LiveData<Center?>?

    /**
     * This Method Fetching the Center Accounts (Loan, saving, etc Accounts ) from REST API
     * and then Saving all Accounts into the Database and then returns the Center Group Accounts
     *
     * @param centerId Center Id
     * @return CenterAccounts
     */
    fun syncCenterAccounts(centerId: Int): LiveData<CenterAccounts?>?

    /**
     * Method Fetching CollectionSheet of the Center from :
     * demo.openmf.org/fineract-provider/api/v1/centers/{centerId}
     * ?associations=groupMembers,collectionMeetingCalendar
     *
     * @param id of the center
     * @return Collection Sheet
     */
    fun getCentersGroupAndMeeting(id: Int): LiveData<CenterWithAssociations?>?

    fun createCenter(centerPayload: CenterPayload?): LiveData<SaveResponse?>?

    /**
     * This Method Fetch the Groups that are attached to the Centers.
     * @param centerId Center Id
     * @return CenterWithAssociations
     */
    fun getCenterWithAssociations(centerId: Int): LiveData<CenterWithAssociations?>?

    /**
     * This Method Request to the DatabaseHelperCenter and DatabaseHelperCenter Read the All
     * centers from Center_Table and give the response Page of List of Center
     *
     * @return Page of Center List
     */
    fun getAllDatabaseCenters(): LiveData<Page<Center?>?>?

    fun getOffices(): LiveData<List<Office?>?>?

    /**
     * This method loading the all CenterPayloads from the Database.
     *
     * @return List<CenterPayload>
    </CenterPayload> */
    fun getAllDatabaseCenterPayload(): LiveData<List<CenterPayload?>?>?

    /**
     * This method will called when user is syncing the Database center.
     * whenever a center is synced then request goes to Database to delete that center form
     * Database and reload the list from Database and update the list in UI
     *
     * @param id of the centerPayload in Database
     * @return List<CenterPayload></CenterPayload>>
     */
    fun deleteAndUpdateCenterPayloads(id: Int): LiveData<List<CenterPayload?>?>?

    /**
     * This Method updating the CenterPayload in Database and return the same CenterPayload
     *
     * @param centerPayload CenterPayload
     * @return CenterPayload
     */
    fun updateCenterPayload(centerPayload: CenterPayload?): LiveData<CenterPayload?>?

    /**
     * This method is activating the center
     *
     * @param centerId
     * @return GenericResponse
     */
    fun activateCenter(
        centerId: Int,
        activatePayload: ActivatePayload?
    ): LiveData<GenericResponse?>?
}