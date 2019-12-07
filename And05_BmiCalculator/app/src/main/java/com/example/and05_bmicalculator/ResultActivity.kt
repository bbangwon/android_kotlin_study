package com.example.and05_bmicalculator

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_result.*
import org.jetbrains.anko.toast
import kotlin.math.pow

class ResultActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)

        var height : Int
        var weight : Int

        val extra = intent.extras
        if(extra != null){
            height = intent.getStringExtra("height").toInt()
            weight = intent.getStringExtra("weight").toInt()
        }else{
            height = 0
            weight = 0
        }

        val bmi = weight / (height / 100.0).pow(2.0)

        //결과표시
        when {
            bmi >= 35 -> resultTextView.text = "고도 비만"
            bmi >= 30 -> resultTextView.text = "2단계 비만"
            bmi >= 25 -> resultTextView.text = "1단계 비만"
            bmi >= 23 -> resultTextView.text = "과체중"
            bmi >= 18.5 -> resultTextView.text = "정상"
            else -> resultTextView.text = "저체중"
        }

        //이미지 표시
        when{
            bmi >= 23 -> imageView.setImageResource(R.drawable.ic_sentiment_very_dissatisfied_black_24dp)
            bmi >= 18.5 -> imageView.setImageResource(R.drawable.ic_sentiment_satisfied_black_24dp)
            else -> imageView.setImageResource((R.drawable.ic_sentiment_dissatisfied_black_24dp))
        }

        //토스트 메시지 출력
        //Toast.makeText(this, "$bmi", Toast.LENGTH_LONG).show()
        toast("$bmi")

    }
}
