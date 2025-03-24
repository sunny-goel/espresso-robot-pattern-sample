package com.example.espressorobot.espresso.flows

import androidx.test.rule.ActivityTestRule
import com.example.espressorobot.MainActivity

abstract class BaseFlowTest {
    // This will be provided by child classes
    abstract val activityRule: ActivityTestRule<MainActivity>

    fun string(res: Int): String = activityRule.activity.getString(res)
}

