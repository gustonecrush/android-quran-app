package id.gustonecrush.androidquranapp.Activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import id.gustonecrush.androidquranapp.R
import kotlinx.android.synthetic.main.activity_surah_detail.*

class SurahDetailActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_surah_detail)

        btnBackHandler()
    }

    private fun btnBackHandler() {
        btnBack.setOnClickListener {
            startActivity(Intent(this, MainActivity::class.java))
        }
    }
}