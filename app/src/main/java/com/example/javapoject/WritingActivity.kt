package com.example.javapoject

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.View
import android.widget.*
import androidx.appcompat.app.AppCompatActivity


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
    }
}