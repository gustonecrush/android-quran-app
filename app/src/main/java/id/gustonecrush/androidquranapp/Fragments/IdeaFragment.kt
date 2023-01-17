package id.gustonecrush.androidquranapp.Fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import id.gustonecrush.androidquranapp.R

/**
 * A simple [Fragment] subclass.
 * Use the [IdeaFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class IdeaFragment : Fragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_idea, container, false)
    }

}