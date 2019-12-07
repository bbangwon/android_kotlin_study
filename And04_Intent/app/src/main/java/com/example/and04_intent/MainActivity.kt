package com.example.and04_intent

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val extra = intent.extras
        if(extra != null)
        {
            val msg = extra.getString("key_extra")
            mTextView.text = msg
        }else{
            mTextView.text = "번들 없음"
        }

        mSendButton.setOnClickListener {
            startSecondActivity()
            finish()    //액티비티 종료
        }
    }

    private fun startSecondActivity() {
        // intent : 데이터를 전송하기 위한 준비 클래스
        val intent = Intent(this, SecondActivity :: class.java)
        val msg = mEditText.text.toString()

        // key, value 형태로 데이터를 저장
        intent.putExtra("key_extra", msg)

        // intent를 바탕으로 액티비티 데이터 전송
        startActivity(intent)
    }
}
