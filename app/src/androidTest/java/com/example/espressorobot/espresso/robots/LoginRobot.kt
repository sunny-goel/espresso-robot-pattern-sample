package com.example.espressorobot.espresso.robots

import com.example.espressorobot.R
import com.example.espressorobot.espresso.utils.ScreenRobot

fun login(func: LoginRobot.() -> Unit) = LoginRobot().apply { func() }

class LoginRobot : ScreenRobot<LoginRobot>() {

    fun setEmail(email: String) = fillEditText(R.id.etEmail, email);

    fun setPassword(pass: String) = fillEditText(R.id.etPassword, pass)

    fun clickLogin() = clickButton(R.id.btnLogin)

    fun matchErrorText(err: String) = matchText(textView(android.R.id.message), err)

}