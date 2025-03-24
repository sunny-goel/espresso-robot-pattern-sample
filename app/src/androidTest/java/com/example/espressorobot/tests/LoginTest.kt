package com.example.espressorobot.tests


import androidx.test.filters.LargeTest
import androidx.test.rule.ActivityTestRule
import androidx.test.runner.AndroidJUnit4
import com.example.espressorobot.MainActivity
import com.example.espressorobot.TestLogin
import com.example.espressorobot.flows.LoginFlowTest
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@LargeTest
@RunWith(AndroidJUnit4::class)
class LoginTest : LoginFlowTest() {

    @get:Rule
    override val activityRule: ActivityTestRule<MainActivity> = ActivityTestRule(MainActivity::class.java)

    @Test
    fun loginMissingEmailPassword()  = loginMissingEmailPasswordTestImpl();

    @Test
    fun loginMissingPassword() = loginMissingPasswordTestImpl(TestLogin.TEST_ACCOUNT_INVALID_PASSWORD.email.toString());

    @Test
    fun loginWrongPassword() = loginWrongPasswordTestImpl(TestLogin.TEST_ACCOUNT_INVALID_PASSWORD.email.toString(), TestLogin.TEST_ACCOUNT_INVALID_PASSWORD.password.toString());

    @Test
    fun loginSuccess() = loginSuccessTestImpl(TestLogin.TEST_ACCOUNT_VALID_PASSWORD.email.toString(), TestLogin.TEST_ACCOUNT_VALID_PASSWORD.password.toString() );
}
