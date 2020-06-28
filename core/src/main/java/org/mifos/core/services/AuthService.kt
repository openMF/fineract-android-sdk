package org.mifos.core.services

import io.reactivex.Flowable
import org.mifos.core.ApiEndPoints
import org.mifos.core.models.user.User
import retrofit2.http.POST
import retrofit2.http.Query

/**
 * Created by grandolf49 on 06-06-2020
 *
 * Authentication API that returns a Flowable object. It can be converted to Observable or
 * LiveData depending on the user requirement
 */
interface AuthService {
    @POST(ApiEndPoints.AUTHENTICATION)
    fun authenticate(
        @Query("username") username: String,
        @Query("password") password: String
    ): Flowable<User>
}