package com.example.espressorobot

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import android.util.Log
import android.widget.Button

class ProfileActivity : AppCompatActivity() {

    private lateinit var btnSettings: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profile)

        btnSettings = findViewById(R.id.btnSettings)

        btnSettings.setOnClickListener { startActivity(Intent(this, SettingsActivity::class.java)) }

        intent.data?.let {
            Log.i("asd", "host: " + it.host)
            Log.i("asd", "q: " + it.query)
            it.queryParameterNames.forEach { Log.i("asd", "param: " + it) }
        }
    }
}