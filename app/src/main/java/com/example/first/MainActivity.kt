package com.example.first

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import java.math.RoundingMode
import java.text.DecimalFormat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val button: Button = findViewById<Button>(R.id.button)
        val inputtext1: EditText = findViewById<EditText>(R.id.editTextText)
        val inputtext2: EditText = findViewById<EditText>(R.id.editTextText2)
        button.setOnClickListener {
            var result: String = ""
            val df = DecimalFormat("#.##")
            df.roundingMode = RoundingMode.DOWN
            when (inputtext1.text.toString()[0]){
                'c' -> {
                    val x = inputtext1.text.toString()
                    val a = x.removeRange(0,1).toDouble()
                    val S: Double
                    val b: Double
                    b = a * Math.sqrt(2.0)
                    S = Math.pow(a, 2.0)/2
                    result = "hypotenuse = " + df.format(b).toString() + " square = " + df.format(S).toString()
                }
                'h' -> {
                    val x = inputtext1.text.toString()
                    val b = x.removeRange(0,1).toDouble()
                    val a: Double
                    val S: Double
                    a = b / Math.sqrt(2.0)
                    S = Math.pow(b, 2.0) / 4
                    result = "cathet = " + df.format(a).toString() + " square = " + df.format(S).toString()
                }
                'S' -> {
                    val x = inputtext1.text.toString()
                    val S = x.removeRange(0,1).toDouble()
                    val a: Double
                    val b: Double
                    a = Math.sqrt(2 * S)
                    b = 2 * Math.sqrt(S)
                    result = "cathet = " + df.format(a).toString() + " hypotenuse = " + df.format(b).toString()
                }
            }
            inputtext2.setText(result)
        }
    }
}