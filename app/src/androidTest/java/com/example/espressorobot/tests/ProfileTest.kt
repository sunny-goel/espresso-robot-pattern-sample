package com.example.espressorobot.tests


import androidx.test.filters.LargeTest
import androidx.test.rule.ActivityTestRule
import androidx.test.runner.AndroidJUnit4
import com.example.espressorobot.MainActivity
import com.example.espressorobot.TestLogin
import com.example.espressorobot.flows.ProfileFlowTest
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@LargeTest
@RunWith(AndroidJUnit4::class)
class ProfileTest: ProfileFlowTest() {

    @get:Rule
    override val activityRule: ActivityTestRule<MainActivity> = ActivityTestRule(MainActivity::class.java)


    @Test
    fun loginProfileAndSettings() = loginProfileAndSettingsTestImpl(TestLogin.TEST_ACCOUNT_VALID_PASSWORD.email.toString(), TestLogin.TEST_ACCOUNT_VALID_PASSWORD.password.toString());

}
