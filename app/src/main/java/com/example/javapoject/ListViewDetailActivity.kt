package com.example.javapoject

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class ListViewDetailActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list_view_detail)

        var intent = getIntent()

        var title = findViewById<TextView>(R.id.textview_title)
        var time = findViewById<TextView>(R.id.textview_time)
        var grade = findViewById<TextView>(R.id.textview_grade)
        var sub = findViewById<TextView>(R.id.textview)

        title.setText(intent.getStringExtra("title"))
        time.setText(intent.getStringExtra("time"))
        grade.setText(intent.getStringExtra("grade"))
        sub.setText(intent.getStringExtra("sub"))

    }


}