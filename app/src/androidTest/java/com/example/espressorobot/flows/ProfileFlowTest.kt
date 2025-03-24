package com.example.espressorobot.flows


import androidx.test.rule.ActivityTestRule
import com.example.espressorobot.MainActivity
import com.example.espressorobot.robots.LoginRobot
import com.example.espressorobot.robots.ProfileRobot
import com.example.espressorobot.framework.withRobot

abstract class ProfileFlowTest: BaseFlowTest() {

    protected fun loginProfileAndSettingsTestImpl(email: String, password: String) {
        withRobot<LoginRobot> {
            setEmail(email)
            setPassword(password)
            clickLogin()
        }
        withRobot<ProfileRobot> {
            clickSettings()
            toggleNotifications()
            toggleNightMode()
        }
    }
}
