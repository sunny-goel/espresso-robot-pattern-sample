package com.example.espressorobot.espresso.flows

import com.example.espressorobot.espresso.robots.ProfileRobot
import com.example.espressorobot.espresso.framework.withRobot
import com.example.espressorobot.espresso.utils.OnboardingUtils

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
