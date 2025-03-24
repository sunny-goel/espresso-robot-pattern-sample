package com.example.espressorobot.espresso.framework

import com.example.espressorobot.espresso.utils.ScreenRobot

inline fun <reified T> withRobot(noinline block: T.() -> Unit): T
        where T : ScreenRobot<T> {
    val constructor = T::class.constructors.firstOrNull {
        it.parameters.isEmpty()
    } ?: throw IllegalArgumentException("${T::class.simpleName} must have a no-arg constructor")

    val robot = constructor.call()
    robot.block()
    return robot
}