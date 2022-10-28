package com.example.android_tip_calculator

import android.os.Bundle
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.widget.doOnTextChanged
import com.google.android.material.slider.Slider

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val calculator = CalculatorViewModel()

        // Get the views from the layout
        calculator.getTip.observe(this) { tip ->
            findViewById<TextView>(R.id.text_view).text = tip
        }

        // Display the tip when the amount changes
        findViewById<EditText>(R.id.edit_text).doOnTextChanged { text, _, _, _ ->
            calculator.amountChange(text?.toString() ?: "")
        }

        // Display the tip when the percent changes
        findViewById<Slider>(R.id.slider).addOnChangeListener { _, value, _ ->
            calculator.percentChange(value.toDouble())
        }
    }
}