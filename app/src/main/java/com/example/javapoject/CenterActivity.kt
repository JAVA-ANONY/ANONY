package com.example.javapoject

import android.app.Activity
import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.*
import android.widget.AdapterView.OnItemLongClickListener
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.get
import java.io.Serializable
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter


class CenterActivity : AppCompatActivity() {
    private val memos = ArrayList<String>() // 글을 저장할 배열

    lateinit var time: String
    lateinit var title: String
    lateinit var grade: String
    lateinit var sub: String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.center)

        val listview = findViewById<ListView>(R.id.listview1)
        val writing_btn = findViewById<ImageButton>(R.id.writing_btn)
        val Delete_btn = findViewById<ImageButton>(R.id.Delete_btn)

        val memos_Adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, memos) // adapter 생성
        listview.adapter = memos_Adapter // 어댑터 붙이기
        listview.choiceMode = ListView.CHOICE_MODE_SINGLE // 단일 선택모드

        listview.setOnItemClickListener { parent, view, position, id -> // 글목록이 클릭되면
            Toast.makeText(this, (position + 1).toString() + "번째 글을 클릭하셨습니다.", Toast.LENGTH_SHORT).show() // 몇 번째 메모인지 출력
        }

        listview.setOnItemLongClickListener(OnItemLongClickListener { parent, v, position, id ->
            val clicklist = listview[position]

            val intentGoDetail = Intent(this, ListViewDetailActivity::class.java)
            intentGoDetail.putExtra("title", title)
            intentGoDetail.putExtra("time", time)
            intentGoDetail.putExtra("grade", grade)
            intentGoDetail.putExtra("sub", sub)
            startActivity(intentGoDetail)
            true
        })

        writing_btn.setOnClickListener { // 추가를 누르면
            val intentGoWrite = Intent(this, WritingActivity::class.java)
            startActivityForResult(intentGoWrite, 0) // 글작성 화면으로 이동
        }

        Delete_btn.setOnClickListener { // 삭제를 누르면
            val checkedItem = listview.checkedItemPosition // 클릭된 글의 인덱스를 가져옴

            if(checkedItem != -1){ // 클릭한 글이 있다면
                memos.removeAt(checkedItem) // 해당 인덱스의 글을 삭제
                memos_Adapter.notifyDataSetChanged() // 새로고침
                listview.clearChoices() // 클릭된 글을 선택 해제 시킴
                Toast.makeText(this, (checkedItem + 1).toString() + "번째 글을 삭제했습니다.", Toast.LENGTH_SHORT).show() // 삭제 메시지 출력
            }
        }

    }

    @RequiresApi(Build.VERSION_CODES.O)
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        when(resultCode){
            Activity.RESULT_OK -> { // resultCode가 RESULT_OK 라면 (글이 정상적으로 저장 되었다면)
                time = LocalDateTime.now().format(DateTimeFormatter.ofPattern("HH:mm:ss"))
                title = data?.getStringExtra("newWriting").toString()
                grade = data?.getStringExtra("newGrade").toString()
                sub = data?.getStringExtra("newSub").toString()
                if (data != null) { // 데이터가 비어있는지 확인하고
                    memos.add(0, LocalDateTime.now().format(DateTimeFormatter.ofPattern("HH:mm:ss"))+
                            "             "+
                            data.getStringExtra("newWriting").toString()+
                            "\n                                                                               "+
                            data.getStringExtra("newGrade").toString()) // 0번지에 글을 저장
                }
            }

            Activity.RESULT_CANCELED -> { // resultCode가 RESULT_CANCELED 라면 (뒤로가기를 둘러서 돌아왔다면)
                Toast.makeText(this, "작성이 취소되었습니다.", Toast.LENGTH_SHORT).show() // 작성 취소 메시지 출력
            }
        }
    }
}

private fun Intent.putExtra(s: String, clicklist: View) {

}

class Room(
    val title: String,
    val time: String,
    val grade: String
// 상속받는 것처럼 구현
) : Serializable {
}

