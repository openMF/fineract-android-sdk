package org.mifos.core.services

import io.reactivex.Flowable
import org.mifos.core.apimanager.ApiEndPoints.Companion.CENTERS
import org.mifos.core.models.GenericResponse
import org.mifos.core.models.Payload
import org.mifos.core.models.SaveResponse
import org.mifos.core.models.accounts.CenterAccounts
import org.mifos.core.models.client.ActivatePayload
import org.mifos.core.models.client.Page
import org.mifos.core.models.collectionsheet.CollectionSheetPayload
import org.mifos.core.models.db.CollectionSheet
import org.mifos.core.models.db.OfflineCenter
import org.mifos.core.models.group.Center
import org.mifos.core.models.group.CenterPayload
import org.mifos.core.models.group.CenterWithAssociations
import retrofit2.http.*

/**
 * Created by grandolf49 on 27-06-2020
 */
interface CenterService {

    @GET(CENTERS)
    fun getCenters(
        @Query("paged") b: Boolean,
        @Query("offset") offset: Int,
        @Query("limit") limit: Int
    ): Flowable<Page<Center?>?>?

    @GET("$CENTERS/{centerId}/accounts")
    fun getCenterAccounts(@Path("centerId") centerId: Int): Flowable<CenterAccounts?>?

    @GET("$CENTERS/{centerId}?associations=groupMembers,collectionMeetingCalendar")
    fun getCenterWithGroupMembersAndCollectionMeetingCalendar(@Path("centerId") centerId: Int):
            Flowable<CenterWithAssociations?>?

    @GET(CENTERS)
    fun getAllCentersInOffice(
        @Query("officeId") officeId: Int,
        @QueryMap additionalParams: Map<String?, Any?>?
    ): Flowable<List<Center?>?>?

    @GET("$CENTERS/{centerId}?associations=groupMembers")
    fun getAllGroupsForCenter(@Path("centerId") centerId: Int): Flowable<CenterWithAssociations?>?

    @POST("$CENTERS/{centerId}?command=generateCollectionSheet")
    fun getCollectionSheet(
        @Path("centerId") centerId: Long,
        @Body payload: Payload?
    ): Flowable<CollectionSheet?>?

    @POST("$CENTERS/{centerId}?command=saveCollectionSheet")
    fun saveCollectionSheet(
        @Path("centerId") centerId: Int,
        @Body collectionSheetPayload: CollectionSheetPayload?
    ): Flowable<SaveResponse?>?

    @POST("$CENTERS/{centerId}?command=saveCollectionSheet")
    fun saveCollectionSheetAsync(
        @Path("centerId") centerId: Int,
        @Body collectionSheetPayload: CollectionSheetPayload?
    ): Flowable<SaveResponse?>?

    @POST(CENTERS)
    fun createCenter(@Body centerPayload: CenterPayload?): Flowable<SaveResponse?>?

    @GET(CENTERS)
    fun getCenterList(
        @Query("dateFormat") dateFormat: String?,
        @Query("locale") locale: String?,
        @Query("meetingDate") meetingDate: String?,
        @Query("officeId") officeId: Int,
        @Query("staffId") staffId: Int
    ): Flowable<List<OfflineCenter?>?>?


    /**
     * This is the service to activate the center
     * REST END POINT
     * https://demo.openmf.org/fineract-provider/api/v1/centers/{centerId}?command=activate
     *
     * @param centerId
     * @return GenericResponse
     */
    @POST("$CENTERS/{centerId}?command=activate")
    fun activateCenter(
        @Path("centerId") centerId: Int,
        @Body activatePayload: ActivatePayload?
    ): Flowable<GenericResponse?>?
}