package com.example.javapoject

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.*
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat

class CenterActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.center)

        val intent = Intent(this, WritingActivity::class.java)

        //버튼 지정
        val buttonView = findViewById<ImageButton>(R.id.writing_btn)
        //클릭리스너
        buttonView.setOnClickListener {
            //액티비티 이동
            startActivity(intent)
        }

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

                // TODO : use item data.
            }

    }


}