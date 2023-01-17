package id.gustonecrush.androidquranapp.Activity

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.widget.AppCompatButton
import id.gustonecrush.androidquranapp.R
import id.gustonecrush.androidquranapp.Storage.SharedPrefManager

class SplashActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        btnGetStartedHandler()
    }

    private fun btnGetStartedHandler() {
        val btnGetStarted = findViewById<AppCompatButton>(R.id.btnGetStarted)
        val prefs         = this.getSharedPreferences("my_shared_preff", Context.MODE_PRIVATE)
        val name          = prefs?.getString("name", null)

        btnGetStarted.setOnClickListener {
            if(name != null) {
                startActivity(Intent(this, MainActivity::class.java))
            } else {
                startActivity(Intent(this, InitializedActivity::class.java))
            }
        }
    }
}