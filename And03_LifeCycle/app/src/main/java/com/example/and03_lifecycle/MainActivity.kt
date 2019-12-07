package com.example.and03_lifecycle

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log

const val TAG = "edu.android.and03"
class MainActivity : AppCompatActivity() {
    init {
        Log.i(TAG, "MainActivity Called()")
    }

    // onCreate() : 앱이 처음 실행될 때 ART(Android Run-Time)이 호출하는 메소드
    // - 레이아웃과 위젯들이 생성됨
    // - 대부분의 초기화가 이루어짐
    // - 화면에 보이지 않는 상태(invisible)
    override fun onCreate(savedInstanceState: Bundle?) {
        Log.i(TAG, "onCreate() 호출")
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    // onStart() : onCreate() 이후에 호출되는 생명 주기 메소드
    // - 화면에 보이는 상태(visible)
    //- 이벤트 처리는 할 수 없는 상태(not focus)
    // - 시각 요소들을 드로잉 할 때 주로 사용됨
    override fun onStart() {
        super.onStart()
        Log.i(TAG, "onStart() 호출")
    }

    // onResume() : onStart() 이후에 호출되는 생명 주기 메소드
    // - 화면에 보이는 상태(visible)
    // - 이벤트 처리가 가능한 상태(focus)
    // - 액티비티가 활성화되었고 입력을 받을 수 있는 상태를 나타냄
    override fun onResume() {
        super.onResume()
        Log.i(TAG, "onResume() 호출")
    }

    // onPause() : 앱이 백그라운드로 가거나 종료될 때 불리는 메소드
    // - 화면에는 보이는 상태(visible)
    // - 이벤트 처리를 할 수 없는 상태
    override fun onPause() {
        super.onPause()
        Log.i(TAG, "onPause() 호출")
    }

    //onStop() : onPause() 이후에 호출되는 생명 주기 메소드
    // - 화면에서 보이지 않는 상태, 이벤트 처리를 할 수 없는 상태
    // - UI 업데이트나 애니메이션 실행, 다른 시각적인 것들을 멈추기에 좋음
    override fun onStop() {
        super.onStop()
        Log.i(TAG, "onStop() 호출")
    }

    // onDestroy() : onStop() 이후에 호출되는 생명 주기 메소드
    // - 레이아웃과 위젯 객체를 소멸시키는 역할
    override fun onDestroy() {
        super.onDestroy()
        Log.i(TAG, "onDestroy() 호출")
    }

    // onRestart() : onStop() 상태에서 onStart() 상태로 바뀔 때
    // 중간에 호출되는 생명 주기 메소드
    override fun onRestart() {
        super.onRestart()
        Log.i(TAG, "onRestart() 호출")
    }
}
