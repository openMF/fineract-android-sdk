package org.mifos.core.sharedpreference

import android.content.Context
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.platform.app.InstrumentationRegistry
import com.google.common.truth.Truth.assertThat
import org.junit.After
import org.junit.Test
import org.junit.runner.RunWith
import org.mifos.core.apimanager.BaseUrl
import org.mifos.core.models.user.User

@RunWith(AndroidJUnit4::class)
class UserPreferencesTest{

    private val context: Context get() = InstrumentationRegistry.getInstrumentation().targetContext
    private val preference = UserPreferences(context)
    private val testToken = "this-is-test-token"
    private val testUserId = 123456789
    private val testTenant = "this-is-test-tenant"
    private val testInstanceUrl = "this-is-test-instance-url"
    private val testDomain = "this-is-test-domain"
    private val testPort = "8080"
    private val testPasscode = "this-is-test-passcode"
    private val testUserStatus = 1

    @After
    fun after() {
        preference.clear()
    }

    @Test
    fun saveUser() {
        val user = User()
        preference.saveUser(user)
        assertThat(user).isEqualTo(preference.getUser())
    }

    @Test
    fun getUser() {
        val user = preference.getUser()
        assertThat(user).isNull()
    }

    @Test
    fun saveToken() {
        preference.saveToken(testToken)
        assertThat(preference.getToken()).isEqualTo(testToken)
    }

    @Test
    fun clearToken() {
        preference.clearToken()
        val token = preference.getToken()
        assertThat(token).isEqualTo("")
    }

    @Test
    fun getToken() {
        val token = preference.getToken()
        assertThat(token).isEqualTo("")
    }

    @Test
    fun isAuthenticated() {
        val authState = preference.isAuthenticated()
        assertThat(authState).isFalse()
    }

    @Test
    fun getUserId() {
        val id = preference.getUserId()
        assertThat(id).isEqualTo(-1)
    }

    @Test
    fun setUserId() {
        preference.setUserId(testUserId)
        assertThat(preference.getUserId()).isEqualTo(testUserId)
    }

    @Test
    fun getTenant() {
        val tenant = preference.getTenant()
        assertThat(tenant).isEqualTo("default")
    }

    @Test
    fun setTenant() {
        preference.setTenant(testTenant)
        assertThat(preference.getTenant()).isEqualTo(testTenant)
    }

    @Test
    fun getInstanceUrl() {
        val url = preference.getInstanceUrl()
        assertThat(url).isEqualTo("")
    }

    @Test
    fun setInstanceUrl() {
        preference.setInstanceUrl(testInstanceUrl)
        assertThat(preference.getInstanceUrl()).isEqualTo(testInstanceUrl)
    }

    @Test
    fun getInstanceDomain() {
        val domain = preference.getInstanceDomain()
        assertThat(domain).isEqualTo(BaseUrl.API_ENDPOINT)
    }

    @Test
    fun setInstanceDomain() {
        preference.setInstanceDomain(testDomain)
        assertThat(preference.getInstanceDomain()).isEqualTo(testDomain)
    }

    @Test
    fun getPort() {
        val port = preference.getPort()
        assertThat(port).isEqualTo(BaseUrl.PORT)
    }

    @Test
    fun setPort() {
        preference.setPort(testPort)
        assertThat(preference.getPort()).isEqualTo(testPort)
    }

    @Test
    fun getPassCode() {
        val code = preference.getPassCode()
        val codeStatus = preference.getPassCodeStatus()
        assertThat(code).isEqualTo("")
        assertThat(codeStatus).isFalse()
    }

    @Test
    fun setPassCode() {
        preference.setPassCode(testPasscode)
        assertThat(preference.getPassCode()).isEqualTo(testPasscode)
        assertThat(preference.getPassCodeStatus()).isTrue()
    }

    @Test
    fun setUserStatus() {
        preference.setUserStatus(testUserStatus)
        assertThat(preference.getUserStatus()).isEqualTo(testUserStatus)
    }

    @Test
    fun getUserStatus() {
        val status = preference.getUserStatus()
        assertThat(status).isEqualTo(0)
    }

    @Test
    fun setPassCodeStatus() {
        preference.setPassCodeStatus(true)
        assertThat(preference.getPassCodeStatus()).isTrue()
    }

    @Test
    fun getPassCodeStatus() {
        val status = preference.getPassCodeStatus()
        assertThat(status).isFalse()
    }
}