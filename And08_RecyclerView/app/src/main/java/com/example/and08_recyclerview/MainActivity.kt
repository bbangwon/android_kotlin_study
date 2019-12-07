package com.example.and08_recyclerview

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.GridLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.View
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    private lateinit var recyclerView: RecyclerView
    private lateinit var adapter: PersonAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        recyclerView = findViewById(R.id.recyclerView)

        //리사이클러 뷰에 레이아웃 형태 지정
        val layoutManager = GridLayoutManager(this, 1)
        recyclerView.layoutManager = layoutManager

        adapter = PersonAdapter()
        var personList : List<Person> = mutableListOf<Person>()

        personList += Person("1", "010-111-111")
        personList += Person("2", "010-111-111")
        personList += Person("3", "010-111-111")
        personList += Person("4", "010-111-111")
        personList += Person("5", "010-111-111")
        personList += Person("6", "010-111-111")
        personList += Person("7", "010-111-111")
        personList += Person("8", "010-111-111")
        personList += Person("9", "010-111-111")

        adapter.setItems(personList as ArrayList<Person>)
        recyclerView.adapter = adapter

        adapter.setOnItemClickListener(object : OnPersonItemClickListener{
            override fun onItemClick(holder: PersonAdapter.ViewHolder, view: View, position: Int) {
                val item = adapter.getItem(position)

                //클릭 이벤트시 수행할 기능 구현
                Toast.makeText(applicationContext, "아이템 선택됨 ${item.name}", Toast.LENGTH_LONG).show()
            }
        })
    }
}
