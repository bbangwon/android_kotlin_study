package com.example.and07_customview

import android.content.Context
import android.graphics.*
import android.view.MotionEvent
import android.view.View
import android.widget.Toast

class CustomView(context: Context?) : View(context) {
    private var paint : Paint? = null

    init {
        makePaint(context)
    }

    private fun makePaint(context: Context?) {
        paint = Paint()
        paint!!.color = Color.BLUE
    }

    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)
//        canvas?.drawRect(100F, 100F, 200F, 200F, paint)
        canvas?.drawPath(trianglePath(300,300), paint)
    }

    private fun trianglePath(x: Int, y: Int): Path {
        val myPath = Path()
        val side = 200
        val height = 300
        val point1 = Point(x, y)    //위 꼭지점
        val point2 = Point(x - side, y + height)    //왼쪽 꼭지점
        val point3 = Point(x + side, y + height)    //오른쪽 꼭지점

        //삼각형 경로 그리기
        myPath.moveTo(point1.x.toFloat(), point1.y.toFloat())
        myPath.lineTo(point2.x.toFloat(), point2.y.toFloat())
        myPath.lineTo(point3.x.toFloat(), point3.y.toFloat())
        myPath.lineTo(point1.x.toFloat(), point1.y.toFloat())

        return myPath
    }

    override fun onTouchEvent(event: MotionEvent?): Boolean {
        if(event?.action == MotionEvent.ACTION_DOWN) {
            Toast.makeText(context, "MotionEvent.ACTION_DOWN : " + "${event.x}, ${event.y}", Toast.LENGTH_LONG).show()
        }
        return super.onTouchEvent(event)
    }
}