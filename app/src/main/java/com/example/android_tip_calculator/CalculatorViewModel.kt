package com.example.android_tip_calculator

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import java.text.DecimalFormat

class CalculatorViewModel : ViewModel() {
    private var amount = "" // Change to bill?
    private var percent = 0.0
    private var tip =
        { amount: Double, percent: Double ->
            DecimalFormat("0.00")
                .format(amount * percent / 100)
        }

    private var result = MutableLiveData<String>()

    // Get the tip value
    val getTip: LiveData<String>
        get() = result

    fun amountChange(text: String) {
        amount = text
        calculateTip()
    }

    fun percentChange(number: Double) {
        percent = number
        calculateTip()
    }

    private fun calculateTip() {
        result.value = if (amount == "" || amount == ".") "" else "Tip amount: ${
            tip(
                amount.toDouble(),
                percent
            )
        }"
    }

}