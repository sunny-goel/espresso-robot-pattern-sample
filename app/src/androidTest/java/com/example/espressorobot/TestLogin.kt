package com.example.espressorobot

enum class TestLogin(
  @JvmField val email: String?,
  @JvmField val password: String? = "",
) {

  TEST_ACCOUNT_INVALID_PASSWORD(email = "mail@example.com", password = "1234test"),
  TEST_ACCOUNT_VALID_PASSWORD(email = "mail@example.com", password = "pass"),
}
