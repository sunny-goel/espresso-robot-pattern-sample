package com.example.espressorobot.uiAutomator.tests

import androidx.test.filters.LargeTest
import androidx.test.runner.AndroidJUnit4
import com.example.espressorobot.TestLogin
import com.example.espressorobot.uiAutomator.cyborgs.LoginCyborg
import com.example.espressorobot.uiAutomator.utils.InstrumentationUtils
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith

@LargeTest
@RunWith(AndroidJUnit4::class)
class LoginTest {

    @Before
    fun setUp() {
        InstrumentationUtils.uiDevice.wakeUp()
        InstrumentationUtils.launchApp()
    }


    @Test
    fun loginSuccessUiTest() {
        with(LoginCyborg) {
            setEmail(TestLogin.TEST_ACCOUNT_VALID_PASSWORD.email.toString())
            setPassword(TestLogin.TEST_ACCOUNT_VALID_PASSWORD.password.toString())
            clickLogin()
        }
    }

    @Test
    fun loginMissingFieldsUiTest() {
        with(LoginCyborg) {
            clickLogin()
            verifyErrorMessage("Please fill email and password fieds")
        }
    }
}
