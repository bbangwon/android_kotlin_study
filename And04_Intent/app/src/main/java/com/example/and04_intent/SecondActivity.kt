package com.example.and04_intent

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_second.*

class SecondActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

        // 메인액티비티가 보낸 인텐트의 데이터 추출
        val extras = intent.extras
        if(extras != null){
            val msg = extras.getString("key_extra")
            sTextView.text = msg
        } else {
            sTextView.text = "번들 없음"
        }

        sButton.setOnClickListener {
            startMainActivity()
            finish()
        }
    }

    private fun startMainActivity() {
        val intent = Intent(this, MainActivity :: class.java)

        val msg = sEditText.text.toString()
        intent.putExtra("key_extra", msg)
        //intent.setFlags()
        startActivity(intent)
    }
}
