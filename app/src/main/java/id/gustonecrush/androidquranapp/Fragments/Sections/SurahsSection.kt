package id.gustonecrush.androidquranapp.Fragments.Sections

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import id.gustonecrush.androidquranapp.Activity.SurahDetailActivity
import id.gustonecrush.androidquranapp.R
import id.gustonecrush.androidquranapp.Retrofit.API.QuranAPI
import id.gustonecrush.androidquranapp.Retrofit.Adapters.SurahAdapter
import id.gustonecrush.androidquranapp.Retrofit.Helper.OnSurahClickListener
import id.gustonecrush.androidquranapp.Retrofit.Responses.QuranResponse
import id.gustonecrush.androidquranapp.Retrofit.Responses.Surahs
import id.gustonecrush.androidquranapp.Retrofit.Retrofit
import kotlinx.android.synthetic.main.fragment_surahs_section.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

/**
 * A simple [Fragment] subclass.
 * Use the [SurahsSection.newInstance] factory method to
 * create an instance of this fragment.
 */
class SurahsSection : Fragment(), OnSurahClickListener {

    private val list = ArrayList<Surahs>()
    private lateinit var layoutManager: RecyclerView.LayoutManager
    private lateinit var adapter: RecyclerView.Adapter<SurahAdapter.SurahViewHolder>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_surahs_section, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        getSurahs()
    }

    private fun getSurahs() {
        val retro = Retrofit.getRetroData().create(QuranAPI::class.java)
        retro.getQuran().enqueue(object: Callback<QuranResponse> {
            override fun onResponse(call: Call<QuranResponse>, response: Response<QuranResponse>) {
                response.body()?.data?.let { list.addAll(it) }
                rv_surahs.apply {
                    layoutManager = LinearLayoutManager(activity, LinearLayoutManager.VERTICAL ,false)
                    adapter       = SurahAdapter(list, this@SurahsSection)
                }
            }

            override fun onFailure(call: Call<QuranResponse>, t: Throwable) {
                Log.d("Surah", "onFailure: " + t.message)
            }

        })
    }

    override fun onSurahItemClicked(position: Int) {
        val intent = Intent(activity, SurahDetailActivity::class.java)
        intent.putExtra("number", list[position]?.number)
        intent.putExtra("name", list[position]?.asma?.en?.short)
        intent.putExtra("mean", list[position]?.asma?.translation?.en)
        intent.putExtra("type", list[position]?.type?.en)
        intent.putExtra("verses", list[position]?.ayahCount)

        startActivity(intent)
    }

}