package com.example.and06_fragment


import android.content.Context
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import kotlinx.android.synthetic.main.fragment_list.*
import kotlinx.android.synthetic.main.fragment_list.view.*

// 버튼 리스트 프래그먼트
class ListFragment : Fragment() {
    interface ImageSelectionCallback {
        fun onImageSelected(position : Int)
    }

    var callback : ImageSelectionCallback? = null

    // Context?
    // - 애플리케이션 환경에 대한 전역 정보 인터페이스
    override fun onAttach(context: Context?) {
        super.onAttach(context)

        if(context is ImageSelectionCallback){
            callback = context
        }
    }

    //뷰를 생성하고 이벤트 수행
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val rootView = inflater.inflate(R.layout.fragment_list, container, false) as ViewGroup

        // ListFragment에 버튼 객체 생성
        val button1 = rootView.findViewById<Button>(R.id.button)
        button1.setOnClickListener {
            callback?.onImageSelected(0)    //메인액티비티의 함수 실행
        }

        val button2 = rootView.findViewById<Button>(R.id.button2)
        button2.setOnClickListener {
            callback?.onImageSelected(1)
        }

        val button3 = rootView.findViewById<Button>(R.id.button3)
        button3.setOnClickListener {
            callback?.onImageSelected(2)
        }

        val button4 = rootView.findViewById<Button>(R.id.button4)
        button4.setOnClickListener {
            val activity = activity as MainActivity
            activity.onFragmentChanged(0)
        }

        return rootView
    }
}
