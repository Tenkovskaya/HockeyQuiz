package com.tenkovskaya.hocceyquiz.game

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.tenkovskaya.hocceyquiz.R
import com.tenkovskaya.hocceyquiz.data.DataSet
import kotlinx.android.synthetic.main.activity_result.*

class Result : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)
        window.decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_FULLSCREEN

        val score = intent.getStringExtra(DataSet.score)
        val totalQuestion = intent.getStringExtra("total size")

        Score.text = "$score / $totalQuestion"

        bt_replay.setOnClickListener {
            it.isSelected = !it.isSelected
            startActivity(Intent(this, MainActivity::class.java))
            finish()
        }
    }
}