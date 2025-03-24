package com.example.espressorobot.espresso.robots

import com.example.espressorobot.R
import com.example.espressorobot.espresso.utils.ScreenRobot


fun profile(func: ProfileRobot.() -> Unit) = ProfileRobot().apply { func() }

class ProfileRobot : ScreenRobot<ProfileRobot>() {

    fun clickSettings() = clickButton(R.id.btnSettings)

    fun toggleNotifications() = clickListItem(android.R.id.list, 0)

    fun toggleNightMode() = clickListItem(android.R.id.list, 1)

}