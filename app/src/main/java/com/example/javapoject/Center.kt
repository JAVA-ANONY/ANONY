package com.example.javapoject

import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ListView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat

class Center : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.center)

        val listview: ListView
        val adapter: ListViewAdapter

        // Adapter 생성
        adapter = ListViewAdapter()

        // 리스트뷰 참조 및 Adapter달기
        listview = findViewById<View>(R.id.listview1) as ListView
        listview.adapter = adapter

        // 첫 번째 아이템 추가.
        adapter.addItem(
            ContextCompat.getDrawable(this, R.drawable.img_like)!!,
            "Box", "Box"
        )
        // 두 번째 아이템 추가.
        adapter.addItem(
            ContextCompat.getDrawable(this, R.drawable.img_like)!!,

            "Circle", "Circle"
        )
        // 세 번째 아이템 추가.
        adapter.addItem(
            ContextCompat.getDrawable(this, R.drawable.img_like)!!,
            "Ind", "Ind"
        )
        // 네 번째 아이템 추가.
        adapter.addItem(
            ContextCompat.getDrawable(this, R.drawable.img_like)!!,
            "Apple", "Apple"
        )
        val listview2: ListView
        val adapter2: ListViewAdapter

        // Adapter 생성
        adapter2 = ListViewAdapter()

        // 리스트뷰 참조 및 Adapter달기
        listview2 = findViewById<View>(R.id.listview2) as ListView
        listview2.adapter = adapter2

        // 첫 번째 아이템 추가.
        adapter2.addItem(
            ContextCompat.getDrawable(this, R.drawable.img_like)!!,
            "Box", "Box "
        )
        // 두 번째 아이템 추가.
        adapter2.addItem(
            ContextCompat.getDrawable(this, R.drawable.img_like)!!,

            "Circle", "Circle"
        )
        // 세 번째 아이템 추가.
        adapter2.addItem(
            ContextCompat.getDrawable(this, R.drawable.img_like)!!,
            "Ind", "Ind"
        )
        // 네 번째 아이템 추가.
        adapter2.addItem(
            ContextCompat.getDrawable(this, R.drawable.img_like)!!,
            "Apple", "Apple"
        )

        val listview3: ListView
        val adapter3: ListViewAdapter

        // Adapter 생성
        adapter3 = ListViewAdapter()

        // 리스트뷰 참조 및 Adapter달기
        listview3 = findViewById<View>(R.id.listview3) as ListView
        listview3.adapter = adapter3

        // 첫 번째 아이템 추가.
        adapter3.addItem(
            ContextCompat.getDrawable(this, R.drawable.img_like)!!,
            "Box", "Box"
        )
        // 두 번째 아이템 추가.
        adapter3.addItem(
            ContextCompat.getDrawable(this, R.drawable.img_like)!!,

            "Circle", "Black"
        )
        // 세 번째 아이템 추가.
        adapter3.addItem(
            ContextCompat.getDrawable(this, R.drawable.img_like)!!,
            "Ind", "Ind"
        )
        // 네 번째 아이템 추가.
        adapter3.addItem(
            ContextCompat.getDrawable(this, R.drawable.img_like)!!,
            "Apple", "Apple"
        )

        // 위에서 생성한 listview에 클릭 이벤트 핸들러 정의.
        listview.onItemClickListener =
            AdapterView.OnItemClickListener { parent, v, position, id ->
                // get item
                val item = parent.getItemAtPosition(position) as ListViewItem

                val title = item.titleStr
                val desc = item.descStr
                val icon = item.iconDrawable

                // TODO : use item data.
            }
    }
}