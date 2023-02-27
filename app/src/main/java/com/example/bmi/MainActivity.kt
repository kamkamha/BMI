package com.example.bmi

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView
import kotlin.math.pow

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        val imageViewBMI: ImageView = findViewById(R.id.imageView)
        val textViewBMI: TextView = findViewById(R.id.textViewBMI)
        val textViewStatus: TextView = findViewById(R.id.textViewStatus)
        val weightInput: EditText = findViewById(R.id.weightText)
        val heightInput: EditText = findViewById(R.id.heightText)
        val buttonCalculate: Button = findViewById(R.id.buttonCalculate)
        val buttonReset: Button = findViewById(R.id.buttonReset)
        buttonCalculate.setOnClickListener{
            if(weightInput.text.isEmpty()){
                weightInput.setError(getString(R.string.value_required))
                return@setOnClickListener
            }
            if(heightInput.text.isEmpty()){
                heightInput.setError(getString(R.string.value_required))
                return@setOnClickListener
            }
            var weight = weightInput.text.toString().toFloat()
            var height = heightInput.text.toString().toFloat()
            var bmi = weight/(height/100).pow(2)

            if(bmi < 18.5){
                imageViewBMI.setImageResource(R.drawable.under)
                textViewBMI.text = String.format("%s : %.2f", getString(R.string.bmi),bmi)
                textViewStatus.text = String.format("%s : %s",getString(R.string.status),getString(R.string.under))
            }
            else if(bmi >= 18.5 && bmi < 25){
                imageViewBMI.setImageResource(R.drawable.normal)
                textViewBMI.text = String.format("%s : %.2f", getString(R.string.bmi),bmi)
                textViewStatus.text = String.format("%s : %s",getString(R.string.status),getString(R.string.normal))
            }
            else if(bmi >= 25){
                imageViewBMI.setImageResource(R.drawable.over)
                textViewBMI.text = String.format("%s : %.2f", getString(R.string.bmi),bmi)
                textViewStatus.text = String.format("%s : %s",getString(R.string.status),getString(R.string.over))
            }
        }
        buttonReset.setOnClickListener{
            weightInput.text.clear()
            heightInput.text.clear()
            imageViewBMI.setImageResource(R.drawable.empty)
            textViewBMI.text = getString(R.string.bmi)
            textViewStatus.text = getString(R.string.status)
        }
    }
}