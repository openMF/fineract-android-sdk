package org.mifos.core.services

import org.mifos.core.ApiEndPoint
import org.mifos.core.models.user.User
import retrofit2.http.POST
import retrofit2.http.Query
import rx.Observable

/**
 * Created by grandolf49 on 06-06-2020
 */
interface AuthService {
    @POST(ApiEndPoint.AUTHENTICATION)
    fun authenticate(
        @Query("username") username: String,
        @Query("password") password: String
    ): Observable<User>
}