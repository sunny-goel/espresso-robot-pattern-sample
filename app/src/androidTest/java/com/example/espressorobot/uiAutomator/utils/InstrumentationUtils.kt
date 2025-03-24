package com.example.espressorobot.uiAutomator.utils

import android.app.Instrumentation
import android.content.Intent
import android.content.pm.ApplicationInfo
import android.content.pm.PackageManager
import android.content.res.Resources
import androidx.test.platform.app.InstrumentationRegistry
import androidx.test.uiautomator.By
import androidx.test.uiautomator.UiDevice
import androidx.test.uiautomator.Until


object InstrumentationUtils {

    val instrumentation: Instrumentation
        get() = InstrumentationRegistry.getInstrumentation()

    val appUnderTestContext
        get() = instrumentation
            .targetContext!!

    val targetPackage: String
        get() = appUnderTestContext.packageName

    val resources: Resources
        get() = appUnderTestContext.resources

    val uiDevice: UiDevice
        get() = UiDevice.getInstance(instrumentation)

    fun isAppDebuggable(packageName: String): Boolean {
        val applicationInfo = try {
            appUnderTestContext.packageManager.getApplicationInfo(packageName, 0)
        } catch (notFoundException: PackageManager.NameNotFoundException) {
            throw AssertionError(
                "Unable to find package $packageName, is it installed?",
                notFoundException
            )
        }
        return applicationInfo.flags.and(ApplicationInfo.FLAG_DEBUGGABLE) != 0
    }

    fun launchApp() {
        val context = instrumentation.targetContext // ✅ this is important
        val intent = context.packageManager.getLaunchIntentForPackage(targetPackage)?.apply {
            addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK or Intent.FLAG_ACTIVITY_NEW_TASK)
        } ?: throw IllegalStateException("Launch intent not found for package: $targetPackage")

        context.startActivity(intent)

        uiDevice.wait(
            Until.hasObject(By.pkg(targetPackage).depth(0)),
            5000L
        )
    }
}