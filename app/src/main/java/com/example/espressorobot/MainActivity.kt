package com.example.espressorobot

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import android.widget.Button
import android.widget.EditText

class MainActivity : AppCompatActivity(), LoginView {

    private val presenter = LoginPresenter(this)
    private lateinit var btnLogin: Button
    private lateinit var etEmail: EditText
    private lateinit var etPassword: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnLogin = findViewById(R.id.btnLogin)
        etEmail = findViewById(R.id.etEmail)
        etPassword = findViewById(R.id.etPassword)

        btnLogin.setOnClickListener { login() }
    }

    private fun login() {
        presenter.login(etEmail.text.toString(), etPassword.text.toString())
    }

    override fun loginSuccess() {
        startActivity(Intent(this, ProfileActivity::class.java))
        finish()
    }

    override fun loginFail() {
        showError(R.string.login_fail)
    }

    override fun missingFields() {
        showError(R.string.missing_fields)
    }

    private fun showError(msg: Int) {
        val builder = AlertDialog.Builder(this)
        builder
            .setMessage(msg)
            .setPositiveButton(R.string.ok, null)
            .show()
    }
}