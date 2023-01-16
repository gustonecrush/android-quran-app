package id.gustonecrush.androidquranapp.Fragments.Sections

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import id.gustonecrush.androidquranapp.R

/**
 * A simple [Fragment] subclass.
 * Use the [HijbSection.newInstance] factory method to
 * create an instance of this fragment.
 */
class HijbSection : Fragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_hijb_section, container, false)
    }

}