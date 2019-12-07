package com.example.and08_recyclerview

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView

class PersonAdapter : RecyclerView.Adapter<PersonAdapter.ViewHolder>(), OnPersonItemClickListener {
    private var items = ArrayList<Person>() // 전체 데이터를 저장하는 변수
    private var listener: OnPersonItemClickListener? = null

    // onCreateViewHolder() : 뷰 홀더 생성 메소드
    // - 레이아웃을 적용하는 역할
    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): ViewHolder {
        val inflater = LayoutInflater.from(viewGroup.context)
        val itemView = inflater.inflate(R.layout.person_item, viewGroup, false)

        return ViewHolder(itemView, this)
    }

    // getItemCount() : 전체 아이템 개수 리턴 메소드
    override fun getItemCount(): Int {
        return items.size
    }

    // onBondViewHolder() : 특정 아이템을 뷰홀더에 적용하는 메소드
    override fun onBindViewHolder(viewHolder: ViewHolder, position: Int) {
        val item = items[position]
        viewHolder.setItem(item)
    }

    // items에 데이터 getter/setter
    fun setItems(items: ArrayList<Person>) {
        this.items = items
    }

    fun getItem(position: Int): Person {
        return items[position]
    }

    // 외부에서 리스너 객체를 받아와서 저장하는 역할의 메소드
    fun setOnItemClickListener(listener: OnPersonItemClickListener) {
        this.listener = listener
    }

    override fun onItemClick(holder: ViewHolder, view: View, position: Int) {
        listener?.onItemClick(holder, view, position)
    }

    //리사이클러 뷰 하나에 뷰 그룹에 데이터 및 이벤트를 적용
    inner class ViewHolder(itemView: View, listener: OnPersonItemClickListener) : RecyclerView.ViewHolder(itemView) {
        private var textView = itemView.findViewById<TextView>(R.id.textView)
        private var textView2 = itemView.findViewById<TextView>(R.id.textView2)

        // TODO: 아이템 클릭시 이벤트 발생 코드
        init{
            itemView.setOnClickListener {
                //현재 선택된 포지션 정보 저장
                val position = adapterPosition

                //선택된 뷰홀더의 이벤트 실행
                listener.onItemClick(this@ViewHolder, it, position)
            }
        }

        fun setItem(item: Person) {
            textView.text = item.name
            textView2.text = item.mobile
        }
    }


}