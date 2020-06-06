package org.mifos.core.services

import org.mifos.core.model.APIEndPoint
import org.mifos.core.objects.user.User
import retrofit2.http.POST
import retrofit2.http.Query
import rx.Observable

/**
 * Created by grandolf49 on 06-06-2020
 */
interface AuthService {
    @POST(APIEndPoint.AUTHENTICATION)
    fun authenticate(
        @Query("username") username: String,
        @Query("password") password: String
    ): Observable<User>
}