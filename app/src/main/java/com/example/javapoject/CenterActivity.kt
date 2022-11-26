package com.example.javapoject

import android.app.Activity
import android.content.Intent
import android.icu.text.SimpleDateFormat
import android.os.Build
import android.os.Bundle
import android.system.Os.remove
import android.util.Log
import android.view.View
import android.widget.*
import android.widget.AdapterView.OnItemClickListener
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat


class CenterActivity : AppCompatActivity() {
    private val memos = ArrayList<String>() // 메모를 저장할 배열

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.center)

        val listview = findViewById<ListView>(R.id.listview1)
        val writing_btn = findViewById<ImageButton>(R.id.writing_btn)

        val memos_Adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, memos) // adapter 생성
        listview.adapter = memos_Adapter // 어댑터 붙이기
        listview.choiceMode = ListView.CHOICE_MODE_SINGLE // 단일 선택모드

        listview.setOnItemClickListener { parent, view, position, id -> // 메모 목록이 클릭되면
            Toast.makeText(this, (position + 1).toString() + "번째 메모를 클릭하셨습니다.", Toast.LENGTH_SHORT).show() // 몇 번째 메모인지 출력
        }

        writing_btn.setOnClickListener { // 메모 추가를 누르면
            val intentGoWrite = Intent(this, WritingActivity::class.java)
            startActivityForResult(intentGoWrite, 0) // 메모 작성 화면으로 이동
        }

    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        when(resultCode){
            Activity.RESULT_OK -> { // resultCode가 RESULT_OK 라면 (메모가 정상적으로 저장 되었다면)
                if (data != null) { // 데이터가 비어있는지 확인하고
                    memos.add(0, data.getStringExtra("newWriting").toString()) // 0번지에 메모를 저장
                }
            }

            Activity.RESULT_CANCELED -> { // resultCode가 RESULT_CANCELED 라면 (뒤로가기를 둘러서 돌아왔다면)
                Toast.makeText(this, "작성이 취소되었습니다.", Toast.LENGTH_SHORT).show() // 작성 취소 메시지 출력
            }
        }
    }
}


