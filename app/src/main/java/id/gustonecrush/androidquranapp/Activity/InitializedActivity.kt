package id.gustonecrush.androidquranapp.Activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import id.gustonecrush.androidquranapp.R
import id.gustonecrush.androidquranapp.Storage.SharedPrefManager
import kotlinx.android.synthetic.main.activity_initialized.*

class InitializedActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_initialized)

        btnGetStartedHandler()
    }

    private fun btnGetStartedHandler() {
        btnGetStarted.setOnClickListener {
            SharedPrefManager.getInstance(applicationContext).saveUser(username.text.toString())
            startActivity(Intent(this, MainActivity::class.java))
        }
    }
}