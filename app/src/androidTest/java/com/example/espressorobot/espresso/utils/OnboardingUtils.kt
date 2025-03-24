package com.example.espressorobot.espresso.utils

import com.example.espressorobot.espresso.robots.LoginRobot
import com.example.espressorobot.espresso.framework.withRobot

class OnboardingUtils: ScreenRobot<OnboardingUtils>() {

    fun login(email: String, password: String) {
        withRobot<LoginRobot> {
            setEmail(email)
            setPassword(password)
            clickLogin()
        }
    }
}
