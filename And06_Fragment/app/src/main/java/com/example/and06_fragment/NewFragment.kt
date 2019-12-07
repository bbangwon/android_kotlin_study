package com.example.and06_fragment


import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button

/**
 * A simple [Fragment] subclass.
 */
class NewFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val rootView = inflater.inflate(R.layout.fragment_new, container, false) as ViewGroup
        val button5 = rootView.findViewById<Button>(R.id.button5)
        
        button5.setOnClickListener {
            val activity = activity as MainActivity
            activity.onFragmentChanged(1)
        }
        return rootView
    }


}
