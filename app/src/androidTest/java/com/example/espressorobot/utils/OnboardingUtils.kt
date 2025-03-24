package com.example.espressorobot.utils

import com.example.espressorobot.robots.LoginRobot
import com.example.espressorobot.framework.withRobot

class OnboardingUtils: ScreenRobot<OnboardingUtils>() {

    fun login(email: String, password: String) {
        withRobot<LoginRobot> {
            setEmail(email)
            setPassword(password)
            clickLogin()
        }
    }
}
