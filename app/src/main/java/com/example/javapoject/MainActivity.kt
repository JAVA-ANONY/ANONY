package com.example.javapoject

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val intent = Intent(this, CenterActivity::class.java)

        //버튼 지정
        val buttonView = findViewById<Button>(R.id.start_btn)
        //클릭리스너
        buttonView.setOnClickListener {
            //액티비티 이동
            startActivity(intent)
        }
    }
}




