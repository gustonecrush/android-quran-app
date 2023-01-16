package id.gustonecrush.androidquranapp.Retrofit.Adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import id.gustonecrush.androidquranapp.R
import id.gustonecrush.androidquranapp.Retrofit.Helper.OnAyahClickListener
import id.gustonecrush.androidquranapp.Retrofit.Responses.Ayahs
import kotlinx.android.synthetic.main.ayah_item.view.*

class AyahAdapter(private val list: ArrayList<Ayahs>): RecyclerView.Adapter<AyahAdapter.AyahViewHolder>() {

    inner class AyahViewHolder(itemView: View):
            RecyclerView.ViewHolder(itemView) {
                fun bind(ayahResponse: Ayahs) {
                    with(itemView) {
                        // get all data ayahs
                        val numberOfAyah = ayahResponse.number?.insurah
                        val ayah         = ayahResponse.text?.ar
                        val meanOfAyah   = ayahResponse.translation?.en

                        // bind data to view
                        tv_number_of_surah.text = numberOfAyah.toString()
                        tv_ayah.text            = ayah
                        tv_meaning.text         = meanOfAyah
                    }
                }
            }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AyahViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.ayah_item, parent, false)
        return AyahViewHolder(view)
    }

    override fun onBindViewHolder(holder: AyahViewHolder, position: Int) {
        holder.bind(list[position])
    }

    override fun getItemCount(): Int = list.size

}