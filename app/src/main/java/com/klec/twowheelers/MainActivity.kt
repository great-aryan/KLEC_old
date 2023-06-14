package com.klec.twowheelers

import android.content.Intent
import android.content.res.Configuration
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.view.View
import android.widget.LinearLayout
import android.widget.TextView
import androidx.appcompat.app.AppCompatDelegate
import androidx.core.app.ActivityOptionsCompat
import androidx.core.content.ContextCompat

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        window.decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR
        val mainLayout = findViewById<LinearLayout>(R.id.main_layout)
        val currentNightMode = resources.configuration.uiMode and Configuration.UI_MODE_NIGHT_MASK
        if (currentNightMode == Configuration.UI_MODE_NIGHT_YES) {
            mainLayout.setBackgroundColor(ContextCompat.getColor(this, R.color.black))
        } else {
            mainLayout.setBackgroundColor(ContextCompat.getColor(this, R.color.white))
        }

        fun finish() {
            super.finish()
            overridePendingTransition(0, 1)
        }

        Handler().postDelayed({
            // Start the main activity after the delay
            val intent = Intent(this@MainActivity, LoginActivity::class.java)
            val options = ActivityOptionsCompat.makeCustomAnimation(this@MainActivity, android.R.anim.fade_in, android.R.anim.fade_out)
            startActivity(intent, options.toBundle())
            finish()
        }, 1600)
    }
}