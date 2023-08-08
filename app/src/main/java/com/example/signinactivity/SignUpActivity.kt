package com.example.signinactivity

import android.app.Activity
import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContract

class SignUpActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_up)

        val name = findViewById<EditText>(R.id.editName)
        val idText = findViewById<EditText>(R.id.editId)
        val pwText = findViewById<EditText>(R.id.editPw)
        val join = findViewById<Button>(R.id.btn_join)

        // 회원가입
        join.setOnClickListener {
            val inputName = name.text.toString()
            val inputId = idText.text.toString()
            val inputPw = pwText.text.toString()
            if (inputName.isEmpty() || inputId.isEmpty() || inputPw.isEmpty()) {
                Toast.makeText(this, "입력되지 않은 정보가 있습니다.", Toast.LENGTH_SHORT).show()
            } else {
                val intent = Intent(this,SignInActivity::class.java)
                intent.putExtra("id", inputId)
                intent.putExtra("password", inputPw)
                setResult(Activity.RESULT_OK, intent)
                finish()
            }
        }
    }
}