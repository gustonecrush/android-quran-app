package id.gustonecrush.androidquranapp.Retrofit.Adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import id.gustonecrush.androidquranapp.R
import id.gustonecrush.androidquranapp.Retrofit.Helper.OnSurahClickListener
import id.gustonecrush.androidquranapp.Retrofit.Responses.Surahs
import kotlinx.android.synthetic.main.surah_item.view.*

class SurahAdapter(private val list: ArrayList<Surahs>, private val onSurahClickListener: OnSurahClickListener): RecyclerView.Adapter<SurahAdapter.SurahViewHolder>() {

    inner class SurahViewHolder(itemView: View):
            RecyclerView.ViewHolder(itemView) {
                fun bind(surahResponse: Surahs) {
                    with(itemView) {
                        // get all data surah
                        val numberOfSurah = surahResponse.number
                        val nameOfSurah   = surahResponse.asma?.en?.short
                        val typeOfSurah   = surahResponse.type?.en
                        val versesOfSurah = surahResponse.ayahCount
                        val nameOfSurahInArab = surahResponse.asma?.ar?.short

                        // bind the data to view
                        tv_number_of_surah.text = numberOfSurah.toString()
                        tv_name_of_surah.text   = nameOfSurah
                        tv_type_of_surah.text   = typeOfSurah
                        tv_verses_of_surah.text = versesOfSurah.toString() + " VERSES"
                        tv_name_of_surah_in_arab.text = nameOfSurahInArab
                    }
                }
            }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SurahViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.surah_item, parent, false)
        return SurahViewHolder(view)
    }

    override fun onBindViewHolder(holder: SurahViewHolder, position: Int) {
        holder.bind(list[position])
        holder.itemView.setOnClickListener {
            onSurahClickListener.onSurahItemClicked(position)
        }
    }

    override fun getItemCount(): Int = list.size

}