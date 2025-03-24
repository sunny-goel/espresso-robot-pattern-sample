package com.example.espressorobot.flows

import androidx.test.rule.ActivityTestRule
import com.example.espressorobot.MainActivity
import com.example.espressorobot.R
import com.example.espressorobot.robots.LoginRobot
import com.example.espressorobot.framework.withRobot

abstract class LoginFlowTest: BaseFlowTest() {

    protected fun loginMissingEmailPasswordTestImpl() {
        withRobot<LoginRobot> {
            clickLogin()
            matchErrorText(string(R.string.missing_fields))
        }
    }

    protected fun loginMissingPasswordTestImpl(email: String) {
        withRobot<LoginRobot> {
            setEmail(email)
            clickLogin()
            matchErrorText(string(R.string.missing_fields))
        }
    }

    protected fun loginWrongPasswordTestImpl(email: String, password: String) {
        withRobot<LoginRobot> {
            setEmail(email)
            setPassword(password)
            clickLogin()
            matchErrorText(string(R.string.login_fail))
        }

    }

    protected fun loginSuccessTestImpl(email: String, password: String) {
        withRobot<LoginRobot> {
            setEmail(email)
            setPassword(password)
            clickLogin()
            matchText(R.id.tvName, string(R.string.name_surname))
        }
    }
}
