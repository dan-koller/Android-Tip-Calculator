package com.example.android_tip_calculator

import android.os.Bundle
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.widget.doOnTextChanged
import com.example.android_tip_calculator.CalculatorViewModel
import com.google.android.material.slider.Slider

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val calculator = CalculatorViewModel()

        // TODO: Rewrite functions to use lambda expressions
        calculator.getTip.observe(this) { tip ->
            findViewById<TextView>(R.id.text_view).text = tip
        }

        findViewById<EditText>(R.id.edit_text).doOnTextChanged { text, _, _, _ ->
            calculator.amountChange(text?.toString() ?: "")
        }

        findViewById<Slider>(R.id.slider).addOnChangeListener { _, value, _ ->
            calculator.percentChange(value.toDouble())
        }

    }
}