package com.example.espressorobot.uiAutomator.cyborgs

import androidx.test.uiautomator.By
import androidx.test.uiautomator.Until
import com.example.espressorobot.uiAutomator.utils.Cyborg

object LoginCyborg : Cyborg() {

    private const val TIMEOUT = 5000L

    fun setEmail(email: String) {
        val emailField = device.findObject(byAppUnderTestRes("etEmail"))
        emailField?.text = email
    }

    fun setPassword(password: String = "password123") {
        val passwordField = device.findObject(byAppUnderTestRes("etPassword"))
        passwordField?.text = password
    }

    fun clickLogin() {
        device.findObject(byAppUnderTestRes("btnLogin"))?.click()
    }

    fun verifyErrorMessage(expected: String) {
        device.wait(Until.hasObject(By.text(expected)), TIMEOUT)
        val errorView = device.findObject(By.text(expected))
        check(errorView != null) { "Expected error message '$expected' not found" }
    }
}
