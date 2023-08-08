package com.example.signinactivity

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView
import androidx.databinding.DataBindingUtil
import com.example.signinactivity.databinding.ActivityHomeBinding
import kotlin.random.Random

class HomeActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        val randomImg = findViewById<ImageView>(R.id.profile_img)
        when(Random.nextInt(1, 6)) {
            1 -> randomImg.setImageResource(R.drawable.profile_01)
            2 -> randomImg.setImageResource(R.drawable.profile_02)
            3 -> randomImg.setImageResource(R.drawable.profile_03)
            4 -> randomImg.setImageResource(R.drawable.profile_04)
            5 -> randomImg.setImageResource(R.drawable.profile_05)
        }

        val inputId = intent.getStringExtra("id")
        val idText = findViewById<TextView>(R.id.getId)
        idText.text = inputId

        val finish = findViewById<Button>(R.id.btn_finish)
        finish.setOnClickListener {
            finish()
        }

    }
}