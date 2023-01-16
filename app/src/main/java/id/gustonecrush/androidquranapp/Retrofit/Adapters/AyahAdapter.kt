package id.gustonecrush.androidquranapp.Retrofit.Adapters

import android.media.AudioManager
import android.media.MediaPlayer
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import id.gustonecrush.androidquranapp.R
import id.gustonecrush.androidquranapp.Retrofit.Helper.OnAyahClickListener
import id.gustonecrush.androidquranapp.Retrofit.Responses.Ayahs
import id.gustonecrush.androidquranapp.Retrofit.Responses.Surahs
import kotlinx.android.synthetic.main.ayah_item.*
import kotlinx.android.synthetic.main.ayah_item.view.*
import java.io.IOException

class AyahAdapter(private val list: ArrayList<Ayahs>, private val onAyahClickListener: OnAyahClickListener): RecyclerView.Adapter<AyahAdapter.AyahViewHolder>() {

    private lateinit var mediaPlayer: MediaPlayer

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
        holder.itemView.setOnClickListener {
            onAyahClickListener.onAyahItemClicked(position)
        }
        holder.itemView.btn_play.setOnClickListener {
            val bundle = Bundle()
            holder.itemView.btn_play.visibility = View.GONE
            holder.itemView.btn_pause.visibility = View.VISIBLE
            playAyah(list[position]?.audio?.url, list[position]?.number?.insurah)
        }
        holder.itemView.btn_pause.setOnClickListener {
            if (mediaPlayer.isPlaying()) {
                // pausing the media player if media player
                // is playing we are calling below line to
                // stop our media player.
                mediaPlayer.stop();
                mediaPlayer.reset();
                mediaPlayer.release();

                holder.itemView.btn_play.visibility = View.VISIBLE
                holder.itemView.btn_pause.visibility = View.GONE
            } else {
                // this method is called when media
                // player is not playing.
                holder.itemView.btn_play.visibility = View.VISIBLE
                holder.itemView.btn_pause.visibility = View.GONE
            }
        }
    }

    override fun getItemCount(): Int = list.size

    fun addList(items: ArrayList<Ayahs>) {
        list.addAll(items)
        notifyDataSetChanged()
    }

    fun clear() {
        list.clear()
        notifyDataSetChanged()
    }

    private fun playAyah(url: String?, number: Int?) {
        mediaPlayer = MediaPlayer()
        mediaPlayer.setAudioStreamType(AudioManager.STREAM_MUSIC)

        try {
            mediaPlayer.setDataSource(url)
            mediaPlayer.prepare()
            mediaPlayer.start()
        } catch (e: IOException) {
            e.printStackTrace()
        }
    }

}