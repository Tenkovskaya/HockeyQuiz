package com.tenkovskaya.hocceyquiz.game

import android.content.Intent
import android.graphics.Color
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.browser.customtabs.CustomTabsIntent
import com.tenkovskaya.hocceyquiz.R
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        bt_replay.setOnClickListener{
            bt_replay.isSelected != bt_replay.isSelected
            val intent = Intent(this, Question::class.java)
            startActivity(intent)
        }

    }
        }
