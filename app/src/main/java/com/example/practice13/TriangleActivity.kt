package com.example.practice13

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import java.lang.Math.*

class TriangleActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_triangle)
        val editText1Side:EditText=findViewById(R.id.editText1Side)
        editText1Side.requestFocus()
    }

    fun calculateButton_Click(view: View) {
        val editText1Side:EditText=findViewById(R.id.editText1Side)
        val editText2Side:EditText=findViewById(R.id.editText2Side)
        val hypotenuseText:TextView=findViewById(R.id.textViewHypotenuse)
        val perimeterText:TextView=findViewById(R.id.textViewPerimeter)
        val areaText:TextView=findViewById(R.id.textViewArea)
        if (editText1Side.text.isEmpty())
        {
            val toast1: Toast = Toast.makeText(applicationContext,"Введите длину 1 катета!", Toast.LENGTH_SHORT)
            toast1.show()
            editText1Side.requestFocus()
        }
        else if (editText2Side.text.isEmpty())
        {
            val toast2:Toast= Toast.makeText(applicationContext,"Введите длину 2 катета!",Toast.LENGTH_SHORT)
            toast2.show()
            editText2Side.requestFocus()
        }
        else
        {
            val hypotenuse:Double=sqrt(pow(editText1Side.text.toString().toDouble(),2.0)+pow(editText2Side.text.toString().toDouble(),2.0))
            val perimeter:Double=hypotenuse+editText1Side.text.toString().toDouble()+editText2Side.text.toString().toDouble()
            val area:Double=(editText1Side.text.toString().toDouble()*editText2Side.text.toString().toDouble())/2
            hypotenuseText.text="${getResources().getString(R.string.hypotenuse)} ${hypotenuse.toString()}"
            perimeterText.text="${getResources().getString(R.string.perimeter)} ${perimeter.toString()}"
            areaText.text="${getResources().getString(R.string.area)} ${area.toString()}"
        }
    }

    fun buttonBack_Click(view: View) {
        val intent:Intent=Intent(this@TriangleActivity,MainActivity::class.java)
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP or Intent.FLAG_ACTIVITY_SINGLE_TOP)
        startActivity(intent)
    }
}