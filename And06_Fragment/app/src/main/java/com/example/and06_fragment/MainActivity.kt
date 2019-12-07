package com.example.and06_fragment

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v4.app.FragmentManager

// 프래그먼트(Fragment)
// - Activity 내에서 사용자 인터페이스의 일부를 나타냄
// - 여러개의 프래그먼트를 하나의 액티비티에 조합하여 창이 여러개인 UI를
// 구축할 수 있으며, 하나의 프래그먼트를 여러 액티비티에서 재사용할 수 있음
// - 자체 생명주기를 가지고, 자체 입력 이벤트를 받으며,
// 액티비티 실행 중에 추가 및 제거가 가능한 액티비티의 모듈식 섹션

class MainActivity : AppCompatActivity(), ListFragment.ImageSelectionCallback {
    private lateinit var listFragment : ListFragment
    private lateinit var viewerFragment : ViewerFragment
    private lateinit var newFragment: NewFragment

    // 이미지 배열 선언
    private  var images = intArrayOf(R.drawable.dream01, R.drawable.dream02, R.drawable.dream03)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // 프래그먼트를 관리하는 매니저 객체 선언
        val manager = supportFragmentManager

        // id로 각 프래그먼트 객체 찾아오기
        // MainActivity에 attach된 프래그먼트는 mnanager를 통해 객체 생성
        listFragment = manager.findFragmentById(R.id.listFragment) as ListFragment
        viewerFragment = manager.findFragmentById(R.id.viewerFragment) as ViewerFragment

        //MainActivity에 attach되지 않은 프래그먼트는 객체 생성
        newFragment = NewFragment()
    }

    override fun onImageSelected(position: Int) {
        viewerFragment.setImage(images[position])
    }

    //프래그먼트를 변경하는 함수
    fun onFragmentChanged(index : Int){
        if(index == 0){
            //새로운 프래그먼트 적용
            supportFragmentManager.beginTransaction().replace(R.id.linearLayout, newFragment).commit()
        }else{
            supportFragmentManager.beginTransaction().replace(R.id.linearLayout, viewerFragment).commit()
        }
    }
}
