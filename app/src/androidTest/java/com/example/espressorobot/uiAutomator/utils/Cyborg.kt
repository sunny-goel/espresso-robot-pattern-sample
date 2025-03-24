package com.example.espressorobot.uiAutomator.utils
import androidx.test.uiautomator.By
import androidx.test.uiautomator.BySelector
import androidx.test.uiautomator.UiDevice

open class Cyborg {
    protected val device: UiDevice
        get() = InstrumentationUtils.uiDevice

    // If needed, dynamic resource lookup by app package
    fun byAppUnderTestRes(resourceId: String): BySelector =
        By.res(InstrumentationUtils.targetPackage, resourceId)
}
