package id.gustonecrush.androidquranapp.Fragments

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.FragmentPagerAdapter
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.LayoutManager
import androidx.viewpager.widget.ViewPager
import com.google.android.material.tabs.TabLayout
import id.gustonecrush.androidquranapp.Activity.SurahDetailActivity
import id.gustonecrush.androidquranapp.Fragments.Sections.HijbSection
import id.gustonecrush.androidquranapp.Fragments.Sections.PageSection
import id.gustonecrush.androidquranapp.Fragments.Sections.ParaSection
import id.gustonecrush.androidquranapp.Fragments.Sections.SurahsSection
import id.gustonecrush.androidquranapp.R
import id.gustonecrush.androidquranapp.Retrofit.API.QuranAPI
import id.gustonecrush.androidquranapp.Retrofit.Adapters.SurahAdapter
import id.gustonecrush.androidquranapp.Retrofit.Adapters.VPAdapter
import id.gustonecrush.androidquranapp.Retrofit.Helper.OnSurahClickListener
import id.gustonecrush.androidquranapp.Retrofit.Responses.QuranResponse
import id.gustonecrush.androidquranapp.Retrofit.Responses.Surahs
import id.gustonecrush.androidquranapp.Retrofit.Retrofit
import id.gustonecrush.androidquranapp.Storage.SharedPrefManager
import kotlinx.android.synthetic.main.ayah_item.*
import kotlinx.android.synthetic.main.fragment_quran.*
import kotlinx.android.synthetic.main.fragment_quran.tv_ayah
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

/**
 * A simple [Fragment] subclass.
 * Use the [QuranFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class QuranFragment : Fragment() {

    private lateinit var tabLayout: TabLayout
    private lateinit var viewPager: ViewPager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_quran, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val prefs = activity?.getSharedPreferences("my_shared_preff", Context.MODE_PRIVATE)
        val name  = prefs?.getString("name", "Default Name")
        val surah = prefs?.getString("surah", null)
        val ayah  = prefs?.getInt("ayah", 0)
        val type  = prefs?.getString("type", "Default Type")
        val mean  = prefs?.getString("mean", "Default Mean")
        val ayahCount  = prefs?.getInt("ayahCount", 0)
        val surahNumber = prefs?.getInt("surahNumber", 0)

        username.text = name

        if(surah == null) {
            tv_surah_name_latest_read.text = "Al-Faatiah"
        } else {
            tv_surah_name_latest_read.text = surah
        }

        if(ayah != 0) {
            tv_ayah.text = "Ayah No : ${ayah}"
        } else {
            tv_ayah.text = "Ayah No : 1"
        }

        tabLayout = tablayout
        viewPager = section_layout

        tabLayout.setupWithViewPager(viewPager)

        val vpAdapter: VPAdapter = VPAdapter((activity as AppCompatActivity).supportFragmentManager, FragmentPagerAdapter.BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT)
        vpAdapter.addFragment(SurahsSection(), "Surah")
        vpAdapter.addFragment(ParaSection(), "Para")
        vpAdapter.addFragment(PageSection(), "Page")
        vpAdapter.addFragment(HijbSection(), "Hijb")

        viewPager.adapter = vpAdapter

        btnLastReadHandler(surah, surahNumber, type, ayahCount, mean)
    }

    fun btnLastReadHandler(name: String?, surahNumber: Int?, type: String?, ayahCount: Int?, mean: String?) {
        btn_last_read.setOnClickListener {
            val intent = Intent(activity, SurahDetailActivity::class.java)
            intent.putExtra("name", name)
            intent.putExtra("number", surahNumber)
            intent.putExtra("verses", ayahCount)
            intent.putExtra("type", type)
            intent.putExtra("mean", mean)
            startActivity(intent)
        }
    }

}