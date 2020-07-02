package org.mifos.core.repositories

import io.reactivex.Flowable
import org.mifos.core.apimanager.BaseApiManager
import org.mifos.core.models.client.Page
import org.mifos.core.models.group.Center

/**
 * Created by grandolf49 on 02-07-2020
 *
 * Repository class to interact with CenterService
 */
class CenterRepository {

    private var baseApiManager = BaseApiManager()

    fun getCenters(
        paged: Boolean = false,
        offset: Int = 0,
        limit: Int = 0
    ): Flowable<Page<Center?>?>? {
        return baseApiManager.getCenterApi()?.getCenters(paged, offset, limit)
    }

}