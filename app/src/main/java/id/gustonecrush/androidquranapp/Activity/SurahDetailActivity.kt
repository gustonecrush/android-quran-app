package id.gustonecrush.androidquranapp.Activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import id.gustonecrush.androidquranapp.R
import id.gustonecrush.androidquranapp.Retrofit.API.QuranAPI
import id.gustonecrush.androidquranapp.Retrofit.Adapters.AyahAdapter
import id.gustonecrush.androidquranapp.Retrofit.Adapters.SurahAdapter
import id.gustonecrush.androidquranapp.Retrofit.Responses.Ayahs
import id.gustonecrush.androidquranapp.Retrofit.Responses.SurahResponse
import id.gustonecrush.androidquranapp.Retrofit.Responses.Surahs
import id.gustonecrush.androidquranapp.Retrofit.Retrofit
import kotlinx.android.synthetic.main.activity_surah_detail.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class SurahDetailActivity : AppCompatActivity() {

    private var numberOfSurah: Int? = null
    private val list = ArrayList<Ayahs>()
    private lateinit var layoutManager: RecyclerView.LayoutManager
    private lateinit var adapter: RecyclerView.Adapter<SurahAdapter.SurahViewHolder>

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

        btnBackHandler()
        getAyahs(numberOfSurah)
    }

    private fun getAyahs(surahID: Int?) {
        val retro = Retrofit.getRetroData().create(QuranAPI::class.java)
        retro.getSurah(surahID).enqueue(object: Callback<SurahResponse> {
            override fun onResponse(call: Call<SurahResponse>, response: Response<SurahResponse>) {
                response.body()?.data?.ayahs?.let { list.addAll(it) }
                rv_ayahs.apply {
                    layoutManager = LinearLayoutManager(context)
                    adapter       = AyahAdapter(list)
                }
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
}