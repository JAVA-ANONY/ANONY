package com.example.javapoject

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.*

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
    }
}