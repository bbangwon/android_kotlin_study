package com.example.and06_fragment


import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView

class ViewerFragment : Fragment() {
    private lateinit var imageView : ImageView

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val rootView = inflater.inflate(R.layout.fragment_viewer, container, false) as ViewGroup
        imageView = rootView.findViewById(R.id.imageView)
        return rootView
    }

    fun setImage(resId : Int){
        imageView.setImageResource(resId)
    }

}
