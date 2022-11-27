package com.example.javapoject

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import android.view.View
import android.widget.*
import android.widget.AdapterView.OnItemClickListener
import androidx.appcompat.app.AppCompatActivity


class WritingActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.writing)

        val spinner = findViewById<Spinner>(R.id.spinner)
        var grade: String = ""

        spinner.adapter = ArrayAdapter.createFromResource(
            this,
            R.array.spinner_arr,
            android.R.layout.simple_spinner_item
        )

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
                        grade = "1학년"
                    }
                    //2학년
                    1 -> {
                        grade = "2학년"
                    }
                    //3학년
                    2 -> {
                        grade = "3학년"
                    }
                    //일치하는게 없는 경우
                    else -> {
                        grade = "1학년"
                    }
                }
            }
        }

        var edittext = findViewById<EditText>(R.id.editText) // 내용
        val txtCnt = findViewById<TextView>(R.id.txtCnt) // 내용의 글자수

        edittext.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence, start: Int, count: Int, after: Int) {}
            override fun onTextChanged(s: CharSequence, start: Int, before: Int, count: Int) {}
            override fun afterTextChanged(s: Editable) {
                txtCnt.setText(s.length.toString() + " / 300") //글자수 TextView에 보여주기.
            }
        })

        val intent = Intent(this, CenterActivity::class.java)

        var edittext_title = findViewById<EditText>(R.id.edittext_title) // 제목


        val title = edittext_title.text.toString()
        val sub = edittext.text.toString()

        var temp = arrayOf(title, grade)

        //버튼 지정
        val buttonView = findViewById<ImageButton>(R.id.upload_btn)
        //클릭리스너
        buttonView.setOnClickListener {
            if (edittext_title.text.toString() == "") { // EditText가 비어있다면
                Toast.makeText(this, "저장할 내용이 없습니다.", Toast.LENGTH_SHORT).show() // 안내 문구 출력
            } else {
                intent.putExtra(
                    "newWriting",
                    edittext_title.text.toString()
                ) // 인텐트에 editText에 있는 내용 저장
                intent.putExtra(
                    "newGrade",
                    grade
                ) // 인텐트에 editText에 있는 내용 저장
                intent.putExtra(
                    "newSub",
                    edittext.text.toString()
                ) // 인텐트에 editText에 있는 내용 저장
                setResult(Activity.RESULT_OK, intent) // 정상 실행 되었다는 뜻으로 RESULT_OK 설정
                Toast.makeText(this, "글이 저장되었습니다.", Toast.LENGTH_SHORT).show() // 문구 출력
                finish() // 돌아가기
            }
        }


    }
}
