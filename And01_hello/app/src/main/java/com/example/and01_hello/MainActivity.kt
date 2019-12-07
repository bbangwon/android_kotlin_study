package com.example.and01_hello

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        //activity_main.xml 파일을 Activity에 set
        setContentView(R.layout.activity_main)

        // 버튼 id를 가져와서 클릭 기능을 구현
        clickButton.setOnClickListener {
            Toast.makeText(this, "버튼이 눌렸습니다.", Toast.LENGTH_LONG).show()
            // 자바에서는 findViewById() 메서드를 사용해서  객체를 가져와야 함
            // 코틀린에서는 kotlin-android-extensions 라이브러리를 기본으로 사용하여
            // 레이어로 XML 파일에 배치한 뷰 ID를 자동으로 가져와 사용
        }
    }
}
