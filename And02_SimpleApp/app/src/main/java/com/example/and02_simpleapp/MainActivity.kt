package com.example.and02_simpleapp

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    //이미지의 아이디를 배열로 저장
    private val imageIDs = arrayOf(
            R.drawable.n1,
            R.drawable.n2,
            R.drawable.n3,
            R.drawable.n4,
            R.drawable.n5
    )
    private var curIndex = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        prevButton.setOnClickListener {
            showPrevImage()
        }

        nextButton.setOnClickListener {
            showNextImage()
        }
    }

    private fun showPrevImage() {
        if(curIndex > 0){
            curIndex--
        } else {
            curIndex = imageIDs.size - 1    //배열의 마지막 인덱스
        }

        // 이미지의 아이디를 바탕으로 이미지뷰에 리소스를 생성
        imageView.setImageResource(imageIDs[curIndex])
    }

    private fun showNextImage() {
        if(curIndex < imageIDs.size - 1){
            curIndex++
        } else {
            curIndex = 0
        }

        imageView.setImageResource(imageIDs[curIndex])
    }
}
