package com.example.android

import android.content.Intent
import android.os.Bundle
import android.widget.ImageView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        stampChicker(R.id.imageView2, "happy")
        stampChicker(R.id.imageView3, "interest")
        stampChicker(R.id.imageView5, "nomal")
        stampChicker(R.id.imageView6, "nervous")
        stampChicker(R.id.imageView7, "angry")

    }

    fun stampChicker (stampImage : Int, name : String) {
        findViewById<ImageView>(stampImage).setOnClickListener {
            todayFeeling(name)
        }
    }

    fun todayFeeling (stamp : String) {
        val intent = Intent(this, SubActivity::class.java)
        intent.putExtra("feeling", stamp)
        startActivity(intent)
    }
}