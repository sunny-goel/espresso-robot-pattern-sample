# Espresso Robot Pattern Sample

A showcase project for Espresso Robot pattern and UiAutomator Cyborg written in Kotlin.

Command To run All Espresso Tests: 
``
./gradlew connectedAndroidTest \
    -Pandroid.testInstrumentationRunnerArguments.package=com.example.espressorobot.espresso.tests  
``

Command To run All uiAutomator Tests:
``
./gradlew connectedAndroidTest \
    -Pandroid.testInstrumentationRunnerArguments.package=com.example.espressorobot.uiAutomator.tests  
``

Command To run Specific Espresso Test:
``
./gradlew connectedAndroidTest \
    -Pandroid.testInstrumentationRunnerArguments.class=com.example.espressorobot.espresso.tests.LoginTest  
``

Command To run All uiAutomator Tests:
``
./gradlew connectedAndroidTest \
    -Pandroid.testInstrumentationRunnerArguments.class=com.example.espressorobot.uiAutomator.tests.LoginTest  
``