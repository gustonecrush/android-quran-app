package id.gustonecrush.androidquranapp.Activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import id.gustonecrush.androidquranapp.Fragments.*
import id.gustonecrush.androidquranapp.R
import id.gustonecrush.androidquranapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        replaceFragment(QuranFragment())

        binding.bottomNavigationView.setOnItemSelectedListener {

            when(it.itemId) {
                R.id.qurans   -> replaceFragment(QuranFragment())
                R.id.insight  -> replaceFragment(IdeaFragment())
                R.id.pray     -> replaceFragment(PrayFragment())
                R.id.shalat   -> replaceFragment(SholatFragment())
                R.id.bookmark -> replaceFragment(BookmarkFragment())

                else -> {

                }
            }

            true

        }
    }

    private fun replaceFragment(fragment: Fragment) {
        val fragmentManager     = supportFragmentManager
        val fragmentTransaction = fragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.frameLayout, fragment)
        fragmentTransaction.commit()
    }

}