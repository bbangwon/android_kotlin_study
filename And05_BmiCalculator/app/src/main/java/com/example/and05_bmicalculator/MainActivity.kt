package com.example.and05_bmicalculator

import android.content.SharedPreferences
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.preference.PreferenceManager
import kotlinx.android.synthetic.main.activity_main.*
import org.jetbrains.anko.startActivity

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // 이전에 입력한 값 읽어오기
        loadData()

        // Anko 라이브러리를 사용한 코드 단축
        resultButton.setOnClickListener {
            startActivity<ResultActivity>(
                "weight" to weightEditText.text.toString(),
                "height" to heightEditText.text.toString()
            )

            // 액티비티 종료
            finish()

            // 마지막에 입력한 내용 저장
            saveData(heightEditText.text.toString().toInt(), weightEditText.text.toString().toInt())

        }
    }

    private fun saveData(height: Int, weight: Int) {
        // SharedPreferences : 간단한 데이터를 저장할 때 사용
        val pref = PreferenceManager.getDefaultSharedPreferences(this) // 프리퍼런스 객체 생성
        val editor = pref.edit()    //프리퍼런스에 데이터를 담는 용도

        // 키-값 쌍으로 저장
        editor.putInt("KEY_HEIGHT", height)
            .putInt("KEY_WEIGHT", weight)
            .apply()
    }

    private fun loadData() {
        val pref = PreferenceManager.getDefaultSharedPreferences(this)
        var height = pref.getInt("KEY_HEIGHT", 0)
        var weight = pref.getInt("KEY_WEIGHT", 0)
        //defValue : 저장된 값이 없는 경우 0을 기본값으로

        if(height != 0 && weight != 0){
            heightEditText.setText(height.toString())
            weightEditText.setText(weight.toString())
        }
    }

}
