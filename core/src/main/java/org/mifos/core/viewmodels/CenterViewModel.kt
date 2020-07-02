package org.mifos.core.viewmodels

import io.reactivex.Flowable
import org.mifos.core.models.client.Page
import org.mifos.core.models.group.Center
import org.mifos.core.repositories.CenterRepository

/**
 * Created by grandolf49 on 02-07-2020
 */
class CenterViewModel {

    private val centerRepository = CenterRepository()

    fun getCenters(
        paged: Boolean = false,
        offset: Int = 0,
        limit: Int = 0
    ): Flowable<Page<Center?>?>? {
        return centerRepository.getCenters(paged, offset, limit)
    }

}