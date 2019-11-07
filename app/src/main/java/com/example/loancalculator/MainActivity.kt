package com.example.loancalculator

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.inputmethod.InputMethodManager
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)



        btnCalculate.setOnClickListener()
        {
            calculate()
            val inputManager: InputMethodManager = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
            inputManager.hideSoftInputFromWindow(currentFocus.windowToken, InputMethodManager.SHOW_FORCED)
        }
    }
    fun calculate()
    {
        val carPrice:Double = carPrice_text.text.toString().toDouble()
        val downPayment:Double = downPayment_text.text.toString().toDouble()
        val loanPeriod:Int = loanPeriod_text.text.toString().toInt()
        val interestRate:Double = interestRate_text.text.toString().toDouble()

        var carLoan:Double = carPrice-downPayment
        var interest:Double = carLoan*interestRate*loanPeriod
        var repayment:Double = (carLoan+interest)/loanPeriod/12

        carLoan_label.text = "%.2f".format(carLoan)
        interest_label.text = "%.2f".format(interest)
        monthlyRepayment_label.text = "%.2f".format(repayment)



    }
}
