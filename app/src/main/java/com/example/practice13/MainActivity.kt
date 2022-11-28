package com.example.practice13

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val editText1:EditText=findViewById(R.id.editText1)
        editText1.requestFocus()
    }

    fun changeButton_Click(view: View) {
        val editText1:EditText=findViewById(R.id.editText1)
        val editText2:EditText=findViewById(R.id.editText2)
        val textView3:TextView=findViewById(R.id.textView3)
        if(editText1.text.isEmpty())
        {
            val toast1:Toast= Toast.makeText(applicationContext,"Введите курс обмена!",Toast.LENGTH_SHORT)
            toast1.show()
            editText1.requestFocus()
        }
        else if (editText2.text.isEmpty())
        {
            val toast2:Toast= Toast.makeText(applicationContext,"Введите сумму для обмена!",Toast.LENGTH_SHORT)
            toast2.show()
            editText2.requestFocus()
        }
        else{
            val res:Double=editText1.text.toString().toDouble()*editText2.text.toString().toDouble()
            textView3.text="${getResources().getString(R.string.result)} ${res.toString()}"
        }
    }

    fun triangleButton_Click(view: View) {
        val intent: Intent =Intent(this@MainActivity,TriangleActivity::class.java)
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP or Intent.FLAG_ACTIVITY_SINGLE_TOP)
        startActivity(intent)
    }
}