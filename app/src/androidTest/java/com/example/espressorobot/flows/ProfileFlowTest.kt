package com.example.espressorobot.flows

import com.example.espressorobot.robots.ProfileRobot
import com.example.espressorobot.framework.withRobot
import com.example.espressorobot.utils.OnboardingUtils

abstract class ProfileFlowTest: BaseFlowTest() {

    protected fun loginProfileAndSettingsTestImpl(email: String, password: String) {
        withRobot<OnboardingUtils> {
           login(email, password);
        }
        withRobot<ProfileRobot> {
            clickSettings()
            toggleNotifications()
            toggleNightMode()
        }
    }
}
