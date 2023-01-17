package id.gustonecrush.androidquranapp.Activity

import android.content.Intent
import android.media.AudioManager
import android.media.MediaPlayer
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout
import id.gustonecrush.androidquranapp.R
import id.gustonecrush.androidquranapp.Retrofit.API.QuranAPI
import id.gustonecrush.androidquranapp.Retrofit.Adapters.AyahAdapter
import id.gustonecrush.androidquranapp.Retrofit.Helper.OnAyahClickListener
import id.gustonecrush.androidquranapp.Retrofit.Responses.Ayahs
import id.gustonecrush.androidquranapp.Retrofit.Responses.SurahResponse
import id.gustonecrush.androidquranapp.Retrofit.Retrofit
import kotlinx.android.synthetic.main.activity_surah_detail.*
import kotlinx.android.synthetic.main.activity_surah_detail.progressBar
import kotlinx.android.synthetic.main.ayah_item.*
import kotlinx.android.synthetic.main.fragment_surahs_section.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.io.IOException

class SurahDetailActivity : AppCompatActivity(), OnAyahClickListener ,SwipeRefreshLayout.OnRefreshListener {

    private var numberOfSurah: Int? = null
    private lateinit var mediaPlayer: MediaPlayer

    private val list = ArrayList<Ayahs>()
    private lateinit var layoutManager: RecyclerView.LayoutManager
    private lateinit var adapter: AyahAdapter

    private var isLoading = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_surah_detail)

        // retrieve intent data
        val number = intent.getIntExtra("number", 0)
        val name   = intent.getStringExtra("name")
        val mean   = intent.getStringExtra("mean")
        val type   = intent.getStringExtra("type")
        val verses = intent.getIntExtra("verses", 0)

        // store intent data to property
        numberOfSurah = number

        // bind data to view
        tv_surah_name_in_header.text    = name
        tv_surah_name_in_jumbotron.text = name
        tv_surah_meaning.text           = mean
        tv_placement.text               = "${type}  •  ${verses} verses"

        layoutManager = LinearLayoutManager(this)
        swipeRefreshAyah.setOnRefreshListener(this)
        setupRecyclerView()
        getAyahs(numberOfSurah, false)
        rv_ayahs.addOnScrollListener(object: RecyclerView.OnScrollListener() {
            override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
                if(!isLoading) {
                    getAyahs(numberOfSurah,false)
                }

                super.onScrolled(recyclerView, dx, dy)
            }
        })

        btnBackHandler()
    }

    private fun getAyahs(surahID: Int?, isOnRefresh: Boolean) {
        isLoading = true
        if (!isOnRefresh) progressBar.visibility = View.VISIBLE

        val retro = Retrofit.getRetroData().create(QuranAPI::class.java)
        retro.getSurah(surahID).enqueue(object: Callback<SurahResponse> {
            override fun onResponse(call: Call<SurahResponse>, response: Response<SurahResponse>) {
                val listResponse = response.body()?.data?.ayahs

                if (listResponse != null) {
                    adapter.addList(listResponse)
                }

                progressBar.visibility = View.INVISIBLE
                isLoading = false
                swipeRefreshAyah.isRefreshing = false
            }

            override fun onFailure(call: Call<SurahResponse>, t: Throwable) {
                Log.d("Ayahs", "onFailure: " + t.message)
            }

        })
    }

    private fun btnBackHandler() {
        btnBack.setOnClickListener {
            startActivity(Intent(this, MainActivity::class.java))
        }
    }

    private fun setupRecyclerView() {
        rv_ayahs.setHasFixedSize(true)
        rv_ayahs.layoutManager = layoutManager
        adapter = AyahAdapter(list, this@SurahDetailActivity, this)
        rv_ayahs.adapter = adapter
    }

    override fun onRefresh() {
        adapter.clear()
        getAyahs(numberOfSurah, true)
    }

    override fun onAyahItemClicked(position: Int) {

    }

}