package id.gustonecrush.androidquranapp.Fragments

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
import kotlinx.android.synthetic.main.fragment_quran.*
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

        tabLayout = tablayout
        viewPager = section_layout

        tabLayout.setupWithViewPager(viewPager)

        val vpAdapter: VPAdapter = VPAdapter((activity as AppCompatActivity).supportFragmentManager, FragmentPagerAdapter.BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT)
        vpAdapter.addFragment(SurahsSection(), "Surah")
        vpAdapter.addFragment(ParaSection(), "Para")
        vpAdapter.addFragment(PageSection(), "Page")
        vpAdapter.addFragment(HijbSection(), "Hijb")

        viewPager.adapter = vpAdapter
    }

}