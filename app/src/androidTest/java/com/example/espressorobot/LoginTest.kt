package com.example.espressorobot


import androidx.test.filters.LargeTest
import androidx.test.rule.ActivityTestRule
import androidx.test.runner.AndroidJUnit4
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@LargeTest
@RunWith(AndroidJUnit4::class)
class LoginTest {


    @get:Rule
    val mActivityTestRule: ActivityTestRule<MainActivity> = ActivityTestRule(MainActivity::class.java)

    @Test
    fun loginMissingEmailPassword() {
        login {
            clickLogin()
            matchErrorText(string(R.string.missing_fields))
        }
    }

    @Test
    fun loginMissingPassword() {
        login {
            setEmail("mail@example.com")
            clickLogin()
            matchErrorText(string(R.string.missing_fields))
        }
    }

    @Test
    fun loginWrongPassword() {
        login {
            setEmail("mail@example.com")
            setPassword("wrong")
            clickLogin()
            matchErrorText(string(R.string.login_fail))
        }

    }

    @Test
    fun loginSuccess() {
        login {
            setEmail("mail@example.com")
            setPassword("pass")
            clickLogin()
            matchText(R.id.tvName, string(R.string.name_surname))
        }
    }

    @Test
    fun loginProfileAndSettings() {
        login {
            setEmail("mail@example.com")
            setPassword("pass")
            clickLogin()
        }
        profile {
            clickSettings()
            toggleNotifications()
            toggleNightMode()
        }
    }

    private fun string(res: Int): String = mActivityTestRule.activity.getString(res)
}
