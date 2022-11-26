package com.example.javapoject

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.View
import android.widget.ListView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat

class UploadActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.uploading)

        val getintent = intent
        var title = getintent.getStringExtra("title")

        var upload_txt = findViewById<TextView>(R.id.upload_txt)
        upload_txt.setText("\"" + title + "\"" + "\n가 업로드 되었습니다")

        // 일정 시간 지연 이후 실행하기 위한 코드
        Handler(Looper.getMainLooper()).postDelayed({


            // 일정 시간이 지나면 CenterActivity로 이동
            val uploadintent = Intent(this, CenterActivity::class.java)
            startActivity(uploadintent)


        }, 2500) // 시간 1.5초 이후 실행
    }
}