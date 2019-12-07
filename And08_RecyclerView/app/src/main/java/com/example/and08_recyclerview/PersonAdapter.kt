package com.example.and08_recyclerview

import android.support.v7.widget.RecyclerView
import android.view.View
import android.widget.TextView

class PersonAdapter {

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        private var textView = itemView.findViewById<TextView>(R.id.textView)
        private var textView2 = itemView.findViewById<TextView>(R.id.textView2)

        // TODO: 아이템 클릭시 이벤트 발생 코드
        

        fun setItem(item: Person){
            textView.text = item.name
            textView2.text = item.mobile
        }
    }
}