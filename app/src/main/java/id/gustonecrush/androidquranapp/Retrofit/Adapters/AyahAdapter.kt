//package id.gustonecrush.androidquranapp.Retrofit.Adapters
//
//import android.view.LayoutInflater
//import android.view.View
//import android.view.ViewGroup
//import androidx.recyclerview.widget.RecyclerView
//import id.gustonecrush.androidquranapp.R
//import id.gustonecrush.androidquranapp.Retrofit.Helper.OnAyahClickListener
//
//class AyahAdapter(private val list: ArrayList<Ayahs>, private val onAyahClickListener: OnAyahClickListener): RecyclerView.Adapter<AyahAdapter.AyahViewHolder>() {
//
//    inner class AyahViewHolder(itemView: View):
//            RecyclerView.ViewHolder(itemView) {
//                fun bind(ayahResponse: Ayahs) {
//                    with(itemView) {
//
//                    }
//                }
//            }
//
//    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AyahViewHolder {
//        val view = LayoutInflater.from(parent.context).inflate(R.layout.ayah_item, parent, false)
//        return AyahViewHolder(view)
//    }
//
//    override fun onBindViewHolder(holder: AyahViewHolder, position: Int) {
//        holder.bind(list[position])
//        holder.itemView.setOnClickListener {
//            onAyahClickListener.onAyahItemClicked(position)
//        }
//    }
//
//    override fun getItemCount(): Int = list.size
//
//}