package com.danilima.layoutapplication

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.danilima.layoutapplication.databinding.ActivityMainBinding
import com.google.android.material.snackbar.Snackbar

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        //        setContentView(R.layout.activity_main)
        setContentView(binding.root)

        binding.btnCalculate.setOnClickListener {
            val totalTableTemp = binding.tieTotal.text
            val numPeopleTemp = binding.tieTotalPeople.text
            val percentageTemp = binding.tiePercentage.text

            if (totalTableTemp?.isEmpty() == true || numPeopleTemp?.isEmpty() == true || percentageTemp?.isEmpty() == true) {
                Snackbar.make(binding.tieTotal, "Please fill in all fields", Snackbar.LENGTH_SHORT).show()
            } else {
                val totalTable: Float = totalTableTemp.toString().toFloat()
                val people: Int = numPeopleTemp.toString().toInt()
                val percentage: Int = percentageTemp.toString().toInt()

                val totalTemp = totalTable / people
                val tips = totalTemp * percentage / 100
                val totalWithTips = totalTemp + tips
                println(totalTemp)
                println(tips)
                println(totalWithTips)

                val intent = Intent(this, SummaryActivity::class.java)
                intent.apply {
                    putExtra("totalTable", totalTable)
                    putExtra("people", people)
                    putExtra("totalAmount", totalWithTips)
                    putExtra("percentage", percentage)
                }
                clear()
                startActivity(intent)
            }
        }
        binding.btnClear.setOnClickListener {
            binding.tieTotal.setText("")
            binding.btnClear.setOnClickListener {
                clear()
            }
        }
    }

    private fun clear() {
        binding.tieTotal.setText("")
        binding.tieTotalPeople.setText("")
        binding.tiePercentage.setText("")
    }
}
