package com.klec.twowheelers

import android.content.res.Configuration
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.LinearLayout
import android.widget.RelativeLayout
import androidx.core.content.ContextCompat

class LoginActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        window.decorView.systemUiVisibility = 0

        val mainLayout = findViewById<RelativeLayout>(R.id.main_layout)
        val currentNightMode = resources.configuration.uiMode and Configuration.UI_MODE_NIGHT_MASK
        if (currentNightMode == Configuration.UI_MODE_NIGHT_YES) {
            mainLayout.setBackgroundColor(ContextCompat.getColor(this, R.color.black))
        } else {
            mainLayout.setBackgroundColor(ContextCompat.getColor(this, R.color.white))
        }

    }
}