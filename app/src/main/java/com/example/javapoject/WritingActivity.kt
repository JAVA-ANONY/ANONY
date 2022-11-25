package com.example.javapoject

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.View
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.room.Room


class WritingActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.writing)

        val spinner = findViewById<Spinner>(R.id.spinner)

        spinner.adapter = ArrayAdapter.createFromResource(this, R.array.spinner_arr, android.R.layout.simple_spinner_item)

        //아이템 선택 리스너
        spinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onNothingSelected(parent: AdapterView<*>?) {

            }

            override fun onItemSelected(
                parent: AdapterView<*>?, view: View?, position: Int, id: Long
            ) {
                when (position) {
                    //1학년
                    0 -> {

                    }
                    //2학년
                    1 -> {


                    }
                    //3학년
                    2 -> {


                    }
                    //일치하는게 없는 경우
                    else -> {

                    }
                }
            }
        }

        var edittext = findViewById<EditText>(R.id.editText)
        val txtCnt = findViewById<TextView>(R.id.txtCnt)

        edittext.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence, start: Int, count: Int, after: Int) {}
            override fun onTextChanged(s: CharSequence, start: Int, before: Int, count: Int) {}
            override fun afterTextChanged(s: Editable) {
                txtCnt.setText(s.length.toString() + " / 300") //글자수 TextView에 보여주기.
            }
        })

        val intent = Intent(this, UploadActivity::class.java)

        var edittext_title = findViewById<EditText>(R.id.edittext_title)


        //버튼 지정
        val buttonView = findViewById<ImageButton>(R.id.upload_btn)
        //클릭리스너
        buttonView.setOnClickListener {
            val title = edittext_title.text.toString()
            val sub = edittext.text.toString()

            val listviewPlus: ListView
            val adapterPlus: ListViewAdapter

            // Adapter 생성
            adapterPlus = ListViewAdapter()

            // 리스트뷰 참조 및 Adapter달기
            listviewPlus = findViewById<View>(R.id.listview1) as ListView
            listviewPlus.adapter = adapterPlus

            // 첫 번째 아이템 추가.
            adapterPlus.addItem(
                ContextCompat.getDrawable(this, R.drawable.img_like)!!,
                "test", "test"
            )

            //액티비티 이동
            intent.putExtra("title", edittext_title.text.toString())
            startActivity(intent)
        }
    }
}