package com.example.signinactivity

import android.annotation.SuppressLint
import android.app.Activity
import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContract
import androidx.activity.result.contract.ActivityResultContracts

class SignInActivity : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        setResultSignUp()

        val login = findViewById<Button>(R.id.btn_login)
        val join = findViewById<Button>(R.id.btn_join)
        val photo = findViewById<Button>(R.id.btn_photo)
        val idText = findViewById<EditText>(R.id.idText)
        val pwText = findViewById<EditText>(R.id.pwText)

        // 로그인
        login.setOnClickListener {
            val inputId = idText.text.toString()
            val inputPw = pwText.text.toString()
            if (inputId.isEmpty() || inputPw.isEmpty()) {
                Toast.makeText(this, "아이디/비밀번호를 확인해주세요.", Toast.LENGTH_SHORT).show()
            } else {
                Toast.makeText(this, "로그인 성공!", Toast.LENGTH_SHORT).show()
                val intent = Intent(this, HomeActivity::class.java)
                intent.putExtra("id", inputId)
                startActivity(intent)
            }
        }

        // 회원가입
        join.setOnClickListener {
            val intent = Intent(this,SignUpActivity::class.java)
            resultLauncher.launch(intent)
        }
        // 쿵야 앨범 보기
        photo.setOnClickListener {
            val intent = Intent(this,MainActivity::class.java)
            startActivity(intent)
        }

    }
    private lateinit var resultLauncher: ActivityResultLauncher<Intent>

    private fun setResultSignUp() {
        resultLauncher = registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { result ->
            if (result.resultCode == Activity.RESULT_OK) {
                val data: Intent? = result.data
                val inputId = data?.getStringExtra("id")
                val inputPw = data?.getStringExtra("password")
                val getId = findViewById<EditText>(R.id.idText)
                getId.setText(inputId)
                val getPw = findViewById<EditText>(R.id.pwText)
                getPw.setText(inputPw)
            }
        }
    }
}