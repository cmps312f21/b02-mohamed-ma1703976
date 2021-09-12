package com.example.bmiapp

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*
import kotlin.math.pow

class MainActivity : AppCompatActivity() {
    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        calculateBTN.setOnClickListener {

            val weightInput: Double = if (weight.text.toString()
                    .isEmpty()
            ) 0.0 else weight.text.toString().toDouble()
            val heightInput: Double = if (height.text.toString()
                    .isEmpty()
            ) 1.0 else height.text.toString().toDouble()

            val bmiScore = (weightInput / heightInput.pow(2.0))
            bmiResult.text = "Your BMI is %.2f".format(bmiScore)

            when {
                bmiScore < 18.5 -> statusResult.text = "under weight"
                24.9 > bmiScore && bmiScore > 18.5 -> statusResult.text =
                    "Normal weight"
                29.9 > bmiScore && bmiScore > 25 -> statusResult.text = "Overweight"
                bmiScore >= 30 -> statusResult.text = "Obese"
            }

        }
    }
}